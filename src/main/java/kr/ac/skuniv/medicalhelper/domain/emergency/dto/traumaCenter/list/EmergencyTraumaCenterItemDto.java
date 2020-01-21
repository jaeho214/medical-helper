package kr.ac.skuniv.medicalhelper.domain.emergency.dto.traumaCenter.list;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyTraumaCenterItemDto {
    private int rnum;
    private String phid;
    private String phpid;
    private String dutyEmcls;
    private String dutyEmclsName;
    private String dutyAddr;
    private String dutyName;
    private String dutyTel1;
    private String dutyTel3;
    private String wgs84Lon;
    private String wgs84Lat;
}
