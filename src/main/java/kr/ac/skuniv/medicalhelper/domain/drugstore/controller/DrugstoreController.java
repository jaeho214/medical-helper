package kr.ac.skuniv.medicalhelper.domain.drugstore.controller;

import kr.ac.skuniv.medicalhelper.domain.drugstore.dto.DrugstoreGetResponse;
import kr.ac.skuniv.medicalhelper.domain.drugstore.entity.Drugstore;
import kr.ac.skuniv.medicalhelper.domain.drugstore.service.DrugstoreGetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/medicalHelper/drugstore")
@AllArgsConstructor
public class DrugstoreController {

    private DrugstoreGetService drugstoreGetService;

    @GetMapping(value = "/{name}/{xPos}/{yPos}/{pageNo}")
    public List<DrugstoreGetResponse> getDrugstoreByName(@PathVariable String name,
                                              @PathVariable String xPos,
                                              @PathVariable String yPos,
                                              @PathVariable int pageNo){
        return drugstoreGetService.getDrugstoreByName(name, xPos, yPos, pageNo);
    }

    @GetMapping(value = "/{xPos}/{yPos}/{pageNo}")
    public List<DrugstoreGetResponse> getDrugstoreByDistance(@PathVariable String xPos,
                                                  @PathVariable String yPos,
                                                  @PathVariable int pageNo){
        return drugstoreGetService.getDrugstoreByDistance(xPos, yPos, pageNo);
    }

    @GetMapping(value = "/{drugstoreNo}")
    public DrugstoreGetResponse getDrugstore(@PathVariable Long drugstoreNo){
        return drugstoreGetService.getDrugstore(drugstoreNo);
    }
}
