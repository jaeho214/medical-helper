package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.drug.entity.Drug;
import kr.ac.skuniv.medicalhelper.domain.drug.repository.DrugRepository;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.hospital.repository.HospitalRepository;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.reservation.repository.ReservationRepository;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentUpdateRequest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TreatmentUpdateServiceTest {

    @Autowired
    TreatmentUpdateService treatmentUpdateService;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    DrugRepository drugRepository;

    private String token = "eyJ0eXAiOiJKV1QiLCJpc3N1ZURhdGUiOjE1NzkwMjAwNTYzMjQsImFsZyI6IkhTMjU2In0.eyJFTUFJTCI6ImphZWhvMjE0QG5hdmVyLmNvbSIsImV4cCI6MTU3OTM4MDA1Nn0.M2VzUoO_jrKhBGQPIpwHRiyEmVGjeIsRrAVxu7ECTHU";


    @Test
    void updateTreatment() throws IOException {
        //given
        Optional<Reservation> reservation = reservationRepository.findById(1L);
        Optional<Drug> drug = drugRepository.findById(1L);
        TreatmentUpdateRequest treatmentUpdateRequest =
                TreatmentUpdateRequest.builder()
                .doctorName("허준")
                .solution("항암치료")
                .reservation(reservation.get())
                .title("간암")
                .drug(drug.get())
                .id(4L)
                .build();

        treatmentUpdateService.updateTreatment(treatmentUpdateRequest,null, token);
    }

//    @Test
//    void updateTreatment_treatmentException(){
//        //given
//        String userId = "jaeho214";
//        TreatmentUpdateRequest treatmentUpdateRequest = null;
//
//        //treatmentUpdateService.updateTreatment(treatmentUpdateRequest,userId);
//    }
//
//    @Test
//    void updateTreatment_securityException(){
//        //given
//        String userId = "aaa";
//        Optional<Reservation> reservation = reservationRepository.findById(1L);
//        TreatmentUpdateRequest treatmentUpdateRequest =
//                TreatmentUpdateRequest.builder()
//                        .doctorName("허준")
//                        .solution("항암치료")
//                        .reservation(reservation.get())
//                        .title("간암")
//                        .tno(1L)
//                        .build();
//
//        //treatmentUpdateService.updateTreatment(treatmentUpdateRequest,userId);
//    }
}