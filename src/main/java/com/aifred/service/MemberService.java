package com.aifred.service;

import com.aifred.dto.MemberDto;
import com.aifred.exception.AifredBusinessException;

public interface MemberService {

    public MemberDto getMemberById(Long id) throws AifredBusinessException;

    public MemberDto createMember(MemberDto memberDto) throws AifredBusinessException;

    public boolean isRedundantEmail(String email);

    public void removeMember(Long id);

    public MemberDto login(MemberDto memberDto) throws AifredBusinessException;

    public MemberDto logout(String id);











}
