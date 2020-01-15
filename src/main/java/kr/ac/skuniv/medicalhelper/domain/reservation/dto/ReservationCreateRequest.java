package kr.ac.skuniv.medicalhelper.domain.reservation.dto;

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
    private Long hospitalId;

    @Builder
    public ReservationCreateRequest(LocalDateTime reserveDate, String symptom, Long hospitalId) {
        this.reserveDate = reserveDate;
        this.symptom = symptom;
        this.hospitalId = hospitalId;
    }
}
