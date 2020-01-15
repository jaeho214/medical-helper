package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberSignInRequest;
import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberSignInResponse;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.InvalidPasswordException;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberSignInService {
    private MemberRepository memberRepository;
    private JwtService jwtService;

    public MemberSignInService(MemberRepository memberRepository, JwtService jwtService) {
        this.memberRepository = memberRepository;
        this.jwtService = jwtService;
    }

    public MemberSignInResponse signInMember(MemberSignInRequest memberSignInRequest) {

        Member member = memberRepository.findByEmail(memberSignInRequest.getEmail()).orElseThrow(MemberNotFoundException::new);

        isEqualPw(member.getPassword(), memberSignInRequest.getPassword());

        String token = jwtService.createJwt(member.getEmail());

        return MemberSignInResponse.builder()
                .token(token)
                .email(member.getEmail())
                .name(member.getName())
                .build();
    }

    private void isEqualPw(String pw, String signInPw){
        if(pw.equals(signInPw))
            return;
        throw new InvalidPasswordException();
    }

}
