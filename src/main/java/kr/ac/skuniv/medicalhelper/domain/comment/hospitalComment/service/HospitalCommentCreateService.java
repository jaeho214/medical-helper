package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.service;

import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.dto.HospitalCommentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.entity.HospitalComment;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.exception.HospitalCommentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.exception.HospitalCommentRequestInvalidException;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.repository.HospitalCommentRepository;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.hospital.repository.HospitalRepository;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalCommentCreateService {

    private HospitalCommentRepository hospitalCommentRepository;
    private HospitalRepository hospitalRepository;
    private MemberRepository memberRepository;
    private JwtService jwtService;

    public HospitalCommentCreateService(HospitalCommentRepository hospitalCommentRepository, HospitalRepository hospitalRepository, MemberRepository memberRepository, JwtService jwtService) {
        this.hospitalCommentRepository = hospitalCommentRepository;
        this.hospitalRepository = hospitalRepository;
        this.memberRepository = memberRepository;
        this.jwtService = jwtService;
    }

    public HospitalComment createHospitalComment(HospitalCommentCreateRequest hospitalCommentCreateRequest, String token) {
        String email = jwtService.findEmailByJwt(token);

        Optional.ofNullable(hospitalCommentCreateRequest).orElseThrow(HospitalCommentRequestInvalidException::new);

        Hospital hospital = hospitalRepository.findById(hospitalCommentCreateRequest.getHospitalId()).orElseThrow(HospitalCommentNotFoundException::new);

        Member member = memberRepository.findByEmail(email).orElseThrow(MemberNotFoundException::new);

        HospitalComment hospitalComment = hospitalCommentCreateRequest.toEntity(hospital, member);

        hospitalCommentRepository.save(hospitalComment);

        return hospitalComment;
    }
}
