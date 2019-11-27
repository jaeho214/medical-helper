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
public class EmergencyInformationService {
    private final ApiConnection apiConnection;
    private final XmlParser xmlParser;
    private final String serviceKey = "";

    public Map<String, Object> selectEmergencyInformation(String hpid) {
        Map<String, Object> emergencyInformation = new HashMap<>();
        StringBuilder url = new StringBuilder();
        try{
            url.append("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEgytBassInfoInqire");
            url.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            url.append("&" + URLEncoder.encode("HPID", "UTF-8") + "=" + URLEncoder.encode(hpid, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder result = apiConnection.connectToApi(url);
        emergencyInformation = xmlParser.xmlToJson(result.toString());

        return emergencyInformation;
    }
}
