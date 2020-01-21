package kr.ac.skuniv.medicalhelper.domain.emergency.dto.traumaCenter.info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyTraumaCenterInfoBodyDto {
    @XmlElement(name = "items")
    private List<EmergencyTraumaCenterInfoItemDto> items;

    @XmlElement(name = "numOfRows")
    private int numOfRows;

    @XmlElement(name = "pageNo")
    private int pageNo;

    @XmlElement(name = "totalCount")
    private int totalCount;
}
