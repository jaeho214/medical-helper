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

    private String token = "eyJ0eXAiOiJKV1QiLCJpc3N1ZURhdGUiOjE1NzkwMjAwNTYzMjQsImFsZyI6IkhTMjU2In0.eyJFTUFJTCI6ImphZWhvMjE0QG5hdmVyLmNvbSIsImV4cCI6MTU3OTM4MDA1Nn0.M2VzUoO_jrKhBGQPIpwHRiyEmVGjeIsRrAVxu7ECTHU";

//    @Test
//    void getAllReservations() {
//
//        List<ReservationGetResponse> reservations = reservationGetService.getAllReservations(token);
//
//        assertThat(reservations).isNotNull();
//        assertThat(reservations.get(0).getSymptom()).isEqualTo("두통");
//        assertThat(reservations.size()).isEqualTo(2);
//    }
//
//    @Test
//    void getReservation(){
//
//        Long id = 1L;
//
//        ReservationGetResponse reservation = reservationGetService.getReservation(id, token);
//
//        assertThat(reservation.getSymptom()).isEqualTo("두통");
//    }
//
//    @Test
//    void getReservation_memberException(){
//        String userId = "jaeho213";
//        Long rno = 1L;
//
//        ReservationGetResponse reservation = reservationGetService.getReservation(rno, userId);
//
//        assertThat(reservation.getSymptom()).isEqualTo("복통");
//    }


}