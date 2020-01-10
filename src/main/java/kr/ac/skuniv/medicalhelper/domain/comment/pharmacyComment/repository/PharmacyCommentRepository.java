package kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.repository;

import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.entity.PharmacyComment;
import kr.ac.skuniv.medicalhelper.domain.pharmacy.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PharmacyCommentRepository extends JpaRepository<PharmacyComment, Long> {
    List<PharmacyComment> findByPharmacy(Pharmacy pharmacy);
}

