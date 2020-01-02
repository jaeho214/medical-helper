package kr.ac.skuniv.medicalhelper.domain.treatment.controller;

import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentUpdateRequest;
import kr.ac.skuniv.medicalhelper.domain.treatment.service.TreatmentDeleteService;
import kr.ac.skuniv.medicalhelper.domain.treatment.service.TreatmentGetService;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentGetResponse;
import kr.ac.skuniv.medicalhelper.domain.treatment.service.TreatmentCreateService;
import kr.ac.skuniv.medicalhelper.domain.treatment.service.TreatmentUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "medicalHelper/treatment")
@AllArgsConstructor
public class TreatmentController {

    private TreatmentGetService treatmentGetService;
    private TreatmentCreateService treatmentCreateService;
    private TreatmentUpdateService treatmentUpdateService;
    private TreatmentDeleteService treatmentDeleteService;

    //내 처방 기록 보기
    //TODO : Security 처리 필요
    @GetMapping
    public List<TreatmentGetResponse> getTreatmentByMember(String userId){
        return treatmentGetService.getTreatmentByMember(userId);
    }

    //처방 기록 작성하기
    //TODO : Security 처리 필요
    @PostMapping
    public void createTreatment(TreatmentCreateRequest treatmentCreateRequest, String userId){
        treatmentCreateService.createTreatment(treatmentCreateRequest, userId);
    }

    //처방 기록 수정하기
    //TODO : Security 처리 필요
    @PutMapping
    public void updateTreatment(TreatmentUpdateRequest treatmentUpdateRequest, String userId){
        treatmentUpdateService.updateTreatment(treatmentUpdateRequest, userId);
    }

    //처방 기록 삭제하기
    //TODO : Security 처리 필요
    @DeleteMapping(value = "/{tno}")
    public void deleteTreatment(@PathVariable Long tno, String userId){
        treatmentDeleteService.deleteTreatment(tno, userId);
    }

}
