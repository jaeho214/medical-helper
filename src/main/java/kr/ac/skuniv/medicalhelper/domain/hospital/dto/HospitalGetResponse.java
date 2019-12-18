package kr.ac.skuniv.medicalhelper.domain.hospital.dto;


import kr.ac.skuniv.medicalhelper.domain.evaluation.hospital.entity.HospitalComment;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Builder
@AllArgsConstructor
public class HospitalGetResponse {

    private Long hospitalNo;
    private String name;
    private String location;
    private String tel;
    private String address;
    private String homepage;
    private String hospitalCode;
    private String hospitalCodeName;
    private int doctorCount;
    private String openDate;
    private int generalDoctorCount;
    private String hospitalUrl;
    private int internCount;
    private String postNo;
    private int residentCount;
    private int specialDoctorCount;
    private String stateCode; // 시군구코드
    private String cityCode; // 시도 코드
    private String cityCodeName;
    private String xPos;
    private String yPos;
    private List<HospitalComment> comments;

    public static HospitalGetResponse of(Hospital hospital){
        return HospitalGetResponse.builder()
                .hospitalNo(hospital.getHospitalNo())
                .address(hospital.getAddress())
                .cityCode(hospital.getCityCode())
                .cityCodeName(hospital.getCityCodeName())
                .doctorCount(hospital.getDoctorCount())
                .generalDoctorCount(hospital.getGeneralDoctorCount())
                .hospitalUrl(hospital.getHospitalUrl())
                .hospitalCode(hospital.getHospitalCode())
                .hospitalCodeName(hospital.getHospitalCodeName())
                .internCount(hospital.getInternCount())
                .name(hospital.getName())
                .openDate(hospital.getOpenDate())
                .postNo(hospital.getPostNo())
                .residentCount(hospital.getResidentCount())
                .specialDoctorCount(hospital.getSpecialDoctorCount())
                .stateCode(hospital.getStateCode())
                .tel(hospital.getTel())
                .xPos(hospital.getXPos())
                .yPos(hospital.getYPos())
                .comments(hospital.getHospitalComment())
                .build();
    }

}
