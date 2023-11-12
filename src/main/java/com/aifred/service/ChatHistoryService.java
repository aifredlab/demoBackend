package com.aifred.service;

import com.aifred.dto.ChatHistoryDto;
import com.aifred.dto.ConversationDto;
import com.aifred.dto.MessageDto;
import com.aifred.dto.QuestionRequestDto;

import java.util.List;

public interface ChatHistoryService {
    public ChatHistoryDto getChatHistory(Long id);

    public List<ConversationDto> getChatHistoryListByMemberId(Long memberId);

    public Long createChatHistory(ChatHistoryDto chatHistoryDto);

    public void removeChatHistory(Long id);

    public void removeChatHistoryByMemberId(Long userId);

    public List<MessageDto> getChatHistoryDetail(Long id);

    public QuestionRequestDto createConversation(QuestionRequestDto questionRequestDto);

    public Long createRequestMessage(QuestionRequestDto questionRequestDto);

    public Long createResponseMessage(QuestionRequestDto questionRequestDto);

    public Long createContent(String contentText);


}
