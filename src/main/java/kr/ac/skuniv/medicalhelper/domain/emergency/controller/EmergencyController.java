package kr.ac.skuniv.medicalhelper.domain.emergency.controller;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.EmergencyDto;
import kr.ac.skuniv.medicalhelper.domain.emergency.service.EmergencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
public class EmergencyController {

    private EmergencyService emergencyService;

    public EmergencyController(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }

    @GetMapping("/realtime/{stage1}/{stage2}")
    public List<EmergencyDto> usefulRealTime(@PathVariable String stage1, @PathVariable String stage2) throws UnsupportedEncodingException {
        return emergencyService.usefulRealTime(stage1, stage2);
    }

    @GetMapping("/location/{lon}/{lat}")
    //lon = 경도, lat = 위도
    public List<EmergencyDto> searchLocation(@PathVariable String lon, @PathVariable String lat) throws UnsupportedEncodingException {
        return emergencyService.searchLocation(lon, lat);
    }

}
