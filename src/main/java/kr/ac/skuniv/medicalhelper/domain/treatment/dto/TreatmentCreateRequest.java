package kr.ac.skuniv.medicalhelper.domain.treatment.dto;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TreatmentCreateRequest {
    private String title;
    private String solution;
    private String doctorName;
    private Hospital hospital;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate treatedDate;

    @Builder
    public TreatmentCreateRequest(String title, String solution, String doctorName, Hospital hospital, LocalDate treatedDate) {
        this.title = title;
        this.solution = solution;
        this.doctorName = doctorName;
        this.hospital = hospital;
        this.treatedDate = treatedDate;
    }
}
