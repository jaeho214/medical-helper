package kr.ac.skuniv.medicalhelper.domain.emergency.dto.seriousDisease.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencySeriousDiseaseMsgItemDto {
    private String dutyAddr;
    private String dutyName;
    private String emcOrgCod;
    private String hpid;
    private int rnum;
    private String symBlkMsg;
    private String symBlkMsgTyp;
    private String symBlkSttDtm;
    private String symOutDspYon;
    private String symOutDspMth;
    private String symTypCod;
}
