package kr.ac.skuniv.medicalhelper.domain.reservation.dto;

import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationUpdateRequest {
    private Long rno;
    private String symptom;

    @Builder
    public ReservationUpdateRequest(Long rno, String symptom) {
        this.rno = rno;
        this.symptom = symptom;
    }
}
