package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TreatmentDeleteServiceTest {

    @Autowired
    TreatmentDeleteService treatmentDeleteService;

    private String token = "eyJ0eXAiOiJKV1QiLCJpc3N1ZURhdGUiOjE1NzkwMjAwNTYzMjQsImFsZyI6IkhTMjU2In0.eyJFTUFJTCI6ImphZWhvMjE0QG5hdmVyLmNvbSIsImV4cCI6MTU3OTM4MDA1Nn0.M2VzUoO_jrKhBGQPIpwHRiyEmVGjeIsRrAVxu7ECTHU";


//    @Test
//    void deleteTreatment() {
//
//        treatmentDeleteService.deleteTreatment(4L, token);
//    }

//    @Test
//    void deleteTreatment_securityException() {
//        String userId = "aaa";
//
//        treatmentDeleteService.deleteTreatment(1L, token);
//    }
}