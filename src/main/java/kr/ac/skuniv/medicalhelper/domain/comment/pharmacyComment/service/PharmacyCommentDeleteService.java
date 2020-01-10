package kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.service;

import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.entity.PharmacyComment;
import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.exception.PharmacyCommentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.repository.PharmacyCommentRepository;
import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PharmacyCommentDeleteService {

    private PharmacyCommentRepository pharmacyCommentRepository;
    private JwtService jwtService;

    public PharmacyCommentDeleteService(PharmacyCommentRepository pharmacyCommentRepository, JwtService jwtService) {
        this.pharmacyCommentRepository = pharmacyCommentRepository;
        this.jwtService = jwtService;
    }

    public ResponseEntity deletePharmacyComment(Long id, String token) {

        String email = jwtService.findEmailByJwt(token);

        PharmacyComment pharmacyComment = pharmacyCommentRepository.findById(id).orElseThrow(PharmacyCommentNotFoundException::new);

        checkValidMember(pharmacyComment, email);

        pharmacyComment.delete();
        pharmacyCommentRepository.delete(pharmacyComment);

        return ResponseEntity.ok(pharmacyComment);
    }

    private void checkValidMember(PharmacyComment pharmacyComment, String email) {
        if(pharmacyComment.getMember().getEmail().equals(email)){
            return ;
        }
        throw new UnauthorizedUserException();
    }


}
