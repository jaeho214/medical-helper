package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.dto;

import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.entity.HospitalComment;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
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

    public HospitalComment toEntity(Hospital hospital, Member member){
        return HospitalComment.builder()
                .score(score)
                .comment(comment)
                .hospital(hospital)
                .member(member)
                .build();
    }
}
