package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberCreateService {

    private final MemberRepository memberRepository;

    public MemberCreateService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void createMember(MemberCreateRequest memberCreateRequest){
        if(!memberRepository.existsById(memberCreateRequest.getUserId())){
            memberRepository.save(Member.of(memberCreateRequest));
        }
    }


}
