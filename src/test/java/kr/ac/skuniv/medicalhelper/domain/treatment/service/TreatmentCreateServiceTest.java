package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.drug.entity.Drug;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.hospital.repository.HospitalRepository;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.reservation.repository.ReservationRepository;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentCreateRequest;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TreatmentCreateServiceTest {

    @Autowired
    TreatmentCreateService treatmentCreateService;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    MemberRepository memberRepository;

    private String token = "eyJ0eXAiOiJKV1QiLCJpc3N1ZURhdGUiOjE1NzkwMjAwNTYzMjQsImFsZyI6IkhTMjU2In0.eyJFTUFJTCI6ImphZWhvMjE0QG5hdmVyLmNvbSIsImV4cCI6MTU3OTM4MDA1Nn0.M2VzUoO_jrKhBGQPIpwHRiyEmVGjeIsRrAVxu7ECTHU";

    @Before
    TreatmentCreateRequest init(){

        return TreatmentCreateRequest.builder()
                .doctorName("이국종")
                .solution("알약 두 봉지")
                .reservationId(1L)
                .breakfast(true)
                .lunch(true)
                .dinner(true)
                .deadline(LocalDateTime.now())
                .title("감기")
                .build();
    }

//    @Test
//    void createTreatment() throws IOException {
//        //given
//        TreatmentCreateRequest treatmentCreateRequest = init();
//
//        treatmentCreateService.createTreatment(treatmentCreateRequest, null, token);
//    }
//
//    @Test
//    void createTreatment_MemberException(){
//        //given
//        TreatmentCreateRequest treatmentCreateRequest = init();
//        String userId = "aaa";
//
//        //treatmentCreateService.createTreatment(treatmentCreateRequest, userId);
//    }
//
//    @Test
//    void creteTreatment_TreatmentException(){
//        TreatmentCreateRequest treatmentCreateRequest = null;
//        String userId = "jaeho214";
//
//        //treatmentCreateService.createTreatment(treatmentCreateRequest, userId);
//    }
}