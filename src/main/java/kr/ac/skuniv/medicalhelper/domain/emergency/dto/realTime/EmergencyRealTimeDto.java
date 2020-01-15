package kr.ac.skuniv.medicalhelper.domain.emergency.dto.realTime;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.EmergencyHeaderDto;
import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@Getter
@XmlRootElement(name = "response")
public class EmergencyRealTimeDto {
    @XmlElement(name = "body")
    private EmergencyRealTimeBodyDto body;

    @XmlElement(name = "header")
    private EmergencyHeaderDto header;
}
