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

    @Test
    void updateMember() {
        MemberUpdateRequest memberUpdateRequest
                = MemberUpdateRequest.builder()
                .userId("jaeho214")
                .address("서울시 성북구")
                .name("김수현")
                .password("1")
                .phone("010-5311-8729")
                .sex("male")
                .build();

        memberUpdateService.updateMember(memberUpdateRequest);
    }
}