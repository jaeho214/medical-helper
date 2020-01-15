package kr.ac.skuniv.medicalhelper.domain.hospital.controller;

import kr.ac.skuniv.medicalhelper.domain.hospital.dto.HospitalGetResponse;
import kr.ac.skuniv.medicalhelper.domain.hospital.service.HospitalGetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/medicalHelper/hospital")
public class HospitalController {

    private HospitalGetService hospitalGetService;

    public HospitalController(HospitalGetService hospitalGetService) {
        this.hospitalGetService = hospitalGetService;
    }

    @GetMapping("/gps/{xPos}/{yPos}/{name}")
    public List<HospitalGetResponse> getHospitalByName(@PathVariable String xPos,
                                                       @PathVariable String yPos,
                                                       @PathVariable String name,
                                                       @RequestParam("pageNo") int pageNo){
        return hospitalGetService.getHospitalByName(xPos,yPos,name,pageNo);
    }

    @GetMapping("/gps/{xPos}/{yPos}")
    public List<HospitalGetResponse> getHospitalByGps(@PathVariable String xPos,
                                                      @PathVariable String yPos,
                                                      @RequestParam("pageNo") int pageNo){
        return hospitalGetService.getHospitalAround(xPos, yPos, pageNo);
    }

    @GetMapping("/gps/{xPos}/{yPos}/{hospitalCode}")
    public List<HospitalGetResponse> getHospitalByHospitalCode(@PathVariable String xPos,
                                                               @PathVariable String yPos,
                                                               @PathVariable String hospitalCode,
                                                               @RequestParam("pageNo") int pageNo){
        return hospitalGetService.getHospitalByHospitalCode(xPos, yPos, hospitalCode, pageNo);
    }

    @GetMapping("/keyword/{cityCode}")
    public List<HospitalGetResponse> getHospitalByCityCode(@PathVariable String cityCode,
                                                           @RequestParam("pageNo") int pageNo){
        return hospitalGetService.getHospitalByCityCode(cityCode, pageNo);
    }

    @GetMapping("/keyword/{cityCode}/{hospitalCode}")
    public List<HospitalGetResponse> getHospitalByCityCodeAndHospitalCode(@PathVariable String cityCode,
                                                                          @PathVariable String hospitalCode,
                                                                          @RequestParam("pageNo") int pageNo){
        return hospitalGetService.getHospitalByCityCodeAndHospitalCode(cityCode, hospitalCode, pageNo);
    }


    @GetMapping("/detail/{id}")
    public HospitalGetResponse getHospitalDetail(@PathVariable Long id){
        return hospitalGetService.getHospitalDetail(id);
    }

}
