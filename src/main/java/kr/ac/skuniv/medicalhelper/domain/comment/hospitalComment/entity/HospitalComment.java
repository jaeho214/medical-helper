package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.entity;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HospitalComment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hcNo;

    private Float score; // 5점 만점
    private String comment;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospitalNo")
    private Hospital hospital;

    @Builder
    public HospitalComment(Float score, String comment, Member member, Hospital hospital) {
        this.score = score;
        this.comment = comment;
        this.member = member;
        this.hospital = hospital;
    }
}
