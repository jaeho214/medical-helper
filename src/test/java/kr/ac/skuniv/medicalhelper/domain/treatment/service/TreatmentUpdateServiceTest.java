package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.hospital.repository.HospitalRepository;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentUpdateRequest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TreatmentUpdateServiceTest {

    @Autowired
    TreatmentUpdateService treatmentUpdateService;

    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    void updateTreatment() {
        //given
        String userId = "jaeho214";
        Optional<Hospital> hospital = hospitalRepository.findById(101L);
        TreatmentUpdateRequest treatmentUpdateRequest =
                TreatmentUpdateRequest.builder()
                .doctorName("허준")
                .solution("항암치료")
                .title("간암")
                .tno(1L)
                .treatedDate(LocalDate.of(2020,1,1))
                .hospital(hospital.get())
                .build();

        treatmentUpdateService.updateTreatment(treatmentUpdateRequest, userId);
    }

    @Test
    void updateTreatment_treatmentException(){
        //given
        String userId = "jaeho214";
        TreatmentUpdateRequest treatmentUpdateRequest = null;

        treatmentUpdateService.updateTreatment(treatmentUpdateRequest,userId);
    }

    @Test
    void updateTreatment_securityException(){
        //given
        String userId = "aaa";
        Optional<Hospital> hospital = hospitalRepository.findById(101L);
        TreatmentUpdateRequest treatmentUpdateRequest =
                TreatmentUpdateRequest.builder()
                        .doctorName("허준")
                        .solution("항암치료")
                        .title("간암")
                        .tno(1L)
                        .treatedDate(LocalDate.of(2020,1,1))
                        .hospital(hospital.get())
                        .build();

        treatmentUpdateService.updateTreatment(treatmentUpdateRequest,userId);
    }
}