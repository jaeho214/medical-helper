package kr.ac.skuniv.medicalhelper.domain.reservation.service;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.hospital.repository.HospitalRepository;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.reservation.dto.ReservationCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.reservation.repository.ReservationRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReservationCreateServiceTest {

    @Autowired
    private ReservationCreateService reservationCreateService;

    @Autowired
    HospitalRepository hospitalRepository;

    private ReservationCreateRequest reservationCreateRequest;
    private String token = "eyJ0eXAiOiJKV1QiLCJpc3N1ZURhdGUiOjE1NzkwMjAwNTYzMjQsImFsZyI6IkhTMjU2In0.eyJFTUFJTCI6ImphZWhvMjE0QG5hdmVyLmNvbSIsImV4cCI6MTU3OTM4MDA1Nn0.M2VzUoO_jrKhBGQPIpwHRiyEmVGjeIsRrAVxu7ECTHU";
    @BeforeEach
    void setUp(){
        Optional<Hospital> hospital = hospitalRepository.findById(11L);

        reservationCreateRequest = ReservationCreateRequest.builder()
                                    .symptom("생리통")
                                    .reserveDate(LocalDate.of(2020,1,14))
                                    .hospitalId(11L)
                                    .build();
    }

//    @Test
//    void createReservation() {
//        reservationCreateService.createReservation(reservationCreateRequest, token);
//
//    }
//    @Test
//    void createReservation_duplicateException(){
//        reservationCreateRequest.setSymptom("치통");
//        reservationCreateService.createReservation(reservationCreateRequest, token);
//    }


}