package kr.ac.skuniv.medicalhelper.domain.drugImage.repository;

import kr.ac.skuniv.medicalhelper.domain.drugImage.entity.DrugImage;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugImageRepository extends JpaRepository<DrugImage, Long> {
    DrugImage findByTreatment(Treatment treatment);
}
