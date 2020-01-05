package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.service;

import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.dto.DrugstoreCommentCreateRequest;
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
class DrugstoreCommentCreateServiceTest {

    @Autowired
    DrugstoreCommentCreateService drugstoreCommentCreateService;

    DrugstoreCommentCreateRequest drugstoreCommentCreateRequest;
    String userId = "jaeho214";

    @BeforeEach
    void setUp(){
        drugstoreCommentCreateRequest = DrugstoreCommentCreateRequest.builder()
                .comment("쪼아영~~~ 개쥬아~~")
                .score(4.5F)
                .drugstoreNo(2243L)
                .build();
    }

    @Test
    void createDrugstoreComment() {
        ResponseEntity result = drugstoreCommentCreateService.createDrugstoreComment(drugstoreCommentCreateRequest, userId);

        assertThat(result).isNotNull();

    }
}