package kr.ac.skuniv.medicalhelper.domain.emergency.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.ac.skuniv.medicalhelper.domain.emergency.dto.listInfo.EmergencyListInfoDto;
import kr.ac.skuniv.medicalhelper.domain.emergency.dto.realTime.EmergencyRealTimeDto;
import kr.ac.skuniv.medicalhelper.domain.emergency.dto.seriousDisease.EmergencySeriousDiseaseDto;
import kr.ac.skuniv.medicalhelper.domain.emergency.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/medicalHelper/emergency")
public class EmergencyController {

    private final EmergencyRealTimeService emergencyRealTimeService;
    private final EmergencySeriousDiseaseService emergencySeriousDiseaseService;
    private final EmergencyListService emergencyListService;
    private final EmergencyGetLocationService emergencyGetLocationService;
    private final EmergencyInformationService emergencyInformationService;
    private final EmergencyMessageService emergencyMessageService;

    public EmergencyController(EmergencyRealTimeService emergencyRealTimeService,
                               EmergencySeriousDiseaseService emergencySeriousDiseaseService,
                               EmergencyListService emergencyListService,
                               EmergencyGetLocationService emergencyGetLocationService,
                               EmergencyInformationService emergencyInformationService,
                               EmergencyMessageService emergencyMessageService) {
        this.emergencyRealTimeService = emergencyRealTimeService;
        this.emergencySeriousDiseaseService = emergencySeriousDiseaseService;
        this.emergencyListService = emergencyListService;
        this.emergencyGetLocationService = emergencyGetLocationService;
        this.emergencyInformationService = emergencyInformationService;
        this.emergencyMessageService = emergencyMessageService;
    }

    @GetMapping("/realtime/{stage1}/{stage2}/{pageNo}")
    @ApiOperation("응급실 실시간 가용 병상 정보 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stage1", value = "시/도", required = true, dataType = "String"),
            @ApiImplicitParam(name = "stage2", value = "시/군/구", required = true, dataType = "String")
    })
    public EmergencyRealTimeDto selectRealTime(@PathVariable String stage1,
                                               @PathVariable String stage2,
                                               @PathVariable int pageNo) {
        return emergencyRealTimeService.getRealTime(stage1, stage2, pageNo);
    }

    @GetMapping("/seriousIllness/{stage1}/{stage2}/{pageNo}")
    @ApiOperation("중증 질환자 수용 가능 정보 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stage1", value = "시/도", required = true, dataType = "String"),
            @ApiImplicitParam(name = "stage2", value = "시/군/구", required = true, dataType = "String")
    })
    public EmergencySeriousDiseaseDto selectSeriousDisease(@PathVariable String stage1,
                                                           @PathVariable String stage2,
                                                           @PathVariable int pageNo){
        return emergencySeriousDiseaseService.selectSeriousDisease(stage1, stage2, pageNo);
    }

    @GetMapping("/emergentList/{q0}/{q1}/{pageNo}")
    @ApiOperation("응급 의료기관 목록 정보 조회(장소, 진료 요일, 진료 과목 기반)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "q0", value = "시/도", required = true, dataType = "String"),
            @ApiImplicitParam(name = "q1", value = "시/군/구", required = true, dataType = "String"),
    })
    public EmergencyListInfoDto selectEmergencyListByLocation(@PathVariable String q0,
                                                              @PathVariable String q1,
                                                              @PathVariable int pageNo){
        return emergencyListService.selectEmergentListByLocation(q0,q1, pageNo);
    }

    @GetMapping("/emergentList/{qn}/{pageNo}")
    public EmergencyListInfoDto selectEmergencyListByName(@PathVariable String qn,
                                                          @PathVariable int pageNo){
        return emergencyListService.selectEmergentListByName(qn, pageNo);
    }



    @GetMapping("/location/{lon}/{lat}")
    public Map<String, Object> selectEmergencyLocation(@PathVariable String lon,
                                                       @PathVariable String lat){
        return emergencyGetLocationService.selectEmergencyLocation(lon, lat);
    }

    @GetMapping("/information/{hpid}")
    public Map<String, Object> selectEmergencyInformation(@PathVariable String hpid){
        return emergencyInformationService.selectEmergencyInformation(hpid);
    }

    @GetMapping("/message/{hpid}")
    public Map<String, Object> selectEmergencyMessageById(@PathVariable String hpid){
        return emergencyMessageService.selectEmergencyMessageById(hpid);
    }

    @GetMapping("/message/{q0}/{q1}")
    public Map<String, Object> selectEmergencyMessageByLocation(@PathVariable String q0,
                                                      @PathVariable String q1){
        return emergencyMessageService.selectEmergencyMessageByLocation(q0, q1);
    }

    @GetMapping("/message/{qn}")
    public Map<String, Object> selectEmergencyMessageByName(@PathVariable String qn){
        return emergencyMessageService.selectEmergencyMessageByName(qn);
    }


}
