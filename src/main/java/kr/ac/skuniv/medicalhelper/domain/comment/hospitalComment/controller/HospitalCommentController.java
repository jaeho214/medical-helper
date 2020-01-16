package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.controller;

import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.dto.HospitalCommentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.dto.HospitalCommentGetResponse;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.entity.HospitalComment;
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

    @GetMapping(value = "/{hospitalId}")
    public List<HospitalCommentGetResponse> getHospitalComments(@PathVariable Long hospitalId){
        return hospitalCommentGetService.getHospitalComments(hospitalId);
    }

    @PostMapping
    public HospitalComment createHospitalComment(HospitalCommentCreateRequest hospitalCommentCreateRequest,
                                                 @RequestHeader("token") String token){
        return hospitalCommentCreateService.createHospitalComment(hospitalCommentCreateRequest,token);
    }

    @DeleteMapping(value = "/{id}")
    public HospitalComment deleteHospitalComment(@PathVariable Long id,
                                                @RequestHeader("token") String token){
        return hospitalCommentDeleteService.deleteHospitalComment(id, token);
    }
}
