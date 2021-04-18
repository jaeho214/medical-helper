package kr.ac.skuniv.medicalhelper.domain.reservation.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.ReservationStatus;
import kr.ac.skuniv.medicalhelper.global.config.LocalDateConfig;
import lombok.*;

import java.time.LocalDate;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationCreateRequest {
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonDeserialize(using = LocalDateConfig.class)
    private LocalDate reserveDate;
    private String reserveTime;
    private String symptom;
    private Long hospitalId;

    @Builder
    public ReservationCreateRequest(LocalDate reserveDate,String reserveTime, String symptom, Long hospitalId) {
        this.reserveDate = reserveDate;
        this.reserveTime = reserveTime;
        this.symptom = symptom;
        this.hospitalId = hospitalId;
    }

    public Reservation toEntity(Hospital hospital, Member member){
        return Reservation.builder()
                .reserveDate(reserveDate)
                .reserveTime(reserveTime)
                .symptom(symptom)
                .hospital(hospital)
                .member(member)
                .status(ReservationStatus.예약완료)
                .build();
    }
}
