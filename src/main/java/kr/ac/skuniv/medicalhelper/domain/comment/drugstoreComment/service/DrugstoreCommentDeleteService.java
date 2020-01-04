package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.service;

import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.entity.DrugstoreComment;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.exception.DrugstoreCommentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.repository.DrugstoreCommentRepository;
import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class DrugstoreCommentDeleteService {

    @Autowired
    private DrugstoreCommentRepository drugstoreCommentRepository;

    public ResponseEntity deleteDrugstoreComment(Long dcNo, String userId) {
        if(drugstoreCommentRepository.existsById(dcNo)){
            Optional<DrugstoreComment> drugstoreComment = drugstoreCommentRepository.findById(dcNo);

            checkValidMember(drugstoreComment.get(), userId);

            drugstoreCommentRepository.delete(drugstoreComment.get());

            return ResponseEntity.ok(drugstoreComment);
        }
        throw new DrugstoreCommentNotFoundException();
    }

    private void checkValidMember(DrugstoreComment drugstoreComment, String userId) {
        if(drugstoreComment.getMember().getUserId().equals(userId)){
            return ;
        }
        throw new UnauthorizedUserException();
    }


}
