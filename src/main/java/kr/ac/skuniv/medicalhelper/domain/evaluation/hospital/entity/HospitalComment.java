package kr.ac.skuniv.medicalhelper.domain.evaluation.hospital.entity;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class HospitalComment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hcNo;

    private Float score; // 5점 만점
    private String comment;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public HospitalComment(Float score, String comment, Member member) {
        this.score = score;
        this.comment = comment;
        this.member = member;
    }
}
