package kr.ac.skuniv.medicalhelper.domain.emergency.dto.seriousDisease;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencySeriousDiseaseItemsDto {

    @XmlElement(name = "item")
    private List<EmergencySeriousDiseaseItemDto> item;
}
