package kr.ac.skuniv.medicalhelper.domain.drug.entity;

import kr.ac.skuniv.medicalhelper.domain.drug.dto.DrugUpdateRequest;
import kr.ac.skuniv.medicalhelper.global.common.JpaBasePersistable;
import kr.ac.skuniv.medicalhelper.global.config.BooleanToYNConverter;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "drug")
@AttributeOverride(name = "id", column = @Column(name="drug_id"))
public class Drug extends JpaBasePersistable {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime deadline;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean breakfast = false;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean lunch = false;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean dinner = false;

    @Builder
    public Drug(LocalDateTime deadline, boolean breakfast, boolean lunch, boolean dinner) {
        this.deadline = deadline;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }


    public void updateDrug(DrugUpdateRequest drugUpdateRequest){
        this.deadline = drugUpdateRequest.getDeadline();
        this.breakfast = drugUpdateRequest.isBreakfast();
        this.lunch = drugUpdateRequest.isLunch();
        this.dinner = drugUpdateRequest.isDinner();
    }
}
