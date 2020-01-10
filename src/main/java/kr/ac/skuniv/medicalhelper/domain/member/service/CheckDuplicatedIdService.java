package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.UserDuplicationException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class CheckDuplicatedIdService {

    private final MemberRepository memberRepository;

    public CheckDuplicatedIdService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //true 면 중복된 아이디가 없음, 아이디 생성 가능
    public boolean checkId(String email){

        if(memberRepository.existsByEmail(email)){
            throw new UserDuplicationException();
        }

        return true;
    }
}
