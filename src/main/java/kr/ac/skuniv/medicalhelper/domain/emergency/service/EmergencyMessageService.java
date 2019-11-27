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
public class EmergencyMessageService {
    private final ApiConnection apiConnection;
    private final XmlParser xmlParser;
    private final String serviceKey = "";

    public Map<String, Object> selectEmergencyMessageById(String hpid) {
        Map<String, Object> emergencyMessage = new HashMap<>();
        StringBuilder url = new StringBuilder();
        try{
            url.append("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEmrrmSrsillDissMsgInqire");
            url.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            url.append("&" + URLEncoder.encode("HPID", "UTF-8") + "=" + URLEncoder.encode(hpid, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder result = apiConnection.connectToApi(url);
        emergencyMessage = xmlParser.xmlToJson(result.toString());

        return emergencyMessage;
    }

    public Map<String, Object> selectEmergencyMessageByLocation(String q0, String q1) {
        Map<String, Object> emergencyMessage = new HashMap<>();
        StringBuilder url = new StringBuilder();
        try{
            url.append("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEmrrmSrsillDissMsgInqire");
            url.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            url.append("&" + URLEncoder.encode("Q0", "UTF-8") + "=" + URLEncoder.encode(q0, "UTF-8"));
            url.append("&" + URLEncoder.encode("Q1", "UTF-8") + "=" + URLEncoder.encode(q1, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder result = apiConnection.connectToApi(url);
        emergencyMessage = xmlParser.xmlToJson(result.toString());

        return emergencyMessage;
    }

    public Map<String, Object> selectEmergencyMessageByName(String qn) {
        Map<String, Object> emergencyMessage = new HashMap<>();
        StringBuilder url = new StringBuilder();
        try{
            url.append("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEmrrmSrsillDissMsgInqire");
            url.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            url.append("&" + URLEncoder.encode("QN", "UTF-8") + "=" + URLEncoder.encode(qn, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder result = apiConnection.connectToApi(url);
        emergencyMessage = xmlParser.xmlToJson(result.toString());

        return emergencyMessage;
    }
}
