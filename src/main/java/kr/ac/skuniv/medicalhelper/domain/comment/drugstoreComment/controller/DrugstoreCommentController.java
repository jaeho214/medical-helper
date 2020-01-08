package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.controller;

import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.dto.DrugstoreCommentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.dto.DrugstoreCommentGetResponse;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.service.DrugstoreCommentCreateService;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.service.DrugstoreCommentDeleteService;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.service.DrugstoreCommentGetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/medicalHelper/comment/drugstore")
@AllArgsConstructor
public class DrugstoreCommentController {

    private DrugstoreCommentCreateService drugstoreCommentCreateService;
    private DrugstoreCommentDeleteService drugstoreCommentDeleteService;
    private DrugstoreCommentGetService drugstoreCommentGetService;


    @GetMapping(value = "/{drugstoreNo}")
    public List<DrugstoreCommentGetResponse> getDrugstoreComments(@PathVariable Long drugstoreNo){
        return drugstoreCommentGetService.getDrugstoreComments(drugstoreNo);
    }

    @PostMapping
    public ResponseEntity createDrugstoreComment(DrugstoreCommentCreateRequest drugstoreCommentCreateRequest, String userId){
        return drugstoreCommentCreateService.createDrugstoreComment(drugstoreCommentCreateRequest, userId);
    }

    @DeleteMapping(value = "/{dcNo}")
    public ResponseEntity deleteDrugstoreComment(@PathVariable Long dcNo, String userId){
        return drugstoreCommentDeleteService.deleteDrugstoreComment(dcNo, userId);
    }

}
