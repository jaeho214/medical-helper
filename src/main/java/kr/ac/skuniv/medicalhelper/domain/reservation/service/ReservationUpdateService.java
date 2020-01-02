package kr.ac.skuniv.medicalhelper.domain.reservation.service;

import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.reservation.dto.ReservationUpdateRequest;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.reservation.exception.ReservationNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationUpdateService {

    private ReservationRepository reservationRepository;

    public ReservationUpdateService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void updateReservation(ReservationUpdateRequest reservationUpdateRequest, String userId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationUpdateRequest.getTno());
        reservation.orElseThrow(ReservationNotFoundException::new);

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
