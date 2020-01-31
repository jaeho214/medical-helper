package kr.ac.skuniv.medicalhelper.domain.reservation.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.global.common.JpaBasePersistable;
import kr.ac.skuniv.medicalhelper.global.config.BooleanToYNConverter;
import kr.ac.skuniv.medicalhelper.global.config.LocalDateConfig;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "reservation")
@AttributeOverride(name = "id", column = @Column(name="reservation_id"))
public class Reservation extends JpaBasePersistable {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reserveDate;
    private String reserveTime;
    private String symptom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_no")
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @Builder
    public Reservation(LocalDate reserveDate,String reserveTime, String symptom, Hospital hospital, Member member, ReservationStatus status) {
        this.reserveDate = reserveDate;
        this.reserveTime = reserveTime;
        this.symptom = symptom;
        this.hospital = hospital;
        this.member = member;
        this.status = status;
    }


    public void updateSymptom(String symptom){
        this.symptom = symptom;
    }

    public void updateStatus(ReservationStatus status){
        this.status = status;
    }

}
