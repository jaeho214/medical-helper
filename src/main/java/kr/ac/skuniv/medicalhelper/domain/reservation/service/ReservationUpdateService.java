package kr.ac.skuniv.medicalhelper.domain.reservation.service;

import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.reservation.dto.ReservationUpdateRequest;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.reservation.exception.ReservationNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.reservation.exception.ReservationRequestInvalidException;
import kr.ac.skuniv.medicalhelper.domain.reservation.repository.ReservationRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationUpdateService {

    private ReservationRepository reservationRepository;
    private JwtService jwtService;

    public ReservationUpdateService(ReservationRepository reservationRepository, JwtService jwtService) {
        this.reservationRepository = reservationRepository;
        this.jwtService = jwtService;
    }

    public void updateReservation(ReservationUpdateRequest reservationUpdateRequest, String token) {
        String userId = jwtService.findUserIdByJwt(token);

        Optional.ofNullable(reservationUpdateRequest).orElseThrow(ReservationRequestInvalidException::new);

        Optional<Reservation> reservation = Optional.ofNullable(reservationRepository.findById(reservationUpdateRequest.getRno()).orElseThrow(ReservationNotFoundException::new));

        checkValidMember(reservation.get(), userId);

        reservation.get().updateSymptom(reservationUpdateRequest.getSymptom());

        reservationRepository.save(reservation.get());
    }

    private void checkValidMember(Reservation reservation, String userId) {
        if(reservation.getMember().getUserId().equals(userId))
            return;
        throw new UnauthorizedUserException();
    }
}
