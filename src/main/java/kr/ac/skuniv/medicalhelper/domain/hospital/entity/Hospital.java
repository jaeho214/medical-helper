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

    private String location;
    private String time;

    @OneToMany
    @JoinColumn(name = "hcNo")
    private List<HospitalComment> hospitalComment = new ArrayList<>();


    public Hospital(String location, String time, List<HospitalComment> hospitalComment) {
        this.location = location;
        this.time = time;
        this.hospitalComment = hospitalComment;
    }
}
