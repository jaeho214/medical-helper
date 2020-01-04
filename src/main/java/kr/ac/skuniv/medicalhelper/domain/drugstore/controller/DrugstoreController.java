package kr.ac.skuniv.medicalhelper.domain.drugstore.controller;

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

    @GetMapping(value = "/{name}")
    public List<Drugstore> getDrugstoreByName(@PathVariable String name){
        return drugstoreGetService.getDrugstoreByName(name);
    }


}
