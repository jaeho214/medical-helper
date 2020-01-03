package kr.ac.skuniv.medicalhelper.domain.treatment.dto;

import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Drug;
import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TreatmentCreateRequest {
    private String title;
    private String solution;
    private String doctorName;
    private Reservation reservation;
    private Drug drug;

    @Builder
    public TreatmentCreateRequest(String title, String solution, String doctorName, Reservation reservation, Drug drug) {
        this.title = title;
        this.solution = solution;
        this.doctorName = doctorName;
        this.reservation = reservation;
        this.drug = drug;
    }
}
