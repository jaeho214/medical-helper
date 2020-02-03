package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberSignInRequest;
import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberSignInResponse;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
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
    MemberRepository memberRepository;

    @Autowired
    MemberSignInService memberSignInService;

    private Member member = Member.builder()
            .email("jaeho214@naver.com")
            .password("1")
            .phone("000-1111-2222")
            .name("현재호")
            .birth("1996-02-14")
            .address("주소")
            .sex("male")
            .build();

    private MemberSignInRequest memberSignInRequest =
            MemberSignInRequest.builder()
            .email("jaeho214@naver.com")
            .password("1")
            .build();

//    @Test
//    public void sigIn(){
//        //given
//        String email = "jaeho214@naver.com";
//        //given(memberRepository.findByEmail(email)).willReturn(Optional.of(member));
//
//        //when
//        MemberSignInResponse member = memberSignInService.signInMember(memberSignInRequest);
//
//        //then
//        assertThat(member.getToken()).isNotNull();
//        assertThat(member.getName()).isEqualTo(member.getName());
//        System.out.println(member.getToken());
//    }

}