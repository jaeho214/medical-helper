package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.service;

import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.entity.DrugstoreComment;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.exception.DrugstoreCommentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.repository.DrugstoreCommentRepository;
import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrugstoreCommentDeleteService {

    @Autowired
    private DrugstoreCommentRepository drugstoreCommentRepository;

    public ResponseEntity deleteDrugstoreComment(Long dcNo, String userId) {
        Optional<DrugstoreComment> drugstoreComment = drugstoreCommentRepository.findById(dcNo);
        drugstoreComment.orElseThrow(DrugstoreCommentNotFoundException::new);

        checkValidMember(drugstoreComment.get(), userId);

        drugstoreCommentRepository.delete(drugstoreComment.get());

        return ResponseEntity.ok(drugstoreComment);
    }

    private void checkValidMember(DrugstoreComment drugstoreComment, String userId) {
        if(drugstoreComment.getMember().getUserId().equals(userId)){
            return ;
        }
        throw new UnauthorizedUserException();
    }


}
