package kr.ac.skuniv.medicalhelper.domain.pharmacy.entity;

import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.entity.PharmacyComment;
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
@Table(name = "pharmacy")
@AttributeOverride(name = "id", column = @Column(name="pharmacy_id"))
public class Pharmacy extends JpaBasePersistable {
    private String name;
    private String tel;
    private String address;
    private String pharmacyCode;
    private String pharmacyCodeName;
    private String openDate;
    private String postNo;
    private String stateCode; // 시군구코드
    private String stateCodeName;
    private String cityCode; // 시도 코드
    private String cityCodeName;
    private String localName;
    private String xPos;
    private String yPos;

    @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL)
    private List<PharmacyComment> pharmacyComment = new ArrayList<>();

}
