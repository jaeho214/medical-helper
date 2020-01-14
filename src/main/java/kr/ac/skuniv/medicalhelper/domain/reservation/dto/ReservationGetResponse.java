package kr.ac.skuniv.medicalhelper.domain.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationGetResponse {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING, timezone="asia/Seoul")
    private LocalDateTime reserveDate;

    private String reserveTime;
    private String symptom;
    private Hospital hospital;

    @Builder
    public ReservationGetResponse(Long id, LocalDateTime reserveDate, String reserveTime, String symptom, Hospital hospital) {
        this.id = id;
        this.reserveDate = reserveDate;
        this.reserveTime = reserveTime;
        this.symptom = symptom;
        this.hospital = hospital;
    }

    public static ReservationGetResponse entity2dto(Reservation reservation){
        return ReservationGetResponse.builder()
                .id(reservation.getId())
                .reserveDate(reservation.getReserveDate())
                .symptom(reservation.getSymptom())
                .hospital(reservation.getHospital())
                .build();
    }
}
