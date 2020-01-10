package kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.dto;

import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.entity.PharmacyComment;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PharmacyCommentGetResponse {
    private Long id;
    private int score; // 5점 만점
    private String comment;
    private Member member;

    @Builder
    public PharmacyCommentGetResponse(Long id, int score, String comment, Member member) {
        this.id = id;
        this.score = score;
        this.comment = comment;
        this.member = member;
    }

    public static PharmacyCommentGetResponse entity2dto(PharmacyComment pharmacyComment){
        return PharmacyCommentGetResponse.builder()
                .id(pharmacyComment.getId())
                .score(pharmacyComment.getScore())
                .comment(pharmacyComment.getComment())
                .member(pharmacyComment.getMember())
                .build();
    }
}
