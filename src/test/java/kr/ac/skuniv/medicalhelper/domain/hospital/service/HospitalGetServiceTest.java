package kr.ac.skuniv.medicalhelper.domain.hospital.service;

import kr.ac.skuniv.medicalhelper.domain.hospital.dto.HospitalGetResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class HospitalGetServiceTest {

    @Autowired
    HospitalGetService hospitalGetService;

//    @Test
//    void getHospitalByName() {
//        List<HospitalGetResponse> hospitalList = hospitalGetService.getHospitalByName("126.811484", "37.368523","신천연합",1);
//        System.out.println(hospitalList.get(0).getName());
//        System.out.println(hospitalList.get(0).getAddress());
//    }
//
//    @Test
//    void getHospitalDetail() {
//        HospitalGetResponse hospitalDetail = hospitalGetService.getHospitalDetail(113L);
//        assertThat(hospitalDetail).isNotNull();
//        assertThat(hospitalDetail.getName().contains("대림")).isTrue();
//    }
//
    @Test
    void getHospitalByGps() {
        List<HospitalGetResponse> hospitalList = hospitalGetService.getHospitalAround("127.0078127", "37.5001823", 1);

        assertThat(hospitalList.size()).isEqualTo(10);
        assertThat(hospitalList).isNotNull();
        System.out.println(hospitalList.get(0).getName());
        System.out.println(hospitalList.get(0).getAddress());

    }
//
//    @Test
//    void getHospitalByHospitalCode() {
//        List<HospitalGetResponse> hospitalList = hospitalGetService.getHospitalByHospitalCode("126.811484", "37.368523", "안과", 1);
//        assertThat(hospitalList.size()).isEqualTo(10);
//        assertThat(hospitalList).isNotNull();
//        System.out.println(hospitalList.get(0).getName());
//    }
//
//    @Test
//    void getHospitalByCityCode() {
//        List<HospitalGetResponse> hospitalList = hospitalGetService.getHospitalByCityCode("경기", 1);
//
//        assertThat(hospitalList.size()).isEqualTo(10);
//    }
//
//
//    @Test
//    void getHospitalByCityCodeAndHospitalCode() {
//        List<HospitalGetResponse> hospitalList = hospitalGetService.getHospitalByCityCodeAndHospitalCode("경기", "안과", 1);
//
//        assertThat(hospitalList.size()).isEqualTo(10);
//    }
}