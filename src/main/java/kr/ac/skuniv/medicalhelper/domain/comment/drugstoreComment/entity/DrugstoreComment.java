package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.entity;

import kr.ac.skuniv.medicalhelper.domain.drugstore.entity.Drugstore;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DrugstoreComment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dcNo;

    private Float score; // 5점 만점
    private String comment;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drugstoreNo")
    private Drugstore drugstore;

    @Builder
    public DrugstoreComment(Float score, String comment, Member member, Drugstore drugstore) {
        this.score = score;
        this.comment = comment;
        this.member = member;
        this.drugstore = drugstore;
    }

}
