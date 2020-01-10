package kr.ac.skuniv.medicalhelper.domain.member.service;

import kr.ac.skuniv.medicalhelper.domain.member.dto.MemberCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MemberCreateServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberCreateService memberCreateService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    private Member member = Member.builder()
            .email("jaeho214@naver.com")
            .password("1q2w3e")
            .phone("000-1111-2222")
            .name("현재호")
            .birth("1996-02-14")
            .address("경기도 시흥시")
            .sex("male")
            .build();

    private MemberCreateRequest memberCreateRequest =
            MemberCreateRequest.builder()
                    .email("jaeho214@naver.com")
                    .password("1q2w3e")
                    .phone("000-1111-2222")
                    .name("현재호")
                    .birth("1996-02-14")
                    .address("경기도 시흥시")
                    .sex("male")
                    .build();

    @Test
    public void create(){
        //given
        given(memberRepository.save(member)).willReturn(member);

        //when
        Member member = memberCreateService.createMember(memberCreateRequest);

        //then
        assertThat(member.getEmail()).isEqualTo(memberCreateRequest.getEmail());
        assertThat(member.getName()).isEqualTo(memberCreateRequest.getName());
    }



}