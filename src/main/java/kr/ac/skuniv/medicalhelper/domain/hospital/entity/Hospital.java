package kr.ac.skuniv.medicalhelper.domain.hospital.entity;

import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.entity.HospitalComment;
import kr.ac.skuniv.medicalhelper.global.common.JpaBasePersistable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "hospital")
@AttributeOverride(name = "id", column = @Column(name="hospital_id"))
public class Hospital extends JpaBasePersistable {

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

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<HospitalComment> hospitalComment = new ArrayList<>();

}
