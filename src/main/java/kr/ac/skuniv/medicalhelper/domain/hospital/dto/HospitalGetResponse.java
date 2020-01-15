package kr.ac.skuniv.medicalhelper.domain.hospital.dto;


import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.entity.HospitalComment;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class HospitalGetResponse {

    private Long id;
    private String name;
    private String location;
    private String tel;
    private String address;
    private String homepage;
    private String hospitalCodeName;
    private int doctorCount;
    private String openDate;
    private int generalDoctorCount;
    private String hospitalUrl;
    private int internCount;
    private String postNo;
    private int residentCount;
    private int specialDoctorCount;
    private String cityCodeName;
    private String xPos;
    private String yPos;
    private List<HospitalComment> comments;

    public static HospitalGetResponse entity2dto(Hospital hospital){
        return HospitalGetResponse.builder()
                .id(hospital.getId())
                .address(hospital.getAddress())
                .cityCodeName(hospital.getCityCodeName())
                .doctorCount(hospital.getDoctorCount())
                .generalDoctorCount(hospital.getGeneralDoctorCount())
                .hospitalUrl(hospital.getHospitalUrl())
                .hospitalCodeName(hospital.getHospitalCodeName())
                .internCount(hospital.getInternCount())
                .name(hospital.getName())
                .openDate(hospital.getOpenDate())
                .postNo(hospital.getPostNo())
                .residentCount(hospital.getResidentCount())
                .specialDoctorCount(hospital.getSpecialDoctorCount())
                .tel(hospital.getTel())
                .xPos(hospital.getXPos())
                .yPos(hospital.getYPos())
                .comments(hospital.getHospitalComment())
                .build();
    }

}
