package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TreatmentDeleteServiceTest {

    @Autowired
    TreatmentDeleteService treatmentDeleteService;

    @Test
    void deleteTreatment() {
        String userId = "jaeho214";

        treatmentDeleteService.deleteTreatment(1L, userId);
    }

    @Test
    void deleteTreatment_securityException() {
        String userId = "aaa";

        treatmentDeleteService.deleteTreatment(1L, userId);
    }
}