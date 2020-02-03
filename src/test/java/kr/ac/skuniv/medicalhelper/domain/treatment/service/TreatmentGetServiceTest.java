package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentGetResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class TreatmentGetServiceTest {

    @Autowired
    TreatmentGetService treatmentGetService;

    private String token = "eyJ0eXAiOiJKV1QiLCJpc3N1ZURhdGUiOjE1NzkwMjAwNTYzMjQsImFsZyI6IkhTMjU2In0.eyJFTUFJTCI6ImphZWhvMjE0QG5hdmVyLmNvbSIsImV4cCI6MTU3OTM4MDA1Nn0.M2VzUoO_jrKhBGQPIpwHRiyEmVGjeIsRrAVxu7ECTHU";

//    @Test
//    void getAllTreatments() {
//
//
//        //when
//        List<TreatmentGetResponse> treatments = treatmentGetService.getAllTreatments(token);
//
//        //then
//        assertThat(treatments.get(0).getTitle()).isEqualTo("감기");
//        assertThat(treatments.get(0).getDoctorName()).isEqualTo("이국종");
//        assertThat(treatments.size()).isEqualTo(1);
//    }
//
//    @Test
//    void getTreatment(){
//        TreatmentGetResponse treatment = treatmentGetService.getTreatment(4L, token);
//
//        assertThat(treatment.getDoctorName()).isEqualTo("이국종");
//    }
}