package kr.ac.skuniv.medicalhelper.domain.reservation.service;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.reservation.dto.ReservationGetResponse;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.reservation.exception.ReservationNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationGetService {
    private ReservationRepository reservationRepository;
    private MemberRepository memberRepository;

    public ReservationGetService(ReservationRepository reservationRepository, MemberRepository memberRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
    }

    public List<ReservationGetResponse> getAllReservations(String userId) {
        if(memberRepository.existsById(userId)) {
            Member member = memberRepository.findByUserId(userId);

            List<Reservation> reservationList = reservationRepository.findAllByMember(member);

            if(reservationList == null)
                throw new ReservationNotFoundException();

            List<ReservationGetResponse> reservationGetResponses = new ArrayList<>();
            for (Reservation reservation : reservationList) {
                reservationGetResponses.add(ReservationGetResponse.entity2dto(reservation));
            }

            return reservationGetResponses;
        }
        throw new MemberNotFoundException();
    }


    public ReservationGetResponse getReservation(Long rno, String userId) {
        if(memberRepository.existsById(userId)){
            Optional<Reservation> reservation = reservationRepository.findById(rno);
            reservation.orElseThrow(ReservationNotFoundException::new);

            checkMember(reservation.get(), userId);

            ReservationGetResponse reservationGetResponse = ReservationGetResponse.entity2dto(reservation.get());

            return reservationGetResponse;
        }
        throw new MemberNotFoundException();

    }

    private void checkMember(Reservation reservation, String requestUser) {
        if(reservation.getMember().getUserId().equals(requestUser))
            return;
        throw new ReservationNotFoundException();

    }
}
