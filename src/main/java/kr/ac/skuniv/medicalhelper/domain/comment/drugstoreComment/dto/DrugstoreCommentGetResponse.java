package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.dto;

import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.entity.DrugstoreComment;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DrugstoreCommentGetResponse {
    private Long dcNo;
    private Float score; // 5점 만점
    private String comment;
    private Member member;

    @Builder
    public DrugstoreCommentGetResponse(Long dcNo, Float score, String comment, Member member) {
        this.dcNo = dcNo;
        this.score = score;
        this.comment = comment;
        this.member = member;
    }

    public static DrugstoreCommentGetResponse entity2dto(DrugstoreComment drugstoreComment){
        return DrugstoreCommentGetResponse.builder()
                .dcNo(drugstoreComment.getDcNo())
                .score(drugstoreComment.getScore())
                .comment(drugstoreComment.getComment())
                .member(drugstoreComment.getMember())
                .build();
    }
}
