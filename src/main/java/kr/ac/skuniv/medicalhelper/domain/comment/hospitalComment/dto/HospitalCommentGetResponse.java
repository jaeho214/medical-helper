package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.dto;

import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.entity.HospitalComment;
import kr.ac.skuniv.medicalhelper.domain.hospital.dto.HospitalGetResponse;
import kr.ac.skuniv.medicalhelper.domain.hospital.repository.HospitalRepository;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HospitalCommentGetResponse {
    private Long hcNo;
    private Float score; // 5점 만점
    private String comment;
    private Member member;

    @Builder
    public HospitalCommentGetResponse(Long hcNo, Float score, String comment, Member member) {
        this.hcNo = hcNo;
        this.score = score;
        this.comment = comment;
        this.member = member;
    }

    public static HospitalCommentGetResponse entity2dto(HospitalComment hospitalComment){
        return HospitalCommentGetResponse.builder()
                .hcNo(hospitalComment.getHcNo())
                .comment(hospitalComment.getComment())
                .score(hospitalComment.getScore())
                .member(hospitalComment.getMember())
                .build();
    }
}
