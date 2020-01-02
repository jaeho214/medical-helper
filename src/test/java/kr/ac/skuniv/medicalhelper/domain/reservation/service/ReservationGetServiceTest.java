package kr.ac.skuniv.medicalhelper.domain.reservation.service;

import kr.ac.skuniv.medicalhelper.domain.reservation.dto.ReservationGetResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
class ReservationGetServiceTest {

    @Autowired
    ReservationGetService reservationGetService;

    @Test
    void getAllReservations() {
        String userId = "jaeho214";

        List<ReservationGetResponse> reservations = reservationGetService.getAllReservations(userId);

        assertThat(reservations).isNotNull();
        assertThat(reservations.get(0).getSymptom()).isEqualTo("복통");
        assertThat(reservations.size()).isEqualTo(2);
    }

    @Test
    void getReservation(){
        String userId = "jaeho214";
        Long rno = 1L;

        ReservationGetResponse reservation = reservationGetService.getReservation(rno, userId);

        assertThat(reservation.getSymptom()).isEqualTo("복통");
    }

    @Test
    void getReservation_memberException(){
        String userId = "jaeho213";
        Long rno = 1L;

        ReservationGetResponse reservation = reservationGetService.getReservation(rno, userId);

        assertThat(reservation.getSymptom()).isEqualTo("복통");
    }


}