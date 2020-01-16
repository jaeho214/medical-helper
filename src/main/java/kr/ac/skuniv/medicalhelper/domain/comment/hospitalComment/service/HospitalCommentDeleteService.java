package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.service;

import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.entity.HospitalComment;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.exception.HospitalCommentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.repository.HospitalCommentRepository;
import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalCommentDeleteService {

    private HospitalCommentRepository hospitalCommentRepository;
    private JwtService jwtService;

    public HospitalCommentDeleteService(HospitalCommentRepository hospitalCommentRepository, JwtService jwtService) {
        this.hospitalCommentRepository = hospitalCommentRepository;
        this.jwtService = jwtService;
    }

    public HospitalComment deleteHospitalComment(Long id, String token) {
        String email = jwtService.findEmailByJwt(token);

        HospitalComment comment = hospitalCommentRepository.findById(id).orElseThrow(HospitalCommentNotFoundException::new);

        checkValidMember(comment, email);

        //comment.delete();
        hospitalCommentRepository.delete(comment);

        return comment;
    }

    private void checkValidMember(HospitalComment hospitalComment, String email) {
        if(hospitalComment.getMember().getEmail().equals(email))
            return;
        throw new UnauthorizedUserException();
    }
}
