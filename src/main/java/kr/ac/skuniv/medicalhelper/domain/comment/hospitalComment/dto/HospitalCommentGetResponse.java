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
    private Long id;
    private int score; // 5점 만점
    private String comment;
    private String writerName;

    @Builder
    public HospitalCommentGetResponse(Long id, int score, String comment, String writerName) {
        this.id = id;
        this.score = score;
        this.comment = comment;
        this.writerName = writerName;
    }

    public static HospitalCommentGetResponse entity2dto(HospitalComment hospitalComment){
        return HospitalCommentGetResponse.builder()
                .id(hospitalComment.getId())
                .comment(hospitalComment.getComment())
                .score(hospitalComment.getScore())
                .writerName(hospitalComment.getMember().getName())
                .build();
    }
}
