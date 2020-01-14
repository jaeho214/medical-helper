package kr.ac.skuniv.medicalhelper.domain.treatment.dto;

import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.drug.entity.Drug;
import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TreatmentUpdateRequest {
    private Long id;
    private String title;
    private String solution;
    private String doctorName;
    private Reservation reservation;
    private Drug drug;

    @Builder
    public TreatmentUpdateRequest(Long id, String title, String solution, String doctorName, Reservation reservation, Drug drug) {
        this.id = id;
        this.title = title;
        this.solution = solution;
        this.doctorName = doctorName;
        this.reservation = reservation;
        this.drug = drug;
    }
}
