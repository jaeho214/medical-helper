package kr.ac.skuniv.medicalhelper.domain.hospital.entity;

import kr.ac.skuniv.medicalhelper.domain.evaluation.hospital.entity.HospitalComment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Hospital {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalNo;

    private String name;
    private String tel;
    private String address;
    private String hospitalCode;
    private String hospitalCodeName;
    private int doctorCount;
    private String openDate;
    private int generalDoctorCount;
    private String hospitalUrl;
    private int internCount;
    private String postNo;
    private int residentCount;
    private int specialDoctorCount;
    private String stateCode; // 시군구코드
    private String cityCode; // 시도 코드
    private String cityCodeName;
    private String xPos;
    private String yPos;

    @OneToMany
    @JoinColumn(name = "hcNo")
    private List<HospitalComment> hospitalComment = new ArrayList<>();


    public Hospital(List<HospitalComment> hospitalComment) {
        this.hospitalComment = hospitalComment;
    }
}
