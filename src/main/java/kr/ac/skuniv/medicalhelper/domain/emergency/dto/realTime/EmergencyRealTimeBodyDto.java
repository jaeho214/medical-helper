package kr.ac.skuniv.medicalhelper.domain.emergency.dto.realTime;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@ToString
@Getter @Setter
@NoArgsConstructor
@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyRealTimeBodyDto {

    @XmlElement(name = "items")
    private List<EmergencyRealTimeItemDto> items;

    @XmlElement(name = "numOfRows")
    private int numOfRows;

    @XmlElement(name = "pageNo")
    private int pageNo;

    @XmlElement(name = "totalCount")
    private int totalCount;
}
