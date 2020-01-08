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
public class ReservationController {
    private ReservationGetService reservationGetService;
    private ReservationCreateService reservationCreateService;
    private ReservationUpdateService reservationUpdateService;
    private ReservationDeleteService reservationDeleteService;

    @GetMapping
    public List<ReservationGetResponse> getAllReservations(@RequestHeader("token")String token){
        return reservationGetService.getAllReservations(token);
    }

    @GetMapping(value = "/{rno}")
    public ReservationGetResponse getReservation(@PathVariable Long rno,
                                                 @RequestHeader("token") String token){
        return reservationGetService.getReservation(rno, token);
    }

    @PostMapping
    public void createReservation(@RequestBody ReservationCreateRequest reservationCreateRequest,
                                  @RequestHeader("token") String token){
        reservationCreateService.createReservation(reservationCreateRequest, token);
    }

    @PutMapping
    public void updateReservation(@RequestBody ReservationUpdateRequest reservationUpdateRequest,
                                  @RequestHeader("token") String token){
        reservationUpdateService.updateReservation(reservationUpdateRequest, token);
    }

    @DeleteMapping(value = "/{rno}")
    public void deleteReservation(@PathVariable Long rno,
                                  @RequestHeader("token") String token){
        reservationDeleteService.deleteReservation(rno, token);
    }
}
