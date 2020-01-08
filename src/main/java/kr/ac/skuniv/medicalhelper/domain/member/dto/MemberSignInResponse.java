package kr.ac.skuniv.medicalhelper.domain.member.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSignInResponse {
    private String token;
    private String userId;
    private String name;

    @Builder
    public MemberSignInResponse(String token, String userId, String name) {
        this.token = token;
        this.userId = userId;
        this.name = name;
    }
}
