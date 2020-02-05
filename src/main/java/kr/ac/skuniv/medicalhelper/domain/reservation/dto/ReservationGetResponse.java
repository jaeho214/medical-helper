package kr.ac.skuniv.medicalhelper.domain.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.ReservationStatus;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationGetResponse {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone="asia/Seoul")
    private LocalDate reserveDate;

    private String reserveTime;
    private String symptom;
    private Hospital hospital;
    private ReservationStatus status;

    @Builder
    public ReservationGetResponse(Long id, LocalDate reserveDate, String reserveTime, String symptom, Hospital hospital, ReservationStatus status) {
        this.id = id;
        this.reserveDate = reserveDate;
        this.reserveTime = reserveTime;
        this.symptom = symptom;
        this.hospital = hospital;
        this.status = status;
    }

    public static ReservationGetResponse entity2dto(Reservation reservation){
        return ReservationGetResponse.builder()
                .id(reservation.getId())
                .reserveDate(reservation.getReserveDate())
                .reserveTime(reservation.getReserveTime())
                .symptom(reservation.getSymptom())
                .hospital(reservation.getHospital())
                .status(reservation.getStatus())
                .build();
    }
}
