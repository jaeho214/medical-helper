package kr.ac.skuniv.medicalhelper.domain.pharmacy.service;

import kr.ac.skuniv.medicalhelper.domain.pharmacy.dto.PharmacyGetResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
class PharmacyGetServiceTest {

    @Autowired
    PharmacyGetService pharmacyGetService;

    @Test
    void getDrugstoreByName() {
        List<PharmacyGetResponse> drugstores = pharmacyGetService.getPharmacyByName("소망", "126.9716840", "37.5447673", 1);

        assertThat(drugstores.size()).isEqualTo(10);
        assertThat(drugstores.get(0).getName().contains("소망")).isTrue();
    }

    @Test
    void getDrugstoreByDistance() {
        List<PharmacyGetResponse> drugstores = pharmacyGetService.getPharmacyByDistance("126.814850", "37.391502", 1);

        assertThat(drugstores.size()).isEqualTo(10);
        System.out.println(drugstores.get(0).getName());
    }

    @Test
    void getDrugstore(){
        PharmacyGetResponse drugstore = pharmacyGetService.getPharmacy(391L);

        assertThat(drugstore).isNotNull();
        assertThat(drugstore.getName().contains("메디팜")).isTrue();
        assertThat(drugstore.getTel().startsWith("031")).isTrue();
    }
}