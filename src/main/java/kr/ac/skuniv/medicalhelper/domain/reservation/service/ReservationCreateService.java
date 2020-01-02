package kr.ac.skuniv.medicalhelper.domain.reservation.service;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.reservation.dto.ReservationCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.reservation.exception.ReservationCannotException;
import kr.ac.skuniv.medicalhelper.domain.reservation.exception.ReservationRequestInvalidException;
import kr.ac.skuniv.medicalhelper.domain.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//TODO: 예약을 하려할 때 예약이 되는지 여부 확인
public class ReservationCreateService {

    private ReservationRepository reservationRepository;
    private MemberRepository memberRepository;

    public ReservationCreateService(ReservationRepository reservationRepository, MemberRepository memberRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
    }

    public void createReservation(ReservationCreateRequest reservationCreateRequest, String userId) {
        if(memberRepository.existsById(userId)){
            Member member = memberRepository.findByUserId(userId);

            Optional.ofNullable(reservationCreateRequest).orElseThrow(ReservationRequestInvalidException::new);

            checkDuplicatedReservation(reservationCreateRequest);
            Reservation reservation =
                    Reservation.builder()
                        .reserveDate(reservationCreateRequest.getReserveDate())
                        .symptom(reservationCreateRequest.getSymptom())
                        .hospital(reservationCreateRequest.getHospital())
                        .member(member)
                        .build();

            reservationRepository.save(reservation);

            return;
        }
        throw new MemberNotFoundException();
    }

    //TODO: 수정필요
    private void checkDuplicatedReservation(ReservationCreateRequest reservationCreateRequest) {

        Optional<Reservation> reservation = reservationRepository.findByHospitalAndReserveDate(reservationCreateRequest.getHospital(), reservationCreateRequest.getReserveDate());
        if(reservation.isPresent())
            throw new ReservationCannotException();

        return;
    }
}
