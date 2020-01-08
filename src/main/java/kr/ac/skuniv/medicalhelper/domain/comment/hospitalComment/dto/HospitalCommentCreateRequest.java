package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.dto;

import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HospitalCommentCreateRequest {
    private Float score;
    private String comment;
    private Long hospitalNo;

    @Builder
    public HospitalCommentCreateRequest(Float score, String comment, Long hospitalNo) {
        this.score = score;
        this.comment = comment;
        this.hospitalNo = hospitalNo;
    }
}
