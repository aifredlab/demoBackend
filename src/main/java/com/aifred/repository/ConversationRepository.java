package com.aifred.repository;

import com.aifred.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation, String> {

//
//    /**
//     * id로 채팅이력 조회
//     * @param id
//     * @return
//     */
//    //Optional<ChatHistory> findById(String id);
//
    /**
     * id로 채팅이력 조회
     * @param memberId
     * @return
     */
    List<Conversation> findByCreatedBy(Long memberId);
//
//    /**Ï
//     * 채팅 이력 저장
//     * @param chatHistory
//     * @return
//     */
//    //ChatHistory save(ChatHistory chatHistory);
//
//    /**
//     * ID로 채팅이력 삭제
//     * @param id
//     */
//    //void deleteById(String id);
//
//
//    /**
//     * memberId로 채팅이력 삭제
//     * @param memberId
//     */
//    void deleteByMemberId(String memberId);

}
