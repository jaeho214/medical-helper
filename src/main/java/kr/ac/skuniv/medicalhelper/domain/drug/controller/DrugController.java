package kr.ac.skuniv.medicalhelper.domain.drug.controller;

import kr.ac.skuniv.medicalhelper.domain.drug.dto.DrugUpdateRequest;
import kr.ac.skuniv.medicalhelper.domain.drug.service.DrugDeleteService;
import kr.ac.skuniv.medicalhelper.domain.drug.service.DrugUpdateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicalHelper/drug")
public class DrugController {

    private DrugUpdateService drugUpdateService;
    private DrugDeleteService drugDeleteService;

    public DrugController(DrugUpdateService drugUpdateService, DrugDeleteService drugDeleteService) {
        this.drugUpdateService = drugUpdateService;
        this.drugDeleteService = drugDeleteService;
    }

    @PutMapping
    public void updateDrug(@RequestBody DrugUpdateRequest drugUpdateRequest,
                           @RequestHeader("token") String token){
        drugUpdateService.updateDrug(drugUpdateRequest, token);
    }

    @DeleteMapping("/{id}")
    public void deleteDrug(@PathVariable Long id,
                           @RequestHeader("token") String token){
        drugDeleteService.deleteDrug(id, token);
    }
}
