package kr.ac.skuniv.medicalhelper.domain.reservation.service;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.hospital.exception.HospitalNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.hospital.repository.HospitalRepository;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.reservation.dto.ReservationGetResponse;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.ReservationStatus;
import kr.ac.skuniv.medicalhelper.domain.reservation.exception.ReservationNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.reservation.repository.ReservationRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReservationGetService {
    private ReservationRepository reservationRepository;
    private MemberRepository memberRepository;
    private HospitalRepository hospitalRepository;
    private JwtService jwtService;

    public ReservationGetService(ReservationRepository reservationRepository, MemberRepository memberRepository, HospitalRepository hospitalRepository, JwtService jwtService) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
        this.hospitalRepository = hospitalRepository;
        this.jwtService = jwtService;
    }

    public List<ReservationGetResponse> getAllReservations(String token) {

        String email = jwtService.findEmailByJwt(token);

        Member member = memberRepository.findByEmail(email).orElseThrow(MemberNotFoundException::new);

        List<Reservation> reservationList = reservationRepository.findAllByMember(member);

        if (reservationList==null)
            throw new ReservationNotFoundException();

        return reservationList.stream()
                .map(ReservationGetResponse::entity2dto)
                .collect(Collectors.toList());
    }


    public ReservationGetResponse getReservation(Long id, String token) {
        String email = jwtService.findEmailByJwt(token);

        if(memberRepository.existsByEmail(email)){
            Reservation reservation = reservationRepository.findById(id).orElseThrow(ReservationNotFoundException::new);

            checkMember(reservation, email);

            return ReservationGetResponse.entity2dto(reservation);
        }
        throw new MemberNotFoundException();
    }

    public List<String> getPossibleReservationTime(Long hospitalId, LocalDate reserveDate){
        List<String> returnList =
                Arrays.asList(new String[]{"0900","0930","1000","1030","1100","1130","1300","1330","1400","1430","1500","1530","1600","1630","1700","1730"});

        Hospital hospital = hospitalRepository.findById(hospitalId).orElseThrow(HospitalNotFoundException::new);
        List<Reservation> possibleTimeList = reservationRepository.findByHospitalAndReserveDate(hospital, reserveDate);

        for(Reservation reservation : possibleTimeList){
            returnList.remove(reservation.getReserveTime());
        }

        return returnList;
    }




    private void checkMember(Reservation reservation, String requestUser) {
        if(reservation.getMember().getEmail().equals(requestUser))
            return;
        throw new ReservationNotFoundException();

    }
}
