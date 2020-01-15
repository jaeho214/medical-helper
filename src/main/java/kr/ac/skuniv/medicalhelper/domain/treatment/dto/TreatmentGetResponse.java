package kr.ac.skuniv.medicalhelper.domain.treatment.dto;

import kr.ac.skuniv.medicalhelper.domain.drug.entity.Drug;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TreatmentGetResponse {
    private Long id;
    private String title;
    private String solution;
    private String doctorName;
    private Drug drug;

    @Builder
    public TreatmentGetResponse(Long id, String title, String solution, String doctorName, Drug drug) {
        this.id = id;
        this.title = title;
        this.solution = solution;
        this.doctorName = doctorName;
        this.drug = drug;
    }

    public static TreatmentGetResponse entity2dto(Treatment treatment){
        return TreatmentGetResponse.builder()
                .id(treatment.getId())
                .title(treatment.getTitle())
                .solution(treatment.getSolution())
                .doctorName(treatment.getDoctor())
                .drug(treatment.getDrug())
                .build();
    }

}
