package com.aifred.service;

import com.aifred.dto.ChatHistoryDto;
import com.aifred.entity.Content;
import com.aifred.entity.Conversation;
import com.aifred.entity.Message;
import com.aifred.repository.ContentRepository;
import com.aifred.repository.ConversationRepository;
import com.aifred.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ChatHistoryServiceImpl {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ConversationRepository conversationRepository;


    ChatHistoryDto getChatHistory(String id) {
        return null;
    }

//    List<ChatHistoryDto> getChatHistoryListByMemberId(String userId) {
//
//
//    }

    void createChatHistory(ChatHistoryDto chatHistoryDto) {
        String memberId = "0000000000"; //TODO:하드코딩 수정

        Content content = new Content();
        content.setContent(chatHistoryDto.getRefContents());
        content.setCreatedBy(memberId);
        Content insertedContent = contentRepository.save(content);

        Message message = new Message();
        message.setText(chatHistoryDto.getQuestion());
        message.setCreatedBy(memberId);
        Message insertedMessage = messageRepository.save(message);

        Conversation conversation = new Conversation();
        conversation.setContentId(content.getId());
        conversation.setMessageId(insertedMessage.getId());
        conversationRepository.save(conversation);


    }

    void removeChatHistory(String id) {

    }

    void removeChatHistoryByMemberId(String userId) {

    }
}
