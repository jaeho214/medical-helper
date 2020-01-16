package kr.ac.skuniv.medicalhelper.domain.emergency.dto.realTime;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@Getter @Setter
@NoArgsConstructor
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyRealTimeItemDto {
    @XmlElement(name = "dutyname")
    private String name; //기관명

    @XmlElement(name = "dutytel3")
    private String tel; //응급실 연락처

    @XmlElement(name = "hpid")
    private String code;

    @XmlElement(name = "hv1")
    private int doctorTel;

    @XmlElement(name = "hv10")
    private int pediatrician; // 소아 가능 여부

    @XmlElement(name = "hv11")
    private int incubator; //인큐베이터 여부

    @XmlElement(name = "hv12")
    private int pediatricianTel; //소아과 전문의 연락처

    @XmlElement(name = "hv2")
    private int internalMedicinePatientRoom; //내과 중환자실 자리 수

    @XmlElement(name = "hv3")
    private int surgicalPatientRoom; //외과 중환자실 자리 수

    @XmlElement(name = "hv4")
    private int orthopedicsSickRoom; //정형외과 입원실 수

    @XmlElement(name = "hv5")
    private int neurosurgerySickRoom; // 신경외과 입원실 수

    @XmlElement(name = "hv6")
    private int neurosurgeryPatientRoom; //신경외과 중환자실 수

    @XmlElement(name = "hv7")
    private int drugPatient; // 약물중환자 수

    @XmlElement(name = "hv8")
    private int burnPatient; // 화상중환자 수

    @XmlElement(name = "hv9")
    private int traumaticPatient; // 외상중환자 수

    @XmlElement(name = "hvamyn")
    private String canAmbulance; // 응급차 가용 여부

    @XmlElement(name = "hvangioayn")
    private String canJoyoung; // 조영 촬영기 가용 여부

    @XmlElement(name = "hvcc")
    private int neurologicalPatient; // 신경중환자 수

    @XmlElement(name = "hvccc")
    private int thoracicPatient; // 흉부중환자 수

    @XmlElement(name = "hvctayn")
    private String canCT; // CT 가용 여부

    @XmlElement(name = "hvec")
    private int emergencyRoom; // 응급실 수

    @XmlElement(name = "hvgc")
    private int sickRoom; // 입원실 수

    @XmlElement(name = "hvicc")
    private int generalPatient; // 일반중환자 수

    @XmlElement(name = "hvidate")
    private String inputDate;

    @XmlElement(name = "hvmriayn")
    private String canMRI; // MRI 가용 여부

    @XmlElement(name = "hvncc")
    private int newbornPatient; // 신생중환자 수

    @XmlElement(name = "hvoc")
    private int operatingRoom; // 수술실 수

    @XmlElement(name = "hvventiayn")
    private String canRespirator; //인공호흡기 가용 여부

    @XmlElement(name = "phpid")
    private String lastCode;

    @XmlElement(name = "rnum")
    private int id;
}
