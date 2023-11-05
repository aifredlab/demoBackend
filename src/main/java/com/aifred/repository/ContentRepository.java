package com.aifred.repository;

import com.aifred.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content, Long> {

    Optional<Content> findByMessageId(Long messageId);

//
//    /**
//     * id로 채팅이력 조회
//     * @param id
//     * @return
//     */
//    //Optional<ChatHistory> findById(String id);
//
//    /**
//     * id로 채팅이력 조회
//     * @param memberId
//     * @return
//     */
//    List<ChatHistory> findByMemberId(String memberId);
//
//    /**
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
