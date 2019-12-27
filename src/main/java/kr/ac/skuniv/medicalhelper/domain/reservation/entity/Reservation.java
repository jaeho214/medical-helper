package kr.ac.skuniv.medicalhelper.domain.reservation.entity;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;


    private String reserveDate;
    private String symptom;

    @OneToOne
    @JoinColumn(name = "hospital_no")
    private Hospital hospital;

    @Builder
    public Reservation(Hospital hospital, String reserveDate, String symptom) {
        this.hospital = hospital;
        this.reserveDate = reserveDate;
        this.symptom = symptom;
    }
}
