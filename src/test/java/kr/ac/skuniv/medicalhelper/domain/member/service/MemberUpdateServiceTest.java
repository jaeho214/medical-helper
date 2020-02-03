package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberUpdateRequest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberUpdateServiceTest {

    @Autowired
    MemberUpdateService memberUpdateService;

//    @Test
//    void updateMember() {
//        MemberUpdateRequest memberUpdateRequest
//                = MemberUpdateRequest.builder()
//                .address("서울시 성북구")
//                .name("김수현")
//                .password("1")
//                .phone("010-3333-4444")
//                .sex("male")
//                .build();
//
//        String token = "";
//        memberUpdateService.updateMember(memberUpdateRequest, token);
//    }
}