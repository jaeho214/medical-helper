package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
class MemberDeleteServiceTest {

    @Mock
    MemberRepository memberRepository;

    @Mock
    JwtService jwtService;

    @InjectMocks
    MemberDeleteService memberDeleteService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void deleteMember() {
//
//        Member member = memberDeleteService.deleteMember("");
//
//        assertThat(member.getName()).isEqualTo("김수현");
//    }
}