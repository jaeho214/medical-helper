package kr.ac.skuniv.medicalhelper.domain.treatment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentGetResponse;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentUpdateRequest;
import kr.ac.skuniv.medicalhelper.domain.treatment.service.TreatmentCreateService;
import kr.ac.skuniv.medicalhelper.domain.treatment.service.TreatmentDeleteService;
import kr.ac.skuniv.medicalhelper.domain.treatment.service.TreatmentGetService;
import kr.ac.skuniv.medicalhelper.domain.treatment.service.TreatmentUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "medicalHelper/treatment")
@AllArgsConstructor
public class TreatmentController {

    private TreatmentGetService treatmentGetService;
    private TreatmentCreateService treatmentCreateService;
    private TreatmentUpdateService treatmentUpdateService;
    private TreatmentDeleteService treatmentDeleteService;
    private ObjectMapper objectMapper;

    //내 처방 기록 보기
    //TODO : Security 처리 필요
    @GetMapping
    public List<TreatmentGetResponse> getAllTreatments(String userId){
        return treatmentGetService.getAllTreatments(userId);
    }

    @GetMapping(value = "/{tno}")
    public TreatmentGetResponse getTreatment(@PathVariable Long tno, String userId){
        return treatmentGetService.getTreatment(tno, userId);
    }

    //처방 기록 작성하기
    //TODO : Security 처리 필요
    @PostMapping
    public void createTreatmentAndImage(@RequestPart(required = false)MultipartFile imageFile,
                                        @RequestParam String json,
                                        String userId) throws Exception {
        TreatmentCreateRequest treatmentCreateRequest = objectMapper.readValue(json, TreatmentCreateRequest.class);
        treatmentCreateService.createTreatment(treatmentCreateRequest, imageFile, userId);
    }

    //처방 기록 수정하기
    //TODO : Security 처리 필요
    @PutMapping
    public void updateTreatmentAndImage(@RequestPart(required = false)MultipartFile imageFile,
                                        @RequestParam String json,
                                        String userId) throws Exception {
        TreatmentUpdateRequest treatmentUpdateRequest = objectMapper.readValue(json, TreatmentUpdateRequest.class);
        treatmentUpdateService.updateTreatment(imageFile, treatmentUpdateRequest, userId);
    }

    //처방 기록 삭제하기
    //TODO : Security 처리 필요
    @DeleteMapping(value = "/{tno}")
    public void deleteTreatment(@PathVariable Long tno, String userId){
        treatmentDeleteService.deleteTreatment(tno, userId);
    }

    @GetMapping(value = "/image/{tno}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable Long tno){
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                .body(treatmentGetService.getImageResource(tno));
    }

}
