package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.controller;

import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.dto.HospitalCommentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.dto.HospitalCommentGetResponse;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.service.HospitalCommentCreateService;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.service.HospitalCommentDeleteService;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.service.HospitalCommentGetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/medicalHelper/")
public class HospitalCommentController {

    private HospitalCommentCreateService hospitalCommentCreateService;
    private HospitalCommentGetService hospitalCommentGetService;
    private HospitalCommentDeleteService hospitalCommentDeleteService;

    public HospitalCommentController(HospitalCommentCreateService hospitalCommentCreateService,
                                     HospitalCommentGetService hospitalCommentGetService,
                                     HospitalCommentDeleteService hospitalCommentDeleteService) {
        this.hospitalCommentCreateService = hospitalCommentCreateService;
        this.hospitalCommentGetService = hospitalCommentGetService;
        this.hospitalCommentDeleteService = hospitalCommentDeleteService;
    }

    @GetMapping(value = "/{hospitalNo}")
    public List<HospitalCommentGetResponse> getHospitalComments(@PathVariable Long hospitalNo){
        return hospitalCommentGetService.getHospitalComments(hospitalNo);
    }

    @PostMapping
    public ResponseEntity createHospitalComment(HospitalCommentCreateRequest hospitalCommentCreateRequest, String userId){
        return ResponseEntity.ok(hospitalCommentCreateService.createHospitalComment(hospitalCommentCreateRequest,userId));
    }

    @DeleteMapping(value = "/{hcNo}")
    public ResponseEntity deleteHospitalComment(@PathVariable Long hcNo, String userId){
        return ResponseEntity.ok(hospitalCommentDeleteService.deleteHospitalComment(hcNo, userId));
    }
}
