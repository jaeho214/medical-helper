package kr.ac.skuniv.medicalhelper.domain.emergency.service;

import kr.ac.skuniv.medicalhelper.global.api.ApiConnection;
import kr.ac.skuniv.medicalhelper.global.api.XmlParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmergencyRealTimeService {
    private final ApiConnection apiConnection;
    private final XmlParser xmlParser;
    private final String serviceKey = "";

    public Map<String, Object> selectRealTime(String stage1, String stage2)  {
        Map<String, Object> usefulRealTime = new HashMap<>();
        StringBuilder url = new StringBuilder();
        try {
            url.append("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEmrrmRltmUsefulSckbdInfoInqire");
            url.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            url.append("&" + URLEncoder.encode("STAGE1", "UTF-8") + "=" + URLEncoder.encode(stage1, "UTF-8"));
            url.append("&" + URLEncoder.encode("STAGE2", "UTF-8") + "=" + URLEncoder.encode(stage2, "UTF-8"));

        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        StringBuilder result = apiConnection.connectToApi(url);
        usefulRealTime = xmlParser.xmlToJson(result.toString());

        return usefulRealTime;
    }

}
