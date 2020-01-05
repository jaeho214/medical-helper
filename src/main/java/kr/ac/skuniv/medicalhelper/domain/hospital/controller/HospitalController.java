package kr.ac.skuniv.medicalhelper.domain.hospital.controller;

import kr.ac.skuniv.medicalhelper.domain.hospital.dto.HospitalGetResponse;
import kr.ac.skuniv.medicalhelper.domain.hospital.service.HospitalGetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/medicalHelper/hospital")
public class HospitalController {

    private HospitalGetService hospitalGetService;

    public HospitalController(HospitalGetService hospitalGetService) {
        this.hospitalGetService = hospitalGetService;
    }

    @GetMapping("/{name}")
    public List<HospitalGetResponse> getHospitalByName(@PathVariable String name){
        return hospitalGetService.getHospitalByName(name);
    }

    @GetMapping("myLocation/{pageNum}/{xPos}/{yPos}")
    public List<HospitalGetResponse> getHospitalByGps(@PathVariable String xPos,
                                                      @PathVariable String yPos,
                                                      @PathVariable int pageNum){
        return hospitalGetService.getHospitalByGps(xPos, yPos, pageNum);
    }

    @GetMapping("myLocation/{pageNum}/{xPos}/{yPos}/{hospitalCode}")
    public List<HospitalGetResponse> getHospitalByHospitalCode(@PathVariable String xPos,
                                                 @PathVariable String yPos,
                                                 @PathVariable String hospitalCode,
                                                 @PathVariable int pageNum){
        return hospitalGetService.getHospitalByHospitalCode(xPos, yPos, hospitalCode, pageNum);
    }

    @GetMapping("/{pageNum}/{cityCode}")
    public List<HospitalGetResponse> getHospitalByCityCode(@PathVariable String cityCode,
                                                           @PathVariable int pageNum){
        return hospitalGetService.getHospitalByCityCode(cityCode, pageNum);
    }

    @GetMapping("/{pageNum}/{cityCode}/{hospitalCode}")
    public List<HospitalGetResponse> getHospitalByCityCodeAndHospitalCode(@PathVariable String cityCode,
                                                                          @PathVariable String hospitalCode,
                                                                          @PathVariable int pageNum){
        return hospitalGetService.getHospitalByCityCodeAndHospitalCode(cityCode, hospitalCode, pageNum);
    }


    @GetMapping("/detail/{hospital_no}")
    public HospitalGetResponse getHospitalDetail(@PathVariable Long hospital_no){
        return hospitalGetService.getHospitalDetail(hospital_no);
    }

}
