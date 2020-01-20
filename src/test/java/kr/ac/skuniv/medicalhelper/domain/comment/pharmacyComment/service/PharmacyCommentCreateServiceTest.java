package kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.service;

import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.dto.PharmacyCommentCreateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
class PharmacyCommentCreateServiceTest {

    @Autowired
    PharmacyCommentCreateService pharmacyCommentCreateService;

    PharmacyCommentCreateRequest pharmacyCommentCreateRequest;
    String userId = "jaeho214";

//    @BeforeEach
//    void setUp(){
//        pharmacyCommentCreateRequest = PharmacyCommentCreateRequest.builder()
//                .comment("쪼아영~~~ 개쥬아~~")
//                .score(4.5F)
//                .drugstoreNo(2243L)
//                .build();
//    }
//
//    @Test
//    void createDrugstoreComment() {
//        ResponseEntity result = pharmacyCommentCreateService.createDrugstoreComment(pharmacyCommentCreateRequest, userId);
//
//        assertThat(result).isNotNull();
//
//    }
}