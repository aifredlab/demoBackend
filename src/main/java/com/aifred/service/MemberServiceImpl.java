package com.aifred.service;


import com.aifred.dto.MemberDto;
import com.aifred.exception.AifredBusinessException;
import com.aifred.exception.ExceptionCode;
import com.aifred.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.aifred.entity.Member;

import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public MemberDto getMemberById(String id) throws AifredBusinessException {

        Optional<Member> optionalMember = memberRepository.findById(id);
        Member member = optionalMember.orElseThrow(() -> new AifredBusinessException(ExceptionCode.USER_NOT_FOUND));

        //DTO로 변환
        MemberDto memberDto = new MemberDto();
        memberDto.setId(member.getId());
        memberDto.setCompany(member.getCompany());
        memberDto.setName(member.getName());
        memberDto.setEmail(member.getEmail());
        return memberDto;
    }

    @Override
    public MemberDto createMember(MemberDto memberDto) throws AifredBusinessException {
        //email 이미 있으면 exception throw
        Optional<Member> optionalMember = memberRepository.findByEmail(memberDto.getEmail());
        if (optionalMember.isPresent()) throw new AifredBusinessException(ExceptionCode.USER_EMAIL_EXISTS);

        Member member = new Member();
        member.setId(memberDto.getId());
        member.setCompany(memberDto.getCompany());
        member.setName(memberDto.getName());
        member.setEmail(memberDto.getEmail());
        member.setPassword(passwordEncoder.encode(memberDto.getPassword())); //TODO:

        memberRepository.save(member);
        return memberDto;
    }

    @Override
    public boolean isRedundantEmail(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        return optionalMember.isPresent();
    }

    @Override
    public void removeMember(String id) {
        memberRepository.deleteById(id);
    }

    @Override
    public MemberDto login(MemberDto memberDto) throws AifredBusinessException {
        Optional<Member> optionalMember = memberRepository.findById(memberDto.getId());
        Member member = optionalMember.orElseThrow(() -> new AifredBusinessException(ExceptionCode.USER_NOT_FOUND));
        return null;
    }

    @Override
    public MemberDto logout(String id) {
        return null;
    }
}
