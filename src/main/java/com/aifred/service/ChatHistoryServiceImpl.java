package com.aifred.service;

import com.aifred.dto.ChatHistoryDto;
import com.aifred.entity.Content;
import com.aifred.entity.Conversation;
import com.aifred.entity.Message;
import com.aifred.repository.ContentRepository;
import com.aifred.repository.ConversationRepository;
import com.aifred.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatHistoryServiceImpl implements ChatHistoryService {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ConversationRepository conversationRepository;


    @Override
    public ChatHistoryDto getChatHistory(String id) {
        return null;
    }

    @Override
    public List<ChatHistoryDto> getChatHistoryListByMemberId(String userId) {
        return null;
    }

    @Override
    public void createChatHistory(ChatHistoryDto chatHistoryDto) {
        Long memberId = 0L; //TODO:하드코딩 수정
        Long conversationId = chatHistoryDto.getConversationId();

        //conversation 입력
        if (conversationId == null) {
            Conversation conversation = new Conversation();
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
    }

    @Override
    public void removeChatHistory(String id) {

    }

    @Override
    public void removeChatHistoryByMemberId(String userId) {

    }


}
