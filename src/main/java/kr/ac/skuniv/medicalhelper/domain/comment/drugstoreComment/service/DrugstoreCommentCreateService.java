package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.service;

import kr.ac.skuniv.medicalhelper.domain.drugstore.exception.DrugstoreNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.drugstore.repository.DrugstoreRepository;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.dto.DrugstoreCommentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.entity.DrugstoreComment;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.repository.DrugstoreCommentRepository;
import org.springframework.http.ResponseEntity;

public class DrugstoreCommentCreateService {

    private DrugstoreRepository drugstoreRepository;
    private DrugstoreCommentRepository drugstoreCommentRepository;

    public DrugstoreCommentCreateService(DrugstoreRepository drugstoreRepository, DrugstoreCommentRepository drugstoreCommentRepository) {
        this.drugstoreRepository = drugstoreRepository;
        this.drugstoreCommentRepository = drugstoreCommentRepository;
    }

    public ResponseEntity createDrugstoreComment(DrugstoreCommentCreateRequest drugstoreCommentCreateRequest, String userId) {
        if(drugstoreRepository.existsById(drugstoreCommentCreateRequest.getDrugstore().getDrugstoreNo())){
            //입력한 약국에 대한 별점을 entity로 바꿔서
            DrugstoreComment drugstoreComment =
                    DrugstoreComment.builder()
                    .comment(drugstoreCommentCreateRequest.getComment())
                    .score(drugstoreCommentCreateRequest.getScore())
                    .drugstore(drugstoreCommentCreateRequest.getDrugstore())
                    .build();

            drugstoreCommentRepository.save(drugstoreComment);

            return ResponseEntity.ok(drugstoreComment);
        }
        throw new DrugstoreNotFoundException();
    }
}
