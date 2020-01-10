package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberUpdateRequest;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberUpdateService {

    private final MemberRepository memberRepository;
    private final JwtService jwtService;

    public MemberUpdateService(MemberRepository memberRepository, JwtService jwtService) {
        this.memberRepository = memberRepository;
        this.jwtService = jwtService;
    }

    public void updateMember(MemberUpdateRequest memberUpdateRequest, String token) {
        String email = jwtService.findEmailByJwt(token);
        Member member = memberRepository.findByEmail(email).orElseThrow(MemberNotFoundException::new);

        member.updateMember(memberUpdateRequest);

        memberRepository.save(member);
    }
}
