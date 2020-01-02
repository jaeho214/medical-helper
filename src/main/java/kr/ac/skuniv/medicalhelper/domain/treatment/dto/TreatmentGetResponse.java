package kr.ac.skuniv.medicalhelper.domain.treatment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TreatmentGetResponse {
    private Long tno;
    private String title;
    private String solution;
    private String doctorName;
    private Hospital hospital;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate treatedDate;

    @Builder
    public TreatmentGetResponse(Long tno,String title, String solution, String doctorName, Hospital hospital, LocalDate treatedDate) {
        this.tno = tno;
        this.title = title;
        this.solution = solution;
        this.doctorName = doctorName;
        this.hospital = hospital;
        this.treatedDate = treatedDate;
    }

    public static TreatmentGetResponse of(Treatment treatment){
        return TreatmentGetResponse.builder()
                .tno(treatment.getTno())
                .title(treatment.getTitle())
                .solution(treatment.getSolution())
                .doctorName(treatment.getDoctor())
                .hospital(treatment.getHospital())
                .treatedDate(treatment.getTreatedDate())
                .build();
    }

}
