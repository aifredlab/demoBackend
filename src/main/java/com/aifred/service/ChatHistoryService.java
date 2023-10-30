package com.aifred.service;

import com.aifred.dto.ChatHistoryDto;

import java.util.List;

public interface ChatHistoryService {
    ChatHistoryDto getChatHistory(String id);

    List<ChatHistoryDto> getChatHistoryListByMemberId(String userId);

    void createChatHistory(ChatHistoryDto chatHistoryDto);

    void removeChatHistory(String id);

    void removeChatHistoryByMemberId(String userId);
}
