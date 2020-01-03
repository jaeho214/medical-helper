package kr.ac.skuniv.medicalhelper.domain.treatment.entity;

import kr.ac.skuniv.medicalhelper.global.config.BooleanToYNConverter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Drug {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long drugNo;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean breakfast = false;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean lunch = false;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean dinner = false;
}
