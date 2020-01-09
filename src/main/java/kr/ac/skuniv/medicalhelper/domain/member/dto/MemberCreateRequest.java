package kr.ac.skuniv.medicalhelper.domain.member.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberCreateRequest {
    private String userId;
    private String password;
    private String name;
    private String phone;
    private String birth;
    private String sex;
    private String address;
    private String fcmToken;

    @Builder
    public MemberCreateRequest(String userId, String password, String name, String phone, String birth, String sex, String address, String fcmToken) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.sex = sex;
        this.address = address;
        this.fcmToken = fcmToken;
    }
}
