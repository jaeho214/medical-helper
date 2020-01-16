package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.entity;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.global.common.JpaBasePersistable;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "hospitalComment")
@AttributeOverride(name = "id", column = @Column(name="hospitalComment_id"))
public class HospitalComment extends JpaBasePersistable {

    private int score; // 5점 만점
    private String comment;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Builder
    public HospitalComment(int score, String comment, Member member, Hospital hospital) {
        this.score = score;
        this.comment = comment;
        this.member = member;
        this.hospital = hospital;
    }
}
