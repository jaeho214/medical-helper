package kr.ac.skuniv.medicalhelper.domain.emergency.dto.seriousDisease;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencySeriousDiseaseItemDto {
    @XmlElement(name = "dutyName")
    private String name;

    @XmlElement(name = "mkioskty25")
    private String emergency;

    @XmlElement(name = "mkioskty1")
    private String cerebralHemorrhage; //뇌출혈

    @XmlElement(name = "mkioskty2")
    private String cerebralInfarction; //뇌경색의재관류
    @XmlElement(name = "mkioskty3")
    private String myocardialInfarction; // 심근경색의재관류
    @XmlElement(name = "mkioskty4")
    private String abdomenDamage; //복부손상의 수술
    @XmlElement(name = "mkioskty5")
    private String extremities; //사지접합의 수술
    @XmlElement(name = "mkioskty6")
    private String emergentEndoscope; //응급내시경 수술
    @XmlElement(name = "mkioskty7")
    private String emergentHemodialysis; //응급 투석 수술
    @XmlElement(name = "mkioskty8")
    private String pretermBirth; // 조산산모 수술
    @XmlElement(name = "mkioskty9")
    private String mentalIllness; //정신질환자
    @XmlElement(name = "mkioskty10")
    private String newborn; //신생아 수술
    @XmlElement(name = "mkioskty11")
    private String seriousBurn; //중증 화상
}
