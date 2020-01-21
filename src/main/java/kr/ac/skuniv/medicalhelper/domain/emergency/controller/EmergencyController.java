package kr.ac.skuniv.medicalhelper.domain.emergency.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.ac.skuniv.medicalhelper.domain.emergency.dto.emergencyCenter.info.EmergencyCenterInfoDto;
import kr.ac.skuniv.medicalhelper.domain.emergency.dto.emergencyCenter.list.EmergencyCenterListInfoDto;
import kr.ac.skuniv.medicalhelper.domain.emergency.dto.emergencyCenter.location.EmergencyCenterLocationDto;
import kr.ac.skuniv.medicalhelper.domain.emergency.dto.realTime.EmergencyRealTimeDto;
import kr.ac.skuniv.medicalhelper.domain.emergency.dto.seriousDisease.possible.EmergencySeriousDiseaseDto;
import kr.ac.skuniv.medicalhelper.domain.emergency.dto.seriousDisease.message.EmergencySeriousDiseaseMsgDto;
import kr.ac.skuniv.medicalhelper.domain.emergency.dto.traumaCenter.list.EmergencyTraumaCenterDto;
import kr.ac.skuniv.medicalhelper.domain.emergency.dto.traumaCenter.info.EmergencyTraumaCenterInfoDto;
import kr.ac.skuniv.medicalhelper.domain.emergency.dto.traumaCenter.location.EmergencyTraumaCenterLocationDto;
import kr.ac.skuniv.medicalhelper.domain.emergency.service.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/medicalHelper/emergency")
@AllArgsConstructor
public class EmergencyController {

    private final EmergencyRealTimeGetService emergencyRealTimeGetService;
    private final EmergencySeriousDiseaseGetService emergencySeriousDiseaseGetService;
    private final EmergencyCenterListGetService emergencyCenterListGetService;
    private final EmergencyCenterLocationGetService emergencyCenterLocationGetService;
    private final EmergencyCenterInfoGetService emergencyCenterInfoGetService;
    private final EmergencySeriousDiseaseMsgGetService emergencySeriousDiseaseMsgGetService;
    private final EmergencyTraumaCenterListGetService emergencyTraumaCenterListGetService;
    private final EmergencyTraumaCenterLocationGetService emergencyTraumaCenterLocationGetService;
    private final EmergencyTraumaCenterInfoGetService emergencyTraumaCenterInfoGetService;

    @GetMapping("/realtime/{stage1}/{stage2}/{pageNo}")
    @ApiOperation("응급실 실시간 가용 병상 정보 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stage1", value = "시/도", required = true, dataType = "string"),
            @ApiImplicitParam(name = "stage2", value = "시/군/구", required = true, dataType = "string"),
            @ApiImplicitParam(name = "pageNo", value = "페이지 번호", required = true, dataType = "int")
    })
    public EmergencyRealTimeDto getRealTime(@PathVariable String stage1,
                                               @PathVariable String stage2,
                                               @PathVariable int pageNo) {
        return emergencyRealTimeGetService.getRealTime(stage1, stage2, pageNo);
    }

    @GetMapping("/seriousIllness/{stage1}/{stage2}/{pageNo}")
    @ApiOperation("중증 질환자 수용 가능 정보 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stage1", value = "시/도", required = true, dataType = "string"),
            @ApiImplicitParam(name = "stage2", value = "시/군/구", required = true, dataType = "string"),
            @ApiImplicitParam(name = "pageNo", value = "페이지 번호", required = true, dataType = "int")
    })
    public EmergencySeriousDiseaseDto getSeriousDisease(@PathVariable String stage1,
                                                           @PathVariable String stage2,
                                                           @PathVariable int pageNo){
        return emergencySeriousDiseaseGetService.getSeriousDisease(stage1, stage2, pageNo);
    }

    @GetMapping("/emergentList/{q0}/{q1}/{pageNo}")
    @ApiOperation("응급 의료기관 목록 정보 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "q0", value = "시/도", required = true, dataType = "string"),
            @ApiImplicitParam(name = "q1", value = "시/군/구", required = true, dataType = "string"),
            @ApiImplicitParam(name = "pageNo", value = "페이지 번호", required = true, dataType = "int")
    })
    public EmergencyCenterListInfoDto getEmergencyListByLocation(@PathVariable String q0,
                                                                 @PathVariable String q1,
                                                                 @PathVariable int pageNo){
        return emergencyCenterListGetService.getEmergentListByLocation(q0,q1, pageNo);
    }

    @GetMapping("/emergentList/{qn}/{pageNo}")
    @ApiOperation("응급 의료기관 목록 정보 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "qn", value = "기관명", required = true, dataType = "string"),
            @ApiImplicitParam(name = "pageNo", value = "페이지 번호", required = true, dataType = "int")
    })
    public EmergencyCenterListInfoDto getEmergencyListByName(@PathVariable String qn,
                                                             @PathVariable int pageNo){
        return emergencyCenterListGetService.getEmergentListByName(qn, pageNo);
    }


    // TODO: 2020-01-22 위도/경도가 안먹히는 듯
    @GetMapping("/location/{lon}/{lat}/{pageNo}")
    @ApiOperation("응급의료기관 위치 정보 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lon", value = "경도", required = true, dataType = "string"),
            @ApiImplicitParam(name = "lat", value = "위도", required = true, dataType = "string"),
            @ApiImplicitParam(name = "pageNo", value = "페이지 번호", required = true, dataType = "int")
    })
    public EmergencyCenterLocationDto getEmergencyLocation(@PathVariable String lon,
                                                           @PathVariable String lat,
                                                           @PathVariable int pageNo){
        return emergencyCenterLocationGetService.getEmergencyLocation(lon, lat, pageNo);
    }


    @GetMapping("/information/{hpid}/{pageNo}")
    @ApiOperation("응급의료기관 기본 정보 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hpid", value = "병원 코드", required = true, dataType = "string"),
            @ApiImplicitParam(name = "pageNo", value = "페이지 번호", required = true, dataType = "int")
    })
    public EmergencyCenterInfoDto getEmergencyInformation(@PathVariable String hpid,
                                                          @PathVariable int pageNo){
        return emergencyCenterInfoGetService.getEmergencyInformation(hpid, pageNo);
    }

    // TODO: 2020-01-22 외상센터도 안먹힘
    @GetMapping("/traumaCenter/{q0}/{q1}/{pageNo}")
    @ApiOperation("외상센터 목록 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "q0", value = "시/도", required = true, dataType = "string"),
            @ApiImplicitParam(name = "q1", value = "시/군/구", required = true, dataType = "string"),
            @ApiImplicitParam(name = "pageNo", value = "페이지 번호", required = true, dataType = "int")
    })
    public EmergencyTraumaCenterDto getEmergencyTraumaCenterByLocation(@PathVariable String q0,
                                                                       @PathVariable String q1,
                                                                       @PathVariable int pageNo){
        return emergencyTraumaCenterListGetService.getTraumaCenterByLocation(q0, q1, pageNo);
    }

    @GetMapping("/traumaCenter/{qn}/{pageNo}")
    @ApiOperation("외상센터 목록 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "qn", value = "기관명", required = true, dataType = "string"),
            @ApiImplicitParam(name = "pageNo", value = "페이지 번호", required = true, dataType = "int")
    })
    public EmergencyTraumaCenterDto getEmergencyTraumaCenterByName(@PathVariable String qn,
                                                                   @PathVariable int pageNo){
        return emergencyTraumaCenterListGetService.getTraumaCenterByName(qn, pageNo);
    }

    @GetMapping("/traumaCenterLocation/{lon}/{lat}/{pageNo}")
    @ApiOperation("외상센터 위치 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lon", value = "경도", required = true, dataType = "string"),
            @ApiImplicitParam(name = "lat", value = "위도", required = true, dataType = "string"),
            @ApiImplicitParam(name = "pageNo", value = "페이지 번호", required = true, dataType = "int")
    })
    public EmergencyTraumaCenterLocationDto getEmergencyTraumaCenterLocation(@PathVariable String lon,
                                                                             @PathVariable String lat,
                                                                             @PathVariable int pageNo){
        return emergencyTraumaCenterLocationGetService.getTraumaCenterLocationByLocation(lon, lat, pageNo);
    }

    @GetMapping("/traumaCenterInfo/{hpid}/{pageNo}")
    @ApiOperation("외상센터 기본 정보 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hpid", value = "병원 코드", required = true, dataType = "string"),
            @ApiImplicitParam(name = "pageNo", value = "페이지 번호", required = true, dataType = "int")
    })
    public EmergencyTraumaCenterInfoDto getEmergencyTraumaCenterInfo(@PathVariable String hpid,
                                                                     @PathVariable int pageNo){
        return emergencyTraumaCenterInfoGetService.getTraumaCenterInfo(hpid,pageNo);
    }


    @GetMapping("/message/{hpid}/{pageNo}")
    @ApiOperation("응급실 및 중증질환 메세지 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hpid", value = "병원 코드", required = true, dataType = "string"),
            @ApiImplicitParam(name = "pageNo", value = "페이지 번호", required = true, dataType = "int")
    })
    public EmergencySeriousDiseaseMsgDto getEmergencyMessageById(@PathVariable String hpid,
                                                                 @PathVariable int pageNo){
        return emergencySeriousDiseaseMsgGetService.getEmergencyMsg(hpid, pageNo);
    }

    @GetMapping("/message/{q0}/{q1}/{pageNo}")
    @ApiOperation("응급실 및 중증질환 메세지 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "q0", value = "시/도", required = true, dataType = "string"),
            @ApiImplicitParam(name = "q1", value = "시/군/구", required = true, dataType = "string"),
            @ApiImplicitParam(name = "pageNo", value = "페이지 번호", required = true, dataType = "int")
    })
    public EmergencySeriousDiseaseMsgDto getEmergencyMessageByLocation(@PathVariable String q0,
                                                                       @PathVariable String q1,
                                                                       @PathVariable int pageNo){
        return emergencySeriousDiseaseMsgGetService.getEmergencyMsgByLocation(q0, q1, pageNo);
    }



}
