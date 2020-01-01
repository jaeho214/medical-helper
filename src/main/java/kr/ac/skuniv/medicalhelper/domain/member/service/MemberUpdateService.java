package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberUpdateRequest;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberUpdateService {

    private final MemberRepository memberRepository;

    public MemberUpdateService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void updateMember(MemberUpdateRequest memberUpdateRequest){

        if(memberRepository.existsById(memberUpdateRequest.getUserId())){
            Member member = memberRepository.findByUserId(memberUpdateRequest.getUserId());
            member.updateMember(memberUpdateRequest);
            memberRepository.save(member);
            return;
        }
        throw new MemberNotFoundException();

    }
}
