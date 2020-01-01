package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberDeleteService {

    private final MemberRepository memberRepository;

    public MemberDeleteService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void deleteMember(String userId){
        if(memberRepository.existsById(userId)){
            memberRepository.deleteById(userId);
            return;
        }
        throw new MemberNotFoundException();
    }
}
