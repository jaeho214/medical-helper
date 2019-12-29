package kr.ac.skuniv.medicalhelper.domain.treatment.dto;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TreatmentPostRequest {
    private String title;
    private String solution;
    private String doctorName;
    private Hospital hospital;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate treatedDate;
}
