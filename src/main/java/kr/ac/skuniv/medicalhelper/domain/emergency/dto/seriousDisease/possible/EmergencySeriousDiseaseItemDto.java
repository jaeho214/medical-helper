package kr.ac.skuniv.medicalhelper.domain.emergency.dto.seriousDisease.possible;


import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@ToString
@Getter @Setter
@NoArgsConstructor
@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencySeriousDiseaseItemDto {

    private String dutyName;
    @JsonSetter("MKioskTy1")
    private String MKioskTy1; //뇌출혈
    @JsonSetter("MKioskTy10")
    private String MKioskTy10; //신생아 수술
    @JsonSetter("MKioskTy11")
    private String MKioskTy11; //중증 화상

    @JsonSetter("MKioskTy2")
    private String MKioskTy2; //뇌경색의재관류
    @JsonSetter("MKioskTy25")
    private String MKioskTy25;
    @JsonSetter("MKioskTy3")
    private String MKioskTy3; // 심근경색의재관류
    @JsonSetter("MKioskTy4")
    private String MKioskTy4; //복부손상의 수술
    @JsonSetter("MKioskTy5")
    private String MKioskTy5; //사지접합의 수술
    @JsonSetter("MKioskTy6")
    private String MKioskTy6; //응급내시경 수술
    @JsonSetter("MKioskTy7")
    private String MKioskTy7; //응급 투석 수술
    @JsonSetter("MKioskTy8")
    private String MKioskTy8; // 조산산모 수술
    @JsonSetter("MKioskTy9")
    private String MKioskTy9; //정신질환자
}
