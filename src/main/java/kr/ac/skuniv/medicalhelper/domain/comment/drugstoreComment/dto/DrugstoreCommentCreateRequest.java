package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.dto;


import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DrugstoreCommentCreateRequest {
    private Float score;
    private String comment;
    private Long drugstoreNo;

    @Builder
    public DrugstoreCommentCreateRequest(Float score, String comment, Long drugstoreNo) {
        this.score = score;
        this.comment = comment;
        this.drugstoreNo = drugstoreNo;
    }
}
