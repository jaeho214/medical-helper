package kr.ac.skuniv.medicalhelper.domain.member.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
class CheckDuplicatedIdServiceTest {

    @Autowired
    CheckDuplicatedIdService checkDuplicatedIdService;

//    @Test
//    void checkId() {
//        String userId = "jaeho214@naver.com";
//        boolean isExist = checkDuplicatedIdService.checkId(userId);
//
//        assertThat(isExist).isFalse();
//    }
}