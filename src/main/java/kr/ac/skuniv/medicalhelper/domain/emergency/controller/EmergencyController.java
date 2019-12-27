package kr.ac.skuniv.medicalhelper.domain.emergency.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.ac.skuniv.medicalhelper.domain.emergency.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/medicalHelper/emergency")
public class EmergencyController {

    private final EmergencyRealTimeService emergencyRealTimeService;
    private final EmergencySeriousIllnessService emergencySeriousIllnessService;
    private final EmergencyGetListService emergencyGetListService;
    private final EmergencyGetLocationService emergencyGetLocationService;
    private final EmergencyInformationService emergencyInformationService;
    private final EmergencyMessageService emergencyMessageService;

    public EmergencyController(EmergencyRealTimeService emergencyRealTimeService,
                               EmergencySeriousIllnessService emergencySeriousIllnessService,
                               EmergencyGetListService emergencyGetListService,
                               EmergencyGetLocationService emergencyGetLocationService,
                               EmergencyInformationService emergencyInformationService,
                               EmergencyMessageService emergencyMessageService) {
        this.emergencyRealTimeService = emergencyRealTimeService;
        this.emergencySeriousIllnessService = emergencySeriousIllnessService;
        this.emergencyGetListService = emergencyGetListService;
        this.emergencyGetLocationService = emergencyGetLocationService;
        this.emergencyInformationService = emergencyInformationService;
        this.emergencyMessageService = emergencyMessageService;
    }

    @GetMapping("/realtime/{stage1}/{stage2}")
    @ApiOperation("/응급실 실시간 가용 병상 정보 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stage1", value = "시/도", required = true, dataType = "String"),
            @ApiImplicitParam(name = "stage2", value = "시/군/구", required = true, dataType = "String")
    })
    public Map<String, Object> selectRealTime(@PathVariable String stage1, @PathVariable String stage2) {
        return emergencyRealTimeService.selectRealTime(stage1, stage2);
    }

    @GetMapping("/seriousIllness/{stage1}/{stage2}")
    @ApiOperation("중증 질환자 수용 가능 정보 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stage1", value = "시/도", required = true, dataType = "String"),
            @ApiImplicitParam(name = "stage2", value = "시/군/구", required = true, dataType = "String")
    })
    public Map<String, Object> selectSeriousIllness(@PathVariable String stage1, @PathVariable String stage2){
        return emergencySeriousIllnessService.selectSeriousIllness(stage1, stage2);
    }

    @GetMapping("/emergencyList/{q0}/{q1}/{qt}/{qd}")
    @ApiOperation("응급 의료기관 목록 정보 조회(장소, 진료 요일, 진료 과목 기반)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "q0", value = "시/도", required = true, dataType = "String"),
            @ApiImplicitParam(name = "q1", value = "시/군/구", required = true, dataType = "String"),
    })
    public Map<String, Object> selectEmergencyList(@PathVariable String q0,
                                                   @PathVariable String q1){
        return emergencyGetListService.selectEmergencyList(q0,q1);
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
