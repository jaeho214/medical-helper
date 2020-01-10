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

        Optional<Member> member = Optional.ofNullable(memberRepository.findByEmail(email).orElseThrow(MemberNotFoundException::new));

        return MemberGetResponse.builder()
                .email(member.get().getEmail())
                .name(member.get().getName())
                .phone(member.get().getPhone())
                .birth(member.get().getBirth())
                .sex(member.get().getSex())
                .address(member.get().getAddress())
                .build();

    }
}
