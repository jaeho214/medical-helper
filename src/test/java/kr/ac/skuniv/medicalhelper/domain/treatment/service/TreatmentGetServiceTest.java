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

    @Test
    void getTreatmentByMember() {
        //given
        String userId = "jaeho214";

        //when
        List<TreatmentGetResponse> treatments = treatmentGetService.getTreatmentByMember(userId);

        //then
        assertThat(treatments.get(0).getTitle()).isEqualTo("감기");
        assertThat(treatments.get(0).getDoctorName()).isEqualTo("이국종");
    }
}