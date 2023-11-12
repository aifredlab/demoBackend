package com.aifred.service;

import com.aifred.dto.*;
import com.aifred.entity.Content;
import com.aifred.entity.Conversation;
import com.aifred.entity.Message;
import com.aifred.repository.ContentRepository;
import com.aifred.repository.ConversationRepository;
import com.aifred.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ChatHistoryServiceImpl implements ChatHistoryService {
    Long memberId = 1000000000L; //TODO:하드코딩 수정

    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ConversationRepository conversationRepository;
    @Override
    public ChatHistoryDto getChatHistory(Long id) {
        return null;
    }

    @Override
    public List<ConversationDto> getChatHistoryListByMemberId(Long memberId) {
        List<Conversation> list = conversationRepository.findByCreatedBy(memberId);

        List<ConversationDto> chatHistoryList = new ArrayList<ConversationDto>();
        for (Conversation conversation: list) {
            ConversationDto conversationDto = new ConversationDto();
            conversationDto.setId(conversation.getId());
            conversationDto.setTitle(conversation.getTitle());
            conversationDto.setCreatedAt(conversation.getCreatedAt());
            chatHistoryList.add(conversationDto);
        }
        return chatHistoryList;
    }

    @Override
    public List<MessageDto> getChatHistoryDetail(Long conversationId) {

        Long memberId = 1000000000L; //TODO:하드코딩 수정
        //계정검증

        List<MessageDto> messageDtoList = new ArrayList<MessageDto>();

        //TODO:추후 querydsl로 join으로
        List<Message> messageList = messageRepository.findByConversationId(conversationId);
        for (Message message: messageList) {
            MessageDto messageDto = new MessageDto();
            messageDto.setType(message.getType());
            messageDto.setId(message.getId());
            messageDto.setText(message.getText());

            if (message.getContentId() != null) {
                Optional<Content> content = contentRepository.findById(message.getContentId());
                if (content.isPresent()) {
                    messageDto.setContentId(content.get().getId());
                    messageDto.setContent(content.get().getContent());
                }
            }

            messageDtoList.add(messageDto);
        }
        return messageDtoList;
    }



    @Override
    public Long createChatHistory(ChatHistoryDto chatHistoryDto) {

        Long conversationId = chatHistoryDto.getConversationId();

        //conversation 입력
        if (conversationId == null) {
            Conversation conversation = new Conversation();
            conversation.setTitle(chatHistoryDto.getQuestion());
            conversation.setCreatedBy(memberId);
            Conversation insertedConversation = conversationRepository.save(conversation);
            conversationId = insertedConversation.getId();
        }

        Message questionMessage = new Message();
        questionMessage.setText(chatHistoryDto.getQuestion());
        questionMessage.setCreatedBy(memberId);
        questionMessage.setType("1"); //type==질문
        questionMessage.setConversationId(conversationId);
        Message insertedQuestionMessage = messageRepository.save(questionMessage);

        Message answerMessage = new Message();
        answerMessage.setText(chatHistoryDto.getAnswer());
        answerMessage.setCreatedBy(memberId);
        answerMessage.setType("2"); //type==질문
        answerMessage.setConversationId(conversationId);
        Message insertedAnswerMessage = messageRepository.save(answerMessage);

        if ( !"".equals(chatHistoryDto.getContent())) {
            Content content = new Content();
            content.setContent(chatHistoryDto.getContent());
            content.setCreatedBy(memberId);
            //content.setMessageId(insertedAnswerMessage.getId());
            Content insertedContent = contentRepository.save(content);
        }
        return conversationId;
    }

    @Override
    public void removeChatHistory(Long conversationId) {
        List<Message> messageList = messageRepository.findByConversationId(conversationId);
        for (Message message: messageList) {
            contentRepository.deleteById(message.getContentId());
            messageRepository.deleteById(message.getId());
        }
        conversationRepository.deleteById(conversationId);
    }

    @Override
    public void removeChatHistoryByMemberId(Long memberId) {
        contentRepository.deleteByCreatedBy(memberId);
        messageRepository.deleteByCreatedBy(memberId);
        conversationRepository.deleteByCreatedBy(memberId);
    }


    @Override
    public QuestionRequestDto createConversation(QuestionRequestDto questionRequestDto) {
        Long conversationId = questionRequestDto.getConversationId();
        if (conversationId == null) {
            Conversation conversation = new Conversation();
            conversation.setTitle(questionRequestDto.getQuestion());
            conversation.setCreatedBy(memberId);
            Conversation insertedConversation = conversationRepository.save(conversation);

            questionRequestDto.setConversationId(insertedConversation.getId());
            questionRequestDto.setCreatedAt(insertedConversation.getCreatedAt());
        }
        return questionRequestDto;
    }

    public Long createContent(String contentText) {
        if (StringUtils.hasLength(contentText)) {
            Content content = new Content();
            content.setContent(contentText);
            content.setCreatedBy(memberId);
            Content insertedContent = contentRepository.save(content);
            return insertedContent.getId();
        }

        return null;
    }

    public Long createRequestMessage(QuestionRequestDto questionRequestDto) {
        Message questionMessage = new Message();
        questionMessage.setText(questionRequestDto.getQuestion());
        questionMessage.setCreatedBy(memberId);
        questionMessage.setType("1"); //type==질문
        questionMessage.setConversationId(questionRequestDto.getConversationId());
        questionMessage.setContentId(questionRequestDto.getContentId());
        questionMessage.setText(questionRequestDto.getQuestion());
        Message insertedQuestionMessage = messageRepository.save(questionMessage);
        return insertedQuestionMessage.getId();
    }

    public Long createResponseMessage(QuestionRequestDto questionRequestDto) {
        Message questionMessage = new Message();
        questionMessage.setText(questionRequestDto.getResponse());
        questionMessage.setCreatedBy(memberId);
        questionMessage.setType("2"); //type==시스템의 답변
        questionMessage.setConversationId(questionRequestDto.getConversationId());
        questionMessage.setContentId(questionRequestDto.getContentId());
        Message insertedQuestionMessage = messageRepository.save(questionMessage);
        return insertedQuestionMessage.getId();
    }


}
