package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.hospital.repository.HospitalRepository;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentCreateRequest;
import org.junit.Before;
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
class TreatmentCreateServiceTest {

    @Autowired
    TreatmentCreateService treatmentCreateService;

    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    MemberRepository memberRepository;

    @Before
    TreatmentCreateRequest init(){
        Optional<Hospital> hospital = hospitalRepository.findById(100L);
        LocalDate date = LocalDate.of(2020,1,2);

        return TreatmentCreateRequest.builder()
                .doctorName("이국종")
                .solution("알약 두 봉지")
                .title("감기")
                .hospital(hospital.get())
                .treatedDate(date)
                .build();
    }

    @Test
    void createTreatment() {
        //given
        TreatmentCreateRequest treatmentCreateRequest = init();
        String userId = "jaeho214";

        treatmentCreateService.createTreatment(treatmentCreateRequest, userId);
    }

    @Test
    void createTreatment_MemberException(){
        //given
        TreatmentCreateRequest treatmentCreateRequest = init();
        String userId = "aaa";

        treatmentCreateService.createTreatment(treatmentCreateRequest, userId);
    }

    @Test
    void creteTreatment_TreatmentException(){
        TreatmentCreateRequest treatmentCreateRequest = null;
        String userId = "jaeho214";

        treatmentCreateService.createTreatment(treatmentCreateRequest, userId);
    }
}