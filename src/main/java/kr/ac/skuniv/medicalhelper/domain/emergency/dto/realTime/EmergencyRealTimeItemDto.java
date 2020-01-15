package kr.ac.skuniv.medicalhelper.domain.emergency.dto.realTime;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyRealTimeItemDto {
    @XmlElement(name = "rnum")
    private int id;

    @XmlElement(name = "hvidate")
    private String inputDate;

    @XmlElement(name = "hvec")
    private String emergencyRoom; // 응급실 수

    @XmlElement(name = "hvoc")
    private String operatingRoom; // 수술실 수

    @XmlElement(name = "hvcc")
    private String neurologicalPatient; // 신경중환자 수
    @XmlElement(name = "hvncc")
    private String newbornPatient; // 신생중환자 수
    @XmlElement(name = "hvccc")
    private String thoracicPatient; // 흉부중환자 수
    @XmlElement(name = "hvicc")
    private String generalPatient; // 일반중환자 수
    @XmlElement(name = "hvgc")
    private String sickRoom; // 입원실 수
    @XmlElement(name = "hvdnm")
    private String doctorName; // 당직의 이름
    @XmlElement(name = "hvctayn")
    private String canCT; // CT 가용 여부
    @XmlElement(name = "hvmriayn")
    private String canMRI; // MRI 가용 여부
    @XmlElement(name = "hvangioayn")
    private String canJoyoung; // 조영 촬영기 가용 여부
    @XmlElement(name = "hvventiayn")
    private String canRespirator; //인공호흡기 가용 여부
    @XmlElement(name = "hvamyn")
    private String canAmbulance; // 응급차 가용 여부
    @XmlElement(name = "hv1")
    private String doctorTel;
    @XmlElement(name = "hv2")
    private String internalMedicinePatientRoom; //내과 중환자실 자리 수
    @XmlElement(name = "hv3")
    private String surgicalPatientRoom; //외과 중환자실 자리 수
    @XmlElement(name = "hv4")
    private String orthopedicsSickRoom; //정형외과 입원실 수
    @XmlElement(name = "hv5")
    private String neurosurgerySickRoom; // 신경외과 입원실 수
    @XmlElement(name = "hv6")
    private String neurosurgeryPatientRoom; //신경외과 중환자실 수
    @XmlElement(name = "hv7")
    private String drugPatient; // 약물중환자 수
    @XmlElement(name = "hv8")
    private String burnPatient; // 화상중환자 수
    @XmlElement(name = "hv9")
    private String traumaticPatient; // 외상중환자 수
    @XmlElement(name = "hv10")
    private String venti; // 소아 가능 여부
    @XmlElement(name = "hv11")
    private String incubator; //인큐베이터 여부
    @XmlElement(name = "hv12")
    private String pediatricianTel; //소아과 전문의 연락처
    @XmlElement(name = "dutyname")
    private String name; //기관명
    @XmlElement(name = "dutytel3")
    private String tel; //응급실 연락처








}
