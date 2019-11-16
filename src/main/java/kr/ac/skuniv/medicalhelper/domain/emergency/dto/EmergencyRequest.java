package kr.ac.skuniv.medicalhelper.domain.emergency.dto;

import lombok.*;

@Builder
@Getter @Setter
@NoArgsConstructor
public class EmergencyRequest {
    private String item;
    private String value;

    public EmergencyRequest(String item, String value) {
        this.item = item;
        this.value = value;
    }
}
