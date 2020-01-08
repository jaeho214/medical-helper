package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.service;

import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.dto.DrugstoreCommentGetResponse;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.entity.DrugstoreComment;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.exception.DrugstoreCommentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.repository.DrugstoreCommentRepository;
import kr.ac.skuniv.medicalhelper.domain.drugstore.entity.Drugstore;
import kr.ac.skuniv.medicalhelper.domain.drugstore.exception.DrugstoreNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.drugstore.repository.DrugstoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DrugstoreCommentGetService {
    private DrugstoreCommentRepository drugstoreCommentRepository;
    private DrugstoreRepository drugstoreRepository;

    public DrugstoreCommentGetService(DrugstoreCommentRepository drugstoreCommentRepository, DrugstoreRepository drugstoreRepository) {
        this.drugstoreCommentRepository = drugstoreCommentRepository;
        this.drugstoreRepository = drugstoreRepository;
    }

    public List<DrugstoreCommentGetResponse> getDrugstoreComments(Long drugstoreNo) {
        Optional<Drugstore> drugstore = drugstoreRepository.findById(drugstoreNo);
        drugstore.orElseThrow(DrugstoreNotFoundException::new);

        List<DrugstoreComment> comments = drugstoreCommentRepository.findByDrugstore(drugstore.get());
        if(comments.isEmpty())
            throw new DrugstoreCommentNotFoundException();

        return comments.stream()
                .map(DrugstoreCommentGetResponse::entity2dto)
                .collect(Collectors.toList());
    }
}
