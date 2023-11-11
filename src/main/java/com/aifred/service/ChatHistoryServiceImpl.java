package com.aifred.service;

import com.aifred.dto.ChatHistoryDto;
import com.aifred.dto.ConversationDto;
import com.aifred.dto.MessageDto;
import com.aifred.entity.Content;
import com.aifred.entity.Conversation;
import com.aifred.entity.Message;
import com.aifred.repository.ContentRepository;
import com.aifred.repository.ConversationRepository;
import com.aifred.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChatHistoryServiceImpl implements ChatHistoryService {
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
    public List<ConversationDto> getChatHistoryList() {
        Long memberId = 1000000000L; //TODO:하드코딩 수정
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
    public List<Message> getChatHistoryDetail(Long conversationId) {

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

            Optional<Content> content = contentRepository.findByMessageId(message.getId());
            if (content.isPresent()) {
                messageDto.setContent(message.getText());
            }
        }
        return messageList;
    }

    @Override
    public Long createChatHistory(ChatHistoryDto chatHistoryDto) {
        Long memberId = 1000000000L; //TODO:하드코딩 수정
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
            content.setMessageId(insertedAnswerMessage.getId());
            Content insertedContent = contentRepository.save(content);
        }
        
        return conversationId;
    }

    @Override
    public void removeChatHistory(Long id) {

    }

    @Override
    public void removeChatHistoryByMemberId(Long userId) {

    }




}
