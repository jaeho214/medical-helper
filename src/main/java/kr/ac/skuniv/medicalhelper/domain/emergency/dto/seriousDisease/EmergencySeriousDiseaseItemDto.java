package kr.ac.skuniv.medicalhelper.domain.emergency.dto.seriousDisease;


import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencySeriousDiseaseItemDto {
    @XmlElement(name = "dutyName")
    private String dutyName;

    @XmlElement(name = "MKioskTy1")
    private String mkioskTy1; //뇌출혈
    @XmlElement(name = "MKioskTy10")
    private String MKioskTy10; //신생아 수술
    @XmlElement(name = "MKioskTy11")
    private String MKioskTy11; //중증 화상

    @XmlElement(name = "MKioskTy2")
    private String MKioskTy2; //뇌경색의재관류
    @XmlElement(name = "MKioskTy25")
    private String MKioskTy25;
    @XmlElement(name = "MKioskTy3")
    private String MKioskTy3; // 심근경색의재관류
    @XmlElement(name = "MKioskTy4")
    private String MKioskTy4; //복부손상의 수술
    @XmlElement(name = "MKioskTy5")
    private String MKioskTy5; //사지접합의 수술
    @XmlElement(name = "MKioskTy6")
    private String MKioskTy6; //응급내시경 수술
    @XmlElement(name = "MKioskTy7")
    private String MKioskTy7; //응급 투석 수술
    @XmlElement(name = "MKioskTy8")
    private String MKioskTy8; // 조산산모 수술
    @XmlElement(name = "MKioskTy9")
    private String MKioskTy9; //정신질환자
}
