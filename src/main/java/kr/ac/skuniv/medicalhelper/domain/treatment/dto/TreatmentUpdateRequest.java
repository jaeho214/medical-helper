package kr.ac.skuniv.medicalhelper.domain.treatment.dto;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TreatmentUpdateRequest {
    private Long tno;
    private String title;
    private String solution;
    private String doctorName;
    private Hospital hospital;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate treatedDate;
}
