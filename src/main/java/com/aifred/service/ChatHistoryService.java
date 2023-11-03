package com.aifred.service;

import com.aifred.dto.ChatHistoryDto;
import com.aifred.dto.ConversationDto;

import java.util.List;

public interface ChatHistoryService {
    ChatHistoryDto getChatHistory(Long id);

    List<ConversationDto> getChatHistoryList();

    void createChatHistory(ChatHistoryDto chatHistoryDto);

    void removeChatHistory(Long id);

    void removeChatHistoryByMemberId(Long userId);
}
