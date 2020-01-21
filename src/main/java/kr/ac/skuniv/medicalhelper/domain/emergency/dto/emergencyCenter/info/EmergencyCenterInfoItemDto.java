package kr.ac.skuniv.medicalhelper.domain.emergency.dto.emergencyCenter.info;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyCenterInfoItemDto {
    private String hpid;
    private String dutyName;
    private String postCdn1;
    private String postCdn2;
    private String dutyAddr;
    private String dutyTel1;
    private String dutyTel3;
    private int hvec;
    private int hvoc;
    private int hvcc;
    private int hvncc;
    private int hvccc;
    private int hvicc;
    private int hvgc;
    private int dutyHayn;
    private int dutyHano;
    private int dutyEryn;
    private String dutyTime1c;
    private String dutyTime1s;
    private String dutyTime2c;
    private String dutyTime2s;
    private String dutyTime3c;
    private String dutyTime3s;
    private String dutyTime4c;
    private String dutyTime4s;
    private String dutyTime5c;
    private String dutyTime5s;
    private String dutyTime6c;
    private String dutyTime6s;
    private String dutyTime7c;
    private String dutyTime7s;
    private String dutyTime8c;
    private String dutyTime8s;
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
    private String wgs84Lon;
    private String wgs84Lat;
    private int hpbdn;
    private int hpccuyn;
    private int hpcuyn;
    private int hperyn;
    private int hpgryn;
    private int hpicuyn;
    private int hpnicuyn;
    private int hpopyn;
}
