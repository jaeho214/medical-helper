package kr.ac.skuniv.medicalhelper.domain.member.controller;

import kr.ac.skuniv.medicalhelper.domain.member.dto.*;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/medicalHelper/sign")
public class MemberController {

    private final MemberCreateService memberCreateService;
    private final MemberSignInService memberSignInService;
    private final MemberGetService memberGetService;
    private final MemberUpdateService memberUpdateService;
    private final MemberDeleteService memberDeleteService;
    private final CheckDuplicatedIdService checkDuplicatedIdService;


    @PostMapping("/signUp")
    public Member createMember(@RequestBody MemberCreateRequest memberCreateRequest){
        return memberCreateService.createMember(memberCreateRequest);
    }

    @PostMapping("/signIn")
    public MemberSignInResponse signInMember(@RequestBody MemberSignInRequest memberSignInRequest){
        return memberSignInService.signInMember(memberSignInRequest);
    }

    @GetMapping
    public MemberGetResponse selectMember(@RequestHeader("token") String token){
        return memberGetService.getMember(token);
    }

    @PutMapping
    public void updateMember(@RequestBody MemberUpdateRequest memberUpdateRequest,
                             @RequestHeader("token") String token){
        memberUpdateService.updateMember(memberUpdateRequest, token);
    }

    @DeleteMapping
    public void deleteMember(@RequestHeader("token") String token){
        memberDeleteService.deleteMember(token);
    }

    @GetMapping("/checkId")
    public boolean checkDuplicatedId(@RequestParam("email") String email){
        return checkDuplicatedIdService.checkId(email);
    }



}
