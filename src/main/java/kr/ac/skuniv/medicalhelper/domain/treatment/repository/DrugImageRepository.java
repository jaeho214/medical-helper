package kr.ac.skuniv.medicalhelper.domain.treatment.repository;

import kr.ac.skuniv.medicalhelper.domain.treatment.entity.DrugImage;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugImageRepository extends JpaRepository<DrugImage, Long> {
    DrugImage findByTreatment(Treatment treatment);
}
