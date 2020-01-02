package kr.ac.skuniv.medicalhelper.domain.reservation.dto;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationCreateRequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime reserveDate;
    private String symptom;
    private Hospital hospital;

    @Builder
    public ReservationCreateRequest(LocalDateTime reserveDate, String symptom, Hospital hospital) {
        this.reserveDate = reserveDate;
        this.symptom = symptom;
        this.hospital = hospital;
    }
}
