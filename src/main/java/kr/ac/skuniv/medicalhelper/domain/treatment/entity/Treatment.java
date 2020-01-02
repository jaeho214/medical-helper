package kr.ac.skuniv.medicalhelper.domain.treatment.entity;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentUpdateRequest;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Treatment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tno;

    private String title; // 진단명
    private String solution; // 받은 처방 기록
    private String doctor; // 의사명
    private LocalDate treatedDate; // 처방 날짜

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_no")
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Treatment(String title, String solution, String doctor, LocalDate treatedDate, Hospital hospital, Member member) {
        this.title = title;
        this.solution = solution;
        this.doctor = doctor;
        this.treatedDate = treatedDate;
        this.hospital = hospital;
        this.member = member;
    }

    public static Treatment of(TreatmentCreateRequest treatmentCreateRequest){
        return Treatment.builder()
                .title(treatmentCreateRequest.getTitle())
                .solution(treatmentCreateRequest.getSolution())
                .doctor(treatmentCreateRequest.getDoctorName())
                .treatedDate(treatmentCreateRequest.getTreatedDate())
                .hospital(treatmentCreateRequest.getHospital())
                .build();
    }

    public void updateTreatment(TreatmentUpdateRequest treatmentUpdateRequest){
        this.title = treatmentUpdateRequest.getTitle();
        this.solution = treatmentUpdateRequest.getSolution();
        this.doctor = treatmentUpdateRequest.getDoctorName();
        this.treatedDate = treatmentUpdateRequest.getTreatedDate();
        this.hospital = treatmentUpdateRequest.getHospital();
    }
}
