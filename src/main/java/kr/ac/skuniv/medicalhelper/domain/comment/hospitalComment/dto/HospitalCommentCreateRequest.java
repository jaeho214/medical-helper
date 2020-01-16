package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.dto;

import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HospitalCommentCreateRequest {
    private int score;
    private String comment;
    private Long hospitalId;

    @Builder
    public HospitalCommentCreateRequest(int score, String comment, Long hospitalId) {
        this.score = score;
        this.comment = comment;
        this.hospitalId = hospitalId;
    }
}
