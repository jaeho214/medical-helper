package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.service;

import kr.ac.skuniv.medicalhelper.domain.drugstore.entity.Drugstore;
import kr.ac.skuniv.medicalhelper.domain.drugstore.exception.DrugstoreNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.drugstore.repository.DrugstoreRepository;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.dto.DrugstoreCommentGetResponse;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.entity.DrugstoreComment;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.repository.DrugstoreCommentRepository;

import java.util.List;
import java.util.Optional;

public class DrugstoreCommentGetService {

    private DrugstoreCommentRepository drugstoreCommentRepository;
    private DrugstoreRepository drugstoreRepository;

    public DrugstoreCommentGetResponse getDrugstoreComment(Long drugstoreNo) {
        if (drugstoreRepository.existsById(drugstoreNo)){
            Optional<Drugstore> drugstore = drugstoreRepository.findById(drugstoreNo);

            List<DrugstoreComment> commentList = drugstoreCommentRepository.findByDrugstore(drugstore.get());


        }
        throw new DrugstoreNotFoundException();
    }
}
