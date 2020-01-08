package kr.ac.skuniv.medicalhelper.domain.member.service;

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

    public void deleteMember(String token){
        String userId = jwtService.findUserIdByJwt(token);

        if(memberRepository.existsById(userId)){
            memberRepository.deleteById(userId);
            return;
        }
        throw new MemberNotFoundException();
    }
}
