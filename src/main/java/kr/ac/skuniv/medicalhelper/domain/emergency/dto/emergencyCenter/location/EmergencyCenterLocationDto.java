package kr.ac.skuniv.medicalhelper.domain.emergency.dto.emergencyCenter.location;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.EmergencyHeaderDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@Getter @Setter
@XmlRootElement(name = "response")
public class EmergencyCenterLocationDto {
    @XmlElement(name = "header")
    private EmergencyHeaderDto header;

    @XmlElement(name = "body")
    private EmergencyCenterLocationBodyDto body;
}
