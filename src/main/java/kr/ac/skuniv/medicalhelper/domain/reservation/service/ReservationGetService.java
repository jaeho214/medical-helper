package kr.ac.skuniv.medicalhelper.domain.reservation.service;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.reservation.dto.ReservationGetResponse;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationGetService {
    private ReservationRepository reservationRepository;
    private MemberRepository memberRepository;

    public List<ReservationGetResponse> getReservations(String userId) {
        Member member = memberRepository.findByUserId(userId);

        if(member == null)
            throw new MemberNotFoundException();

        List<Reservation> reservationList = reservationRepository.findAllByMember(member);

        List<ReservationGetResponse> reservationGetResponses = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            reservationGetResponses.add(ReservationGetResponse.of(reservation));
        }

        return reservationGetResponses;
    }



}
