package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.repository;

import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.entity.HospitalComment;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalCommentRepository extends JpaRepository<HospitalComment, Long> {
    List<HospitalComment> findByHospital(Hospital hospital);
}
