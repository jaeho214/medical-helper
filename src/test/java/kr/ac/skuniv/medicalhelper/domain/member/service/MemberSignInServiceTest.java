package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberSignInRequest;
import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberSignInResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
class MemberSignInServiceTest {

    @Autowired
    MemberSignInService memberSignInService;

    @Test
    void signInMember() {
        String userId = "jaeho214";
        String password = "1";

        MemberSignInRequest memberSignInRequest = new MemberSignInRequest();
        memberSignInRequest.setUserId(userId);
        memberSignInRequest.setPassword(password);

        MemberSignInResponse memberSignInResponse = memberSignInService.signInMember(memberSignInRequest);

        assertThat(memberSignInResponse.getName()).isEqualTo("현재호");
    }

    @Test
    void signInMember_Exception() {
        String userId = "jaeho215";
        String password = "1";

        MemberSignInRequest memberSignInRequest = new MemberSignInRequest();
        memberSignInRequest.setUserId(userId);
        memberSignInRequest.setPassword(password);

        MemberSignInResponse memberSignInResponse = memberSignInService.signInMember(memberSignInRequest);

        assertThat(memberSignInResponse.getName()).isEqualTo("현재호");
    }
}