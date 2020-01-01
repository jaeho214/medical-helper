package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberSignInRequest;
import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberSignInResponse;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.InvalidPasswordException;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberSignInService {
    private final MemberRepository memberRepository;

    public MemberSignInService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //TODO: 로그인 처리 필요(후에 JWT 토큰 적용할 예정)
    public MemberSignInResponse signInMember(MemberSignInRequest memberSignInRequest){

        if(memberRepository.existsById(memberSignInRequest.getUserId())) {
            Member member = memberRepository.findByUserId(memberSignInRequest.getUserId());

            if (isEqualPw(member.getPassword(), memberSignInRequest.getPassword())) {
                return MemberSignInResponse.builder()
                        .userId(member.getUserId())
                        .name(member.getName())
                        .build();

            }else{
                throw new InvalidPasswordException();
            }
        }
        throw new MemberNotFoundException();
    }

    private boolean isEqualPw(String pw, String signInPw){
        return pw.equals(signInPw);
    }
}
