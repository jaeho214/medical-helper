package kr.ac.skuniv.medicalhelper.domain.reservation.dto;

import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationUpdateRequest {
    private Long tno;
    private String symptom;

    @Builder
    public ReservationUpdateRequest(Long tno, String symptom) {
        this.tno = tno;
        this.symptom = symptom;
    }
}
