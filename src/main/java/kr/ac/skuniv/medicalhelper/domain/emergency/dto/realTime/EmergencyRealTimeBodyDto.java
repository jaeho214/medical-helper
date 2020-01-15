package kr.ac.skuniv.medicalhelper.domain.emergency.dto.realTime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyRealTimeBodyDto {
    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    private List<EmergencyRealTimeItemDto> item;

    @XmlElement(name = "numOfRows")
    private int numOfRows;

    @XmlElement(name = "pageNo")
    private int pageNo;

    @XmlElement(name = "totalCount")
    private int totalCount;
}
