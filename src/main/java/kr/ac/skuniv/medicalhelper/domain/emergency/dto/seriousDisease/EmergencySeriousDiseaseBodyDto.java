package kr.ac.skuniv.medicalhelper.domain.emergency.dto.seriousDisease;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.List;

@ToString
@Getter @Setter
@NoArgsConstructor
@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencySeriousDiseaseBodyDto {

    @XmlElement(name = "items")
    private List<EmergencySeriousDiseaseItemDto> items;

    @XmlElement(name = "numOfRows")
    private int numOfRows;

    @XmlElement(name = "pageNo")
    private int pageNo;

    @XmlElement(name = "totalCount")
    private int totalCount;
}
