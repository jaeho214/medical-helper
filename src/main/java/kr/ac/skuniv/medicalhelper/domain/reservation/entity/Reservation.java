package kr.ac.skuniv.medicalhelper.domain.reservation.entity;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime reserveDate;
    private String symptom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_no")
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Reservation(Hospital hospital, LocalDateTime reserveDate, String symptom, Member member) {
        this.hospital = hospital;
        this.reserveDate = reserveDate;
        this.symptom = symptom;
        this.member = member;
    }

    public void updateSymptom(String symptom){
        this.symptom = symptom;
    }

}
