package kr.ac.skuniv.medicalhelper.domain.emergency.dto.traumaCenter.location;

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
public class EmergencyTraumaCenterLocationItemDto {
    private int rnum;
    private int cnt;
    private String distance;
    private String dutyAddr;
    private String dutyDiv;
    private String dutyDivName;
    private String dutyFax;
    private String dutyName;
    private String dutyTel1;
    private String endTime;
    private String hpid;
    private String latitude;
    private String longitude;
    private String startTime;
}
