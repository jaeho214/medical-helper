package kr.ac.skuniv.medicalhelper.domain.member.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberUpdateRequest {
    private String userId;
    private String password;
    private String name;
    private String phone;
    private String sex;
    private String address;

    @Builder
    public MemberUpdateRequest(String userId, String password, String name, String phone, String sex, String address) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.address = address;
    }
}
