package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberGetResponse;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberGetService {

    private final MemberRepository memberRepository;
    private final JwtService jwtService;

    public MemberGetService(MemberRepository memberRepository, JwtService jwtService) {
        this.memberRepository = memberRepository;
        this.jwtService = jwtService;
    }

    public MemberGetResponse selectMember(String token) {

        String email = jwtService.findEmailByJwt(token);

        Member member = memberRepository.findByEmail(email).orElseThrow(MemberNotFoundException::new);

        return MemberGetResponse.builder()
                .email(member.getEmail())
                .name(member.getName())
                .phone(member.getPhone())
                .birth(member.getBirth())
                .sex(member.getSex())
                .address(member.getAddress())
                .build();

    }
}
