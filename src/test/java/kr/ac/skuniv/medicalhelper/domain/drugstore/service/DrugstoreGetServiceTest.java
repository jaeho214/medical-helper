package kr.ac.skuniv.medicalhelper.domain.drugstore.service;

import kr.ac.skuniv.medicalhelper.domain.drugstore.dto.DrugstoreGetResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
class DrugstoreGetServiceTest {

    @Autowired
    DrugstoreGetService drugstoreGetService;

    @Test
    void getDrugstoreByName() {
        List<DrugstoreGetResponse> drugstores = drugstoreGetService.getDrugstoreByName("소망", "126.9716840", "37.5447673", 1);

        assertThat(drugstores.size()).isEqualTo(10);
        assertThat(drugstores.get(0).getName().contains("소망")).isTrue();
    }

    @Test
    void getDrugstoreByDistance() {
        List<DrugstoreGetResponse> drugstores = drugstoreGetService.getDrugstoreByDistance("126.814850", "37.391502", 1);

        assertThat(drugstores.size()).isEqualTo(10);
        System.out.println(drugstores.get(0).getName());
    }

    @Test
    void getDrugstore(){
        DrugstoreGetResponse drugstore = drugstoreGetService.getDrugstore(2243L);

        assertThat(drugstore).isNotNull();
        assertThat(drugstore.getName().contains("관곡지")).isTrue();
        assertThat(drugstore.getTel().startsWith("031")).isTrue();
        System.out.println(drugstore.getDrugstoreComment().get(0).getMember().getName());
    }
}