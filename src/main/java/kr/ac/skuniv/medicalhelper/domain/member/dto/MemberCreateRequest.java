package kr.ac.skuniv.medicalhelper.domain.member.dto;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberCreateRequest {

    @NotNull @Email
    private String email;
    private String password;
    private String name;
    private String phone;
    private String birth;
    private String sex;
    private String address;
    private String fcmToken;

    @Builder
    public MemberCreateRequest(String email, String password, String name, String phone, String birth, String sex, String address, String fcmToken) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.sex = sex;
        this.address = address;
        this.fcmToken = fcmToken;
    }

    public Member toEntity(){
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .birth(birth)
                .sex(sex)
                .address(address)
                .fcmToken(fcmToken)
                .build();
    }
}
