package kr.ac.skuniv.medicalhelper.domain.treatment.dto;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TreatmentGetResponse {
    private String name;
    private String solution;
    private String doctorName;
    private Hospital hospital;

    @Builder
    public TreatmentGetResponse(String name, String solution, String doctorName, Hospital hospital) {
        this.name = name;
        this.solution = solution;
        this.doctorName = doctorName;
        this.hospital = hospital;
    }
}
