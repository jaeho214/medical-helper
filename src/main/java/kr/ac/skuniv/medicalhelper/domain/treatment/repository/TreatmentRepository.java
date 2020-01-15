package kr.ac.skuniv.medicalhelper.domain.treatment.repository;

import kr.ac.skuniv.medicalhelper.domain.drug.entity.Drug;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    List<Treatment> findAllByMember(Member member);
    Optional<Treatment> findByDrug(Drug drug);

    @Query("select t " +
            "from Treatment t " +
            "join fetch t.member " +
            "join fetch t.drug " +
            "join fetch t.reservation " +
            "where t.id=:id")
    Optional<Treatment> findById(Long id);
}
