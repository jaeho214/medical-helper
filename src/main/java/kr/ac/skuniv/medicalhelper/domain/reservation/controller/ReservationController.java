package kr.ac.skuniv.medicalhelper.domain.reservation.controller;

import kr.ac.skuniv.medicalhelper.domain.reservation.dto.ReservationGetResponse;
import kr.ac.skuniv.medicalhelper.domain.reservation.service.ReservationDeleteService;
import kr.ac.skuniv.medicalhelper.domain.reservation.service.ReservationGetService;
import kr.ac.skuniv.medicalhelper.domain.reservation.service.ReservationPostService;
import kr.ac.skuniv.medicalhelper.domain.reservation.service.ReservationUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "medicalHelper/reservation")
@AllArgsConstructor
public class ReservationController {
    private ReservationGetService reservationGetService;
    private ReservationPostService reservationPostService;
    private ReservationUpdateService reservationUpdateService;
    private ReservationDeleteService reservationDeleteService;

    @GetMapping
    public List<ReservationGetResponse> getReservations(String userId){
        return reservationGetService.getReservations(userId);
    }
}
