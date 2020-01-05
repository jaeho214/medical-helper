package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.controller;

import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.dto.DrugstoreCommentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.service.DrugstoreCommentCreateService;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.service.DrugstoreCommentDeleteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/medicalHelper/comment/drugstore")
@AllArgsConstructor
public class DrugstoreCommentController {

    private DrugstoreCommentCreateService drugstoreCommentCreateService;
    private DrugstoreCommentDeleteService drugstoreCommentDeleteService;


    @PostMapping
    public ResponseEntity createDrugstoreComment(DrugstoreCommentCreateRequest drugstoreCommentCreateRequest, String userId){
        return drugstoreCommentCreateService.createDrugstoreComment(drugstoreCommentCreateRequest, userId);
    }

    @DeleteMapping(value = "/{dcNo}")
    public ResponseEntity deleteDrugstoreComment(@PathVariable Long dcNo, String userId){
        return drugstoreCommentDeleteService.deleteDrugstoreComment(dcNo, userId);
    }

}
