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
public class EmergencyGetListService {
    private final ApiConnection apiConnection;
    private final XmlParser xmlParser;
    private final String serviceKey = "";


    public Map<String, Object> selectEmergencyList(String q0, String q1) {
        Map<String, Object> emergencyList = new HashMap<>();
        StringBuilder url = new StringBuilder();
        try{

            url.append("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEgytListInfoInqire");
            url.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            url.append("&" + URLEncoder.encode("Q0", "UTF-8") + "=" + URLEncoder.encode(q0, "UTF-8"));
            url.append("&" + URLEncoder.encode("Q1", "UTF-8") + "=" + URLEncoder.encode(q1, "UTF-8"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder result = apiConnection.connectToApi(url);
        emergencyList = xmlParser.xmlToJson(result.toString());

        return emergencyList;
    }
}
