package kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.service;

import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.dto.PharmacyCommentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.entity.PharmacyComment;
import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.exception.PharmacyCommentRequestInvalidException;
import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.repository.PharmacyCommentRepository;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.pharmacy.entity.Pharmacy;
import kr.ac.skuniv.medicalhelper.domain.pharmacy.exception.PharmacyNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.pharmacy.repository.PharmacyRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PharmacyCommentCreateService {

    private PharmacyRepository pharmacyRepository;
    private PharmacyCommentRepository pharmacyCommentRepository;
    private MemberRepository memberRepository;
    private JwtService jwtService;

    public PharmacyCommentCreateService(PharmacyRepository pharmacyRepository, PharmacyCommentRepository pharmacyCommentRepository, MemberRepository memberRepository, JwtService jwtService) {
        this.pharmacyRepository = pharmacyRepository;
        this.pharmacyCommentRepository = pharmacyCommentRepository;
        this.memberRepository = memberRepository;
        this.jwtService = jwtService;
    }

    public PharmacyComment createPharmacyComment(PharmacyCommentCreateRequest pharmacyCommentCreateRequest, String token) {
        Optional.ofNullable(pharmacyCommentCreateRequest).orElseThrow(PharmacyCommentRequestInvalidException::new);

        String email = jwtService.findEmailByJwt(token);

        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyCommentCreateRequest.getPharmacyId()).orElseThrow(PharmacyNotFoundException::new);

        Member member = memberRepository.findByEmail(email).orElseThrow(MemberNotFoundException::new);

        //입력한 약국에 대한 별점을 entity로 바꿔서
        PharmacyComment pharmacyComment =
                PharmacyComment.builder()
                        .comment(pharmacyCommentCreateRequest.getComment())
                        .score(pharmacyCommentCreateRequest.getScore())
                        .pharmacy(pharmacy)
                        .member(member)
                        .build();

        pharmacyCommentRepository.save(pharmacyComment);

        return pharmacyComment;

    }
}
