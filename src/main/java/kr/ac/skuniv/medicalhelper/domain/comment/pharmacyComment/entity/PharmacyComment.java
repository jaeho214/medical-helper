package kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.entity;

import kr.ac.skuniv.medicalhelper.domain.pharmacy.entity.Pharmacy;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.global.common.JpaBasePersistable;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "pharmacyComment")
@AttributeOverride(name = "id", column = @Column(name="pharmacyComment_id"))
public class PharmacyComment extends JpaBasePersistable {
    private int score; // 5점 만점
    private String comment;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;

    @Builder
    public PharmacyComment(int score, String comment, Member member, Pharmacy pharmacy) {
        this.score = score;
        this.comment = comment;
        this.member = member;
        this.pharmacy = pharmacy;
    }

}
