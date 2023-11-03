package com.aifred.controller;

import com.aifred.dto.ChatHistoryDto;
import com.aifred.dto.ConversationDto;
import com.aifred.service.ChatHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/chatHistory")
public class ChatHistoryController {

    @Autowired
    private ChatHistoryService chatHistoryService;

    /**
     * 채팅이력 조회
     *
     * @param id
     * @return
     */
    @GetMapping("/createChatHistory/{id}")
    public ResponseEntity<ChatHistoryDto> getChatHistory(@PathVariable Long id) {
        ChatHistoryDto chatHistoryDto = chatHistoryService.getChatHistory(id);
        return new ResponseEntity<ChatHistoryDto>(chatHistoryDto, HttpStatus.OK);
    }

    /**
     * userId로 채팅이력 리스트 조회
     *
     * @return
     */
    @GetMapping("/getChatHistoryList")
    public ResponseEntity<List<ConversationDto>> getChatHistoryList() {
        List<ConversationDto> chatHistoryDtoList = chatHistoryService.getChatHistoryList();
        return new ResponseEntity<List<ConversationDto>>(chatHistoryDtoList, HttpStatus.OK);
    }

    /**
     * 채팅이력 생성
     *
     * @param chatHistoryDto
     * @return
     */
    @PostMapping("/createChatHistory")
    public ResponseEntity createChatHistory(@RequestBody ChatHistoryDto chatHistoryDto) {
        chatHistoryService.createChatHistory(chatHistoryDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/removeChatHistory/{id}")
    public ResponseEntity removeChatHistory(@PathVariable Long id) {
        chatHistoryService.removeChatHistory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/removeChatHistoryByMemberId/{userId}")
    public ResponseEntity removeChatHistoryByMemberId(@PathVariable Long userId) {
        chatHistoryService.removeChatHistoryByMemberId(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
