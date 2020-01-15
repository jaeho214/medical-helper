package kr.ac.skuniv.medicalhelper.domain.drug.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DrugUpdateRequest {
    private Long id;
    private LocalDateTime deadline;
    private boolean breakfast;
    private boolean lunch;
    private boolean dinner;

    public DrugUpdateRequest(Long id, LocalDateTime deadline, boolean breakfast, boolean lunch, boolean dinner) {
        this.id = id;
        this.deadline = deadline;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }
}
