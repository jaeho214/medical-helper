package kr.ac.skuniv.medicalhelper.domain.treatment.dto;

import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TreatmentUpdateRequest {
    private Long id;
    private String title;
    private String solution;
    private String doctorName;


    @Builder
    public TreatmentUpdateRequest(Long id, String title, String solution, String doctorName) {
        this.id = id;
        this.title = title;
        this.solution = solution;
        this.doctorName = doctorName;
    }
}
