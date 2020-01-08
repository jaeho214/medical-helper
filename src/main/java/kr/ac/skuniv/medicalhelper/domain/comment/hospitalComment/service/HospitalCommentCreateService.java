package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.service;

import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.dto.HospitalCommentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.entity.HospitalComment;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.exception.HospitalCommentRequestInvalidException;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.repository.HospitalCommentRepository;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.hospital.repository.HospitalRepository;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalCommentCreateService {

    private HospitalCommentRepository hospitalCommentRepository;
    private HospitalRepository hospitalRepository;
    private MemberRepository memberRepository;

    public HospitalCommentCreateService(HospitalCommentRepository hospitalCommentRepository, HospitalRepository hospitalRepository, MemberRepository memberRepository) {
        this.hospitalCommentRepository = hospitalCommentRepository;
        this.hospitalRepository = hospitalRepository;
        this.memberRepository = memberRepository;
    }

    public HospitalComment createHospitalComment(HospitalCommentCreateRequest hospitalCommentCreateRequest, String userId) {
        if(hospitalCommentCreateRequest == null)
            throw new HospitalCommentRequestInvalidException();

        Optional<Hospital> hospital = hospitalRepository.findById(hospitalCommentCreateRequest.getHospitalNo());
        hospital.orElseThrow(HospitalCommentRequestInvalidException::new);

        Optional<Member> member = memberRepository.findByUserId(userId);
        member.orElseThrow(MemberNotFoundException::new);

        HospitalComment hospitalComment = HospitalComment.builder()
                .score(hospitalCommentCreateRequest.getScore())
                .comment(hospitalCommentCreateRequest.getComment())
                .hospital(hospital.get())
                .member(member.get())
                .build();

        hospitalCommentRepository.save(hospitalComment);

        return hospitalComment;
    }
}
