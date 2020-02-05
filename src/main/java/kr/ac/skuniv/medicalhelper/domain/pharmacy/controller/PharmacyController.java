package kr.ac.skuniv.medicalhelper.domain.pharmacy.controller;

import kr.ac.skuniv.medicalhelper.domain.pharmacy.dto.PharmacyGetResponse;
import kr.ac.skuniv.medicalhelper.domain.pharmacy.service.PharmacyGetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/medicalHelper/pharmacy")
@AllArgsConstructor
public class PharmacyController {

    private PharmacyGetService pharmacyGetService;

    @GetMapping(value = "/gps/{name}/{xPos}/{yPos:.+}")
    public List<PharmacyGetResponse> getPharmacyByName(@PathVariable String name,
                                                        @PathVariable String xPos,
                                                        @PathVariable String yPos,
                                                       @RequestParam("pageNo") int pageNo){
        return pharmacyGetService.getPharmacyByName(name, xPos, yPos, pageNo);
    }

    @GetMapping(value = "/gps/{xPos}/{yPos:.+}")
    public List<PharmacyGetResponse> getPharmacyByDistance(@PathVariable String xPos,
                                                            @PathVariable String yPos,
                                                           @RequestParam("pageNo") int pageNo){
        return pharmacyGetService.getPharmacyByDistance(xPos, yPos, pageNo);
    }

    @GetMapping(value = "/{id}")
    public PharmacyGetResponse getPharmacy(@PathVariable Long id){
        return pharmacyGetService.getPharmacy(id);
    }
}
