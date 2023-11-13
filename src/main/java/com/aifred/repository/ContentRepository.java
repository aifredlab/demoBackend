package com.aifred.repository;

import com.aifred.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {

    //Optional<Content> findByMessageId(Long messageId);

    /**
     * memberId로 채팅이력 삭제
     * @param memberId
     */
    void deleteByCreatedBy(Long memberId);
}
