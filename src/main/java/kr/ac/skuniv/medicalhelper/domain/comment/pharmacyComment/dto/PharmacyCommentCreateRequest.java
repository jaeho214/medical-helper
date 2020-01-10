package kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.dto;


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
}
