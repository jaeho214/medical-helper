package kr.ac.skuniv.medicalhelper.domain.member.controller;

import kr.ac.skuniv.medicalhelper.domain.member.dto.*;
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
    public void createMember(@RequestBody MemberCreateRequest memberCreateRequest){
        memberCreateService.createMember(memberCreateRequest);
    }

    @PostMapping("/signIn")
    public MemberSignInResponse signInMember(@RequestBody MemberSignInRequest memberSignInRequest){
        return memberSignInService.signInMember(memberSignInRequest);
    }

    //TODO: 시큐리티 적용
    @GetMapping
    public MemberGetResponse selectMember(@RequestParam("userId") String userId){
        return memberGetService.selectMember(userId);
    }

    //TODO: MemberUpdateRequest에서 userId 빼고 시큐리티로 적용시키기
    @PutMapping
    public void updateMember(@RequestBody MemberUpdateRequest memberUpdateRequest){
        memberUpdateService.updateMember(memberUpdateRequest);
    }

    @DeleteMapping
    public void deleteMember(@RequestParam("userId") String userId){
        memberDeleteService.deleteMember(userId);
    }

    @GetMapping("/checkId")
    public boolean checkDuplicatedId(@RequestParam("userId") String userId){
        return checkDuplicatedIdService.checkId(userId);
    }


}
