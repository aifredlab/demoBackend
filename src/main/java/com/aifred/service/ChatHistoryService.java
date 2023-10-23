package com.aifred.service;

import com.aifred.dto.ChatHistoryDto;
import com.aifred.exception.AifredBusinessException;

import java.util.List;

public interface ChatHistoryService {

    public ChatHistoryDto getChatHistory(String id);

    public List<ChatHistoryDto> getChatHistoryListByMemberId(String memberId);

    public void createChatHistory(ChatHistoryDto chatHistoryDto);

    public void removeChatHistory(String id);

    public void removeChatHistoryByMemberId(String memberId);


}
