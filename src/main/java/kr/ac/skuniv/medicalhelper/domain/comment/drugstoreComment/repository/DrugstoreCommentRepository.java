package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.repository;

import kr.ac.skuniv.medicalhelper.domain.drugstore.entity.Drugstore;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.entity.DrugstoreComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugstoreCommentRepository extends JpaRepository<DrugstoreComment, Long> {
    List<DrugstoreComment> findByDrugstore(Drugstore drugstore);
}

