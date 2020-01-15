package kr.ac.skuniv.medicalhelper.domain.reservation.service;

import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.reservation.exception.ReservationCannotCancelException;
import kr.ac.skuniv.medicalhelper.domain.reservation.exception.ReservationNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.reservation.repository.ReservationRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReservationDeleteService {
    private ReservationRepository reservationRepository;
    private JwtService jwtService;

    public ReservationDeleteService(ReservationRepository reservationRepository, JwtService jwtService) {
        this.reservationRepository = reservationRepository;
        this.jwtService = jwtService;
    }

    public void deleteReservation(Long id, String token) {

        String email = jwtService.findEmailByJwt(token);

        Reservation reservation = reservationRepository.findById(id).orElseThrow(ReservationNotFoundException::new);


        checkValidMember(reservation, email);
        //reservation.delete();
        reservationRepository.delete(reservation);

    }


    private void checkValidMember(Reservation reservation, String email) {
        if(reservation.getMember().getEmail().equals(email)){
            return;
        }
        throw new UnauthorizedUserException();
    }
}
