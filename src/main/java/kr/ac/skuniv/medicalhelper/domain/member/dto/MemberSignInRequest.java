package kr.ac.skuniv.medicalhelper.domain.member.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSignInRequest {
    private String email;
    private String password;

    @Builder
    public MemberSignInRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
