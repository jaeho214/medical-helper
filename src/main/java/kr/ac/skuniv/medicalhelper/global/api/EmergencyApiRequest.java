package kr.ac.skuniv.medicalhelper.global.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmergencyApiRequest {
    REALTIME("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEmrrmRltmUsefulSckbdInfoInqire"),
    SERIOUS_DISEASE("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getSrsillDissAceptncPosblInfoInqire"),
    EMERGENT_LIST("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEgytListInfoInqire");
    private String uri;
}
