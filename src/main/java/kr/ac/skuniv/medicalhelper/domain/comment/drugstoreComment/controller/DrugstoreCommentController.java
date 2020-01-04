package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.controller;

import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.dto.DrugstoreCommentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.service.DrugstoreCommentCreateService;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.service.DrugstoreCommentDeleteService;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.service.DrugstoreCommentGetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/medicalHelper/comment/drugstore")
@AllArgsConstructor
public class DrugstoreCommentController {

    private DrugstoreCommentCreateService drugstoreCommentCreateService;
    private DrugstoreCommentGetService drugstoreCommentGetService;
    private DrugstoreCommentDeleteService drugstoreCommentDeleteService;

    //TODO: 약국을 읽어올 때 별점을 읽어오면 되는데 이게 굳이 필요한가? 에 대해 고민해보기
//    @GetMapping(value = "/{hospitalNo}")
//    public DrugstoreCommentGetResponse getDrugstoreComment(@PathVariable Long drugstoreNo){
//        return drugstoreCommentGetService.getDrugstoreComment(drugstoreNo);
//    }

    @PostMapping
    public ResponseEntity createDrugstoreComment(DrugstoreCommentCreateRequest drugstoreCommentCreateRequest, String userId){
        return drugstoreCommentCreateService.createDrugstoreComment(drugstoreCommentCreateRequest, userId);
    }

    @DeleteMapping(value = "/{dcNo}")
    public ResponseEntity deleteDrugstoreComment(@PathVariable Long dcNo, String userId){
        return drugstoreCommentDeleteService.deleteDrugstoreComment(dcNo, userId);
    }

}
