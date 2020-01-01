package kr.ac.skuniv.medicalhelper.domain.member.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberSignInRequest {
    private String userId;
    private String password;
}
