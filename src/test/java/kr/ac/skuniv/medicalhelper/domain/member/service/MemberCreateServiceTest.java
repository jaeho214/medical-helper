package kr.ac.skuniv.medicalhelper.domain.member.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberCreateRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MemberCreateServiceTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MemberCreateService memberCreateService;

    @Test
    public void createMember() throws Exception {
        MemberCreateRequest memberCreateRequest = MemberCreateRequest.builder()
                .userId("jaeho214")
                .password("1")
                .address("경기도 시흥시")
                .birth("1996-02-14")
                .name("현재호")
                .phone("010-5311-8729")
                .sex("male")
                .build();


        memberCreateService.createMember(memberCreateRequest);

    }

}