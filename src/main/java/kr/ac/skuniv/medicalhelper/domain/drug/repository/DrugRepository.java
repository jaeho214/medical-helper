package kr.ac.skuniv.medicalhelper.domain.drug.repository;

import kr.ac.skuniv.medicalhelper.domain.drug.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug, Long> {
}
