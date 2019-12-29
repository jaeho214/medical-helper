package kr.ac.skuniv.medicalhelper.domain.treatment.controller;

import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentPostRequest;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentUpdateRequest;
import kr.ac.skuniv.medicalhelper.domain.treatment.service.TreatmentGetService;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentGetResponse;
import kr.ac.skuniv.medicalhelper.domain.treatment.service.TreatmentPostService;
import kr.ac.skuniv.medicalhelper.domain.treatment.service.TreatmentUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "medicalHelper/treatment")
@AllArgsConstructor
public class TreatmentController {

    private TreatmentGetService treatmentGetService;
    private TreatmentPostService treatmentPostService;
    private TreatmentUpdateService treatmentUpdateService;

    //내 처방 기록 보기
    //TODO : Security 처리 필요
    @GetMapping
    public List<TreatmentGetResponse> getTreatmentByMember(String userId){
        return treatmentGetService.getTreatmentByMember(userId);
    }

    //처방 기록 작성하기
    //TODO : Security 처리 필요
    @PostMapping
    public void postTreatment(TreatmentPostRequest treatmentPostRequest, String userId){
        treatmentPostService.postTreatment(treatmentPostRequest, userId);
    }

    @PutMapping
    public void updateTreatment(TreatmentUpdateRequest treatmentUpdateRequest, String userId){
        treatmentUpdateService.updateTreatment(treatmentUpdateRequest, userId);
    }

}
