package kr.ac.skuniv.medicalhelper.domain.emergency.dto.realTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@Getter @Setter
@NoArgsConstructor
@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyRealTimeItemDto {
    private String dutyName; //기관명
    private String dutyTel3; //응급실 연락처
    private String hpid;
    private String hv1;
    private String hv10; // 소아 가능 여부
    private String hv11; //인큐베이터 여부
    private String hv12; //소아과 전문의 연락처
    private String hv2; //내과 중환자실 자리 수
    private String hv3; //외과 중환자실 자리 수
    private String hv4; //정형외과 입원실 수
    private String hv5; // 신경외과 입원실 수
    private String hv6; //신경외과 중환자실 수
    private String hv7; // 약물중환자 수
    private String hv8; // 화상중환자 수
    private String hv9; // 외상중환자 수
    private String hvamyn; // 응급차 가용 여부
    private String hvangioayn; // 조영 촬영기 가용 여부
    private String hvcc; // 신경중환자 수
    private String hvccc; // 흉부중환자 수
    private String hvctayn; // CT 가용 여부
    private String hvec; // 응급실 수
    private String hvgc; // 입원실 수
    private String hvicc; // 일반중환자 수
    private String hvidate;
    private String hvmriayn; // MRI 가용 여부
    private String hvncc; // 신생중환자 수
    private String hvoc; // 수술실 수
    private String hvventiayn; //인공호흡기 가용 여부
    private String phpid;
    private int rnum;
}
