package com.aifred.controller;

import com.aifred.dto.MemberDto;
import com.aifred.entity.Insurance;
import com.aifred.exception.AifredBusinessException;
import com.aifred.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     *
     * @param memberDto
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody MemberDto memberDto) throws AifredBusinessException {
        log.debug("memberDto={}", memberDto);
        //MemberDto returnedMemberDto = memberService.getMemberByEmail(memberDto.getId());
//        if (returnedMemberDto == null) {
//            throw new AifredBusinessException(ExceptionCode.USER_NOT_FOUND);
//        } else {
//               }
//
//        return null;

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<List<Insurance>> logout(@RequestParam String id) {

        //이미 존재하는지 확인



        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/isRedundantEmail/{email}")
    public ResponseEntity<Boolean> isRedundantEmail(@RequestParam String email) {
        Boolean isRedundant = memberService.isRedundantEmail(email);
        return new ResponseEntity<Boolean>(isRedundant, HttpStatus.OK);
    }

    /**
     * 사용자 가입처리
     * @param memberDto
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<List<Insurance>> register(@RequestBody MemberDto memberDto) throws AifredBusinessException {
        MemberDto returnMemberDto = memberService.createMember(memberDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 탈퇴 처리
     * @param id
     * @return
     */
    @PostMapping("/unregister")
    public ResponseEntity unregister(@RequestParam Long id) {
        memberService.removeMember(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
