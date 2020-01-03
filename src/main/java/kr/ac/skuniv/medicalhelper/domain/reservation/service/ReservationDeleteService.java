package kr.ac.skuniv.medicalhelper.domain.reservation.service;

import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.reservation.exception.ReservationNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationDeleteService {
    private ReservationRepository reservationRepository;

    public ReservationDeleteService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void deleteReservation(Long rno, String userId) {
        if(reservationRepository.existsById(rno)){
            Optional<Reservation> reservation = reservationRepository.findById(rno);

            checkValidMember(reservation.get(), userId);

            reservationRepository.delete(reservation.get());
        }
        throw new ReservationNotFoundException();
    }

    private void checkValidMember(Reservation reservation, String userId) {
        if(reservation.getMember().getUserId().equals(userId)){
            return;
        }
        throw new UnauthorizedUserException();
    }
}
