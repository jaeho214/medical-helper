package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberGetResponse;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberGetService {

    private final MemberRepository memberRepository;

    public MemberGetService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberGetResponse selectMember(String userId){
        if(memberRepository.existsById(userId)){
            Member member = memberRepository.findByUserId(userId);
            return MemberGetResponse.builder()
                    .userId(member.getUserId())
                    .name(member.getName())
                    .phone(member.getPhone())
                    .birth(member.getBirth())
                    .sex(member.getSex())
                    .address(member.getAddress())
                    .build();
        }
        throw new MemberNotFoundException();
    }
}
