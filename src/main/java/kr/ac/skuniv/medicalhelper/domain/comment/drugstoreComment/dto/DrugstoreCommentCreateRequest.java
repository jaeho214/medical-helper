package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.dto;


import kr.ac.skuniv.medicalhelper.domain.drugstore.entity.Drugstore;
import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DrugstoreCommentCreateRequest {
    private Float score;
    private String comment;
    private Drugstore drugstore;

    @Builder
    public DrugstoreCommentCreateRequest(Float score, String comment, Drugstore drugstore) {
        this.score = score;
        this.comment = comment;
        this.drugstore = drugstore;
    }
}
