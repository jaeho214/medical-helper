package kr.ac.skuniv.medicalhelper.domain.evaluation.drugstore.entity;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class DrugstoreComment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dcNo;

    private Float score; // 5점 만점
    private String comment;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public DrugstoreComment(Float score, String comment, Member member) {
        this.score = score;
        this.comment = comment;
        this.member = member;
    }
}
