package kr.ac.skuniv.medicalhelper.domain.reservation.service;

import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.reservation.exception.ReservationNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.reservation.repository.ReservationRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationDeleteService {
    private ReservationRepository reservationRepository;
    private JwtService jwtService;

    public ReservationDeleteService(ReservationRepository reservationRepository, JwtService jwtService) {
        this.reservationRepository = reservationRepository;
        this.jwtService = jwtService;
    }

    public void deleteReservation(Long rno, String token) {

        String userId = jwtService.findUserIdByJwt(token);

        Optional<Reservation> reservation = Optional.ofNullable(reservationRepository.findById(rno).orElseThrow(ReservationNotFoundException::new));

        checkValidMember(reservation.get(), userId);

        reservationRepository.delete(reservation.get());

    }

    private void checkValidMember(Reservation reservation, String userId) {
        if(reservation.getMember().getUserId().equals(userId)){
            return;
        }
        throw new UnauthorizedUserException();
    }
}
