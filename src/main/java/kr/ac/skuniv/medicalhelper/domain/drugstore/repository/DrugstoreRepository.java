package kr.ac.skuniv.medicalhelper.domain.drugstore.repository;

import kr.ac.skuniv.medicalhelper.domain.drugstore.entity.Drugstore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugstoreRepository extends JpaRepository<Drugstore, Long> {

}
