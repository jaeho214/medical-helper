package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.dto;

import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DrugstoreCommentGetResponse {
    private Float score;
    private String comment;
    private String userId;
}
