package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.UserDuplicationException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberCreateService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberCreateService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Member createMember(MemberCreateRequest memberCreateRequest){
        if(!memberRepository.existsByEmail(memberCreateRequest.getEmail())){
            Member member = Member.of(memberCreateRequest);
            member.setPassword(passwordEncoder.encode(member.getPassword()));
            memberRepository.save(member);
            return Member.of(memberCreateRequest);
        }
        throw new UserDuplicationException();
    }


}
