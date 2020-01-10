package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.stereotype.Service;

@Service
public class MemberDeleteService {

    private final MemberRepository memberRepository;
    private final JwtService jwtService;

    public MemberDeleteService(MemberRepository memberRepository, JwtService jwtService) {
        this.memberRepository = memberRepository;
        this.jwtService = jwtService;
    }

    public Member deleteMember(String token){
        String email = jwtService.findEmailByJwt(token);

        Member member = memberRepository.findByEmail(email).orElseThrow(MemberNotFoundException::new);
        //member.delete();
        memberRepository.delete(member);
        return member;
    }
}
