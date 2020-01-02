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

    @BeforeEach
    void setUp(){
        reservationUpdateRequest =
                ReservationUpdateRequest.builder()
                        .tno(3L)
                        .symptom("편두통")
                        .build();
    }

    @Test
    void updateReservation() {
        String userId = "jaeho214";

        reservationUpdateService.updateReservation(reservationUpdateRequest, userId);
    }
}