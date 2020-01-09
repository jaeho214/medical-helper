package kr.ac.skuniv.medicalhelper.domain.member.entity;

import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.entity.DrugstoreComment;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.entity.HospitalComment;
import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberUpdateRequest;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    private String userId;

    private String password;
    private String name;
    private String phone;
    private String birth;
    private String sex;
    private String address;

    private String fcmToken;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<DrugstoreComment> drugstoreComment = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<HospitalComment> hospitalComments = new ArrayList<>();

    @Builder
    public Member(String userId, String password, String name, String phone, String birth, String sex, String address, String fcmToken) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.sex = sex;
        this.address = address;
        this.fcmToken = fcmToken;
    }

    public static Member of(MemberCreateRequest memberCreateRequest){
        return Member.builder()
                .userId(memberCreateRequest.getUserId())
                .password(memberCreateRequest.getPassword())
                .name(memberCreateRequest.getName())
                .phone(memberCreateRequest.getPhone())
                .birth(memberCreateRequest.getBirth())
                .sex(memberCreateRequest.getSex())
                .address(memberCreateRequest.getAddress())
                .fcmToken(memberCreateRequest.getFcmToken())
                .build();
    }

    //아이디, 생일은 변경 불가
    public void updateMember(MemberUpdateRequest memberUpdateRequest) {
        this.password = memberUpdateRequest.getPassword();
        this.name = memberUpdateRequest.getName();
        this.phone = memberUpdateRequest.getPhone();
        this.sex = memberUpdateRequest.getSex();
        this.address = memberUpdateRequest.getAddress();
    }
}
