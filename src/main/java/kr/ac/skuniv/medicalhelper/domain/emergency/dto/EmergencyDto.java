package kr.ac.skuniv.medicalhelper.domain.emergency.dto;

import lombok.*;

@Builder
@Getter @Setter
@NoArgsConstructor
public class EmergencyDto {
    private String item;
    private String value;

    public EmergencyDto(String item, String value) {
        this.item = item;
        this.value = value;
    }
}
