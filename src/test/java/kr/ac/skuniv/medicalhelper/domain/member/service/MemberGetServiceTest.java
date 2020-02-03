package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberGetResponse;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;



@RunWith(SpringRunner.class)
@SpringBootTest
class MemberGetServiceTest {

    @Autowired
    MemberGetService memberGetService;

//    @Test
//    void selectMember() {
//        MemberGetResponse memberGetResponse = memberGetService.getMember("");
//
//        assertThat(memberGetResponse.getName()).isEqualTo("현재호");
//        assertThat(memberGetResponse.getPhone()).isEqualTo("010-1111-2222");
//        assertThat(memberGetResponse.getSex()).isEqualTo("male");
//
//    }
}