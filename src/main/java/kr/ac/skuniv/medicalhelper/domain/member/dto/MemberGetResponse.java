package kr.ac.skuniv.medicalhelper.domain.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberGetResponse {
    private String email;
    private String name;
    private String phone;
    private String birth;
    private String sex;
    private String address;
    //진료 횟수

    @Builder
    public MemberGetResponse(String email, String name, String phone, String birth, String sex, String address) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.sex = sex;
        this.address = address;
    }
}
