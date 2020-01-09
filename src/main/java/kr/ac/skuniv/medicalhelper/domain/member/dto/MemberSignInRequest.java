package kr.ac.skuniv.medicalhelper.domain.member.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSignInRequest {
    private String userId;
    private String password;

    @Builder
    public MemberSignInRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
