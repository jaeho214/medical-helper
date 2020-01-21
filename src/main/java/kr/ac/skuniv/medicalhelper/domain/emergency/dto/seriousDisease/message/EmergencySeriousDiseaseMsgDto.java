package kr.ac.skuniv.medicalhelper.domain.emergency.dto.seriousDisease.message;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.EmergencyHeaderDto;
import kr.ac.skuniv.medicalhelper.domain.emergency.dto.seriousDisease.possible.EmergencySeriousDiseaseBodyDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@Getter
@Setter
@XmlRootElement(name = "response")
public class EmergencySeriousDiseaseMsgDto {
    @XmlElement(name = "header")
    private EmergencyHeaderDto header;

    @XmlElement(name = "body")
    private EmergencySeriousDiseaseMsgBodyDto body;
}