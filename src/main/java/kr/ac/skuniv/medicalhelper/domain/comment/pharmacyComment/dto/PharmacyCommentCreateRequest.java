package kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.dto;


import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.entity.PharmacyComment;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.pharmacy.entity.Pharmacy;
import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PharmacyCommentCreateRequest {
    private int score;
    private String comment;
    private Long pharmacyId;

    @Builder
    public PharmacyCommentCreateRequest(int score, String comment, Long pharmacyId) {
        this.score = score;
        this.comment = comment;
        this.pharmacyId = pharmacyId;
    }

    public PharmacyComment toEntity(Pharmacy pharmacy, Member member){
        return PharmacyComment.builder()
                .comment(comment)
                .score(score)
                .pharmacy(pharmacy)
                .member(member)
                .build();
    }
}
