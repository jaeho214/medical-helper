package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.service;

import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.entity.HospitalComment;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.exception.HospitalCommentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.repository.HospitalCommentRepository;
import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalCommentDeleteService {

    private HospitalCommentRepository hospitalCommentRepository;

    public HospitalCommentDeleteService(HospitalCommentRepository hospitalCommentRepository) {
        this.hospitalCommentRepository = hospitalCommentRepository;
    }

    public HospitalComment deleteHospitalComment(Long hcNo, String userId) {
        Optional<HospitalComment> comment = Optional.ofNullable(hospitalCommentRepository.findById(hcNo).orElseThrow(HospitalCommentNotFoundException::new));

        checkValidMemeber(comment.get(), userId);

        hospitalCommentRepository.delete(comment.get());

        return comment.get();
    }

    private void checkValidMemeber(HospitalComment hospitalComment, String userId) {
        if(hospitalComment.getMember().getUserId().equals(userId))
            return;
        throw new UnauthorizedUserException();
    }
}
