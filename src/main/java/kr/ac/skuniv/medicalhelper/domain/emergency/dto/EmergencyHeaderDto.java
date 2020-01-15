package kr.ac.skuniv.medicalhelper.domain.emergency.dto;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@XmlRootElement(name = "header")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyHeaderDto {
    @XmlElement(name = "resultCode")
    private int resultCode;

    @XmlElement(name = "resultMsg")
    private String resultMsg;

}
