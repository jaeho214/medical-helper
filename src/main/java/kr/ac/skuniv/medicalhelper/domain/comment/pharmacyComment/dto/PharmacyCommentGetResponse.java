package kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.dto;

import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.entity.PharmacyComment;
import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PharmacyCommentGetResponse {
    private Long id;
    private int score; // 5점 만점
    private String comment;
    private String writerName;

    @Builder
    public PharmacyCommentGetResponse(Long id, int score, String comment, String writerName) {
        this.id = id;
        this.score = score;
        this.comment = comment;
        this.writerName = writerName;
    }

    public static PharmacyCommentGetResponse entity2dto(PharmacyComment pharmacyComment){
        return PharmacyCommentGetResponse.builder()
                .id(pharmacyComment.getId())
                .score(pharmacyComment.getScore())
                .comment(pharmacyComment.getComment())
                .writerName(pharmacyComment.getMember().getName())
                .build();
    }
}
