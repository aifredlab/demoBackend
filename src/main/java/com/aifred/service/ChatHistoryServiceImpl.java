package com.aifred.service;

import com.aifred.dto.ChatHistoryDto;
import com.aifred.entity.ChatHistory;
import com.aifred.repository.ChatHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChatHistoryServiceImpl implements ChatHistoryService{
    @Autowired
    ChatHistoryRepository chatHistoryRepository;

    @Override
    public ChatHistoryDto getChatHistory(String id) {
        Optional<ChatHistory> optionalChatHistory = chatHistoryRepository.findById(id);

        if (optionalChatHistory.isPresent()) {
            ChatHistory chatHistory = optionalChatHistory.get();

            ChatHistoryDto chatHistoryDto = new ChatHistoryDto();
            chatHistoryDto.setId(chatHistory.getId());
            chatHistoryDto.setQuestion(chatHistory.getQuestion());
            chatHistoryDto.setCreatedAt(chatHistory.getCreatedAt());
            chatHistoryDto.setRefContents(chatHistory.getRefContents());
            chatHistoryDto.setMemberId(chatHistory.getMemberId());
            return chatHistoryDto;
        } else {
            return null;
        }
    }

    @Override
    public List<ChatHistoryDto> getChatHistoryListByMemberId(String memberId) {
        List<ChatHistory> list = chatHistoryRepository.findByMemberId(memberId);

        List<ChatHistoryDto> returnList = new ArrayList<ChatHistoryDto>();
        for(ChatHistory chatHistory: list) {
            ChatHistoryDto chatHistoryDto = new ChatHistoryDto();
            chatHistoryDto.setId(chatHistory.getId());
            chatHistoryDto.setQuestion(chatHistory.getQuestion());
            chatHistoryDto.setCreatedAt(chatHistory.getCreatedAt());
            chatHistoryDto.setRefContents(chatHistory.getRefContents());
            chatHistoryDto.setMemberId(chatHistory.getMemberId());
            returnList.add(chatHistoryDto);
        }

        return returnList;
    }

    @Override
    public void createChatHistory(ChatHistoryDto chatHistoryDto) {
        ChatHistory chatHistory = new ChatHistory();
        chatHistory.setId(chatHistoryDto.getId());
        chatHistory.setQuestion(chatHistoryDto.getQuestion());
        chatHistory.setCreatedAt(chatHistoryDto.getCreatedAt());
        chatHistory.setRefContents(chatHistoryDto.getRefContents());
        chatHistory.setMemberId(chatHistoryDto.getMemberId());

        chatHistoryRepository.save(chatHistory);
    }

    @Override
    public void removeChatHistory(String id) {
        chatHistoryRepository.deleteById(id);
    }

    @Override
    public void removeChatHistoryByMemberId(String memberId) {
        chatHistoryRepository.deleteByMemberId(memberId);
    }
}
