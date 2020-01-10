package kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.controller;

import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.dto.PharmacyCommentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.dto.PharmacyCommentGetResponse;
import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.service.PharmacyCommentCreateService;
import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.service.PharmacyCommentDeleteService;
import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.service.PharmacyCommentGetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/medicalHelper/comment/pharmacy")
@AllArgsConstructor
public class PharmacyCommentController {

    private PharmacyCommentCreateService pharmacyCommentCreateService;
    private PharmacyCommentDeleteService pharmacyCommentDeleteService;
    private PharmacyCommentGetService pharmacyCommentGetService;


    @GetMapping(value = "/{pharmacyId}")
    public List<PharmacyCommentGetResponse> getPharmacyComments(@PathVariable Long pharmacyId){
        return pharmacyCommentGetService.getPharmacyComments(pharmacyId);
    }

    @PostMapping
    public ResponseEntity createPharmacyComment(@RequestBody PharmacyCommentCreateRequest pharmacyCommentCreateRequest,
                                                @RequestHeader("token") String token){
        return pharmacyCommentCreateService.createPharmacyComment(pharmacyCommentCreateRequest, token);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePharmacyComment(@PathVariable Long id,
                                                @RequestHeader("token") String token){
        return pharmacyCommentDeleteService.deletePharmacyComment(id, token);
    }

}
