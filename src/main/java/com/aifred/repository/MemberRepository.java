package com.aifred.repository;

import com.aifred.entity.Member;
import com.aifred.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    /**
     *  사용자 리스트 조회
     * @return
     */
    //List<Member> findAll();

    /**
     * id로 사용자 조회
     * @param id
     * @return
     */
    //Optional<Member> findById(String id);

    /**
     * email로 조회
     * @param email
     * @return
     */
    Optional<Member> findByEmail(String email);

    /**
     * 사용자 저장
     * @param member
     * @return
     */
    //Member save(Member member);

    /**
     * ID로 사용자 삭제
     * @param id
     */
    //void deleteById(String id);




}
