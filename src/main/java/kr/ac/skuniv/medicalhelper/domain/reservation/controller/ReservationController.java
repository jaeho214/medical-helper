package kr.ac.skuniv.medicalhelper.domain.reservation.controller;

import kr.ac.skuniv.medicalhelper.domain.reservation.dto.ReservationCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.reservation.dto.ReservationGetResponse;
import kr.ac.skuniv.medicalhelper.domain.reservation.dto.ReservationUpdateRequest;
import kr.ac.skuniv.medicalhelper.domain.reservation.service.ReservationDeleteService;
import kr.ac.skuniv.medicalhelper.domain.reservation.service.ReservationGetService;
import kr.ac.skuniv.medicalhelper.domain.reservation.service.ReservationCreateService;
import kr.ac.skuniv.medicalhelper.domain.reservation.service.ReservationUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "medicalHelper/reservation")
@AllArgsConstructor
//TODO: 시큐리티 적용
public class ReservationController {
    private ReservationGetService reservationGetService;
    private ReservationCreateService reservationCreateService;
    private ReservationUpdateService reservationUpdateService;
    private ReservationDeleteService reservationDeleteService;

    @GetMapping
    public List<ReservationGetResponse> getAllReservations(String userId){
        return reservationGetService.getAllReservations(userId);
    }

    @GetMapping(value = "/{rno}")
    public ReservationGetResponse getReservation(@PathVariable Long rno, String userId){
        return reservationGetService.getReservation(rno, userId);
    }

    @PostMapping
    public void createReservation(ReservationCreateRequest reservationCreateRequest, String userId){
        reservationCreateService.createReservation(reservationCreateRequest, userId);
    }

    @PutMapping
    public void updateReservation(ReservationUpdateRequest reservationUpdateRequest, String userId){
        reservationUpdateService.updateReservation(reservationUpdateRequest, userId);
    }
}
