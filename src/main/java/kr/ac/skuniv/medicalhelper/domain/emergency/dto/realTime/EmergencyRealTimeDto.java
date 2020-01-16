package kr.ac.skuniv.medicalhelper.domain.emergency.dto.realTime;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.EmergencyHeaderDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@Getter @Setter
@XmlRootElement(name = "response")
public class EmergencyRealTimeDto {
    @XmlElement(name = "header")
    private EmergencyHeaderDto header;

    @XmlElement(name = "body")
    private EmergencyRealTimeBodyDto body;

}
