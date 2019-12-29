package kr.ac.skuniv.medicalhelper.domain.drugstore.entity;

import kr.ac.skuniv.medicalhelper.domain.evaluation.drugstore.entity.DrugstoreComment;
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
public class Drugstore {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugstoreNo;

    private String name;
    private String tel;
    private String address;
    private String drugstoreCode;
    private String drugstoreCodeName;
    private String openDate;
    private String postNo;
    private String stateCode; // 시군구코드
    private String stateCodeName;
    private String cityCode; // 시도 코드
    private String cityCodeName;
    private String localName;
    private String xPos;
    private String yPos;

    @OneToMany
    @JoinColumn(name = "dcNo")
    private List<DrugstoreComment> drugstoreComment = new ArrayList<>();

}
