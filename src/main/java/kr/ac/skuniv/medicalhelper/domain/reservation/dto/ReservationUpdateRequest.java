package kr.ac.skuniv.medicalhelper.domain.reservation.dto;

import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationUpdateRequest {
    private Long id;
    private String symptom;

    @Builder
    public ReservationUpdateRequest(Long id, String symptom) {
        this.id = id;
        this.symptom = symptom;
    }
}
