package kr.ac.skuniv.medicalhelper.domain.treatment.controller;

import kr.ac.skuniv.medicalhelper.domain.treatment.service.TreatmentGetService;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentGetResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "medicalHelper/treatment")
@AllArgsConstructor
public class TreatmentController {

    private TreatmentGetService treatmentGetService;


    //내 처방 기록 보기
    //TODO : Security 처리 필요
    @GetMapping(value = "/myTreatmentList")
    public List<TreatmentGetResponse> getTreatmentByMember(String userId){
        return treatmentGetService.getTreatmentByMember(userId);
    }

}
