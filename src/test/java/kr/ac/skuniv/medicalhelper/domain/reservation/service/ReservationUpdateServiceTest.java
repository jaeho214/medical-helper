package kr.ac.skuniv.medicalhelper.domain.reservation.service;

import kr.ac.skuniv.medicalhelper.domain.reservation.dto.ReservationUpdateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReservationUpdateServiceTest {

    @Autowired
    ReservationUpdateService reservationUpdateService;

    ReservationUpdateRequest reservationUpdateRequest;

    private String token = "eyJ0eXAiOiJKV1QiLCJpc3N1ZURhdGUiOjE1NzkwMjAwNTYzMjQsImFsZyI6IkhTMjU2In0.eyJFTUFJTCI6ImphZWhvMjE0QG5hdmVyLmNvbSIsImV4cCI6MTU3OTM4MDA1Nn0.M2VzUoO_jrKhBGQPIpwHRiyEmVGjeIsRrAVxu7ECTHU";

    @BeforeEach
    void setUp(){
        reservationUpdateRequest =
                ReservationUpdateRequest.builder()
                        .id(2L)
                        .symptom("편두통")
                        .build();
    }

//    @Test
//    void updateReservation() {
//        reservationUpdateService.updateReservation(reservationUpdateRequest, token);
//
//    }
}