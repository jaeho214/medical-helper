package kr.ac.skuniv.medicalhelper.global.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmergencyApiRequest {
    REALTIME("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEmrrmRltmUsefulSckbdInfoInqire"),
    SERIOUS_DISEASE("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getSrsillDissAceptncPosblInfoInqire"),
    SERIOUS_DISEASE_MSG("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEmrrmSrsillDissMsgInqire"),
    EMERGENT_LIST("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEgytListInfoInqire"),
    LOCATION("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEgytLcinfoInqire"),
    INFORMATION("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEgytBassInfoInqire"),
    TRAUMA_CENTER("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getStrmListInfoInqire"),
    TRAUMA_CENTER_LOCATION("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getStrmLcinfoInqire"),
    TRAUMA_CENTER_INFO("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getStrmBassInfoInqire");


    private String uri;
}
