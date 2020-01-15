package kr.ac.skuniv.medicalhelper.domain.treatment.entity;

import kr.ac.skuniv.medicalhelper.domain.drug.entity.Drug;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentUpdateRequest;
import kr.ac.skuniv.medicalhelper.global.common.JpaBasePersistable;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "treatment")
@AttributeOverride(name = "id", column = @Column(name="treatment_id"))
public class Treatment extends JpaBasePersistable {

    private String title; // 진단명
    private String solution; // 받은 처방 기록
    private String doctor; // 의사명

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_no")
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "drug_id")
    private Drug drug;

    @Builder
    public Treatment(String title, String solution, String doctor, Reservation reservation, Member member, Drug drug) {
        this.title = title;
        this.solution = solution;
        this.doctor = doctor;
        this.reservation = reservation;
        this.member = member;
        this.drug = drug;
    }

    public void updateTreatment(TreatmentUpdateRequest treatmentUpdateRequest){
        this.title = treatmentUpdateRequest.getTitle();
        this.solution = treatmentUpdateRequest.getSolution();
        this.doctor = treatmentUpdateRequest.getDoctorName();
    }
}
