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
public class EmergencyGetLocationService {
    private final ApiConnection apiConnection;
    private final XmlParser xmlParser;
    private final String serviceKey = "";

    public Map<String, Object> selectEmergencyLocation(String lon, String lat) {
        Map<String, Object> emergencyLocation = new HashMap<>();
        StringBuilder url = new StringBuilder();
        try{

            url.append("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEgytLcinfoInqire");
            url.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            url.append("&" + URLEncoder.encode("WGS84_LON", "UTF-8") + "=" + URLEncoder.encode(lon, "UTF-8"));
            url.append("&" + URLEncoder.encode("WGS84_LAT", "UTF-8") + "=" + URLEncoder.encode(lat, "UTF-8"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder result = apiConnection.connectToApi(url);
        emergencyLocation = xmlParser.xmlToJson(result.toString());

        return emergencyLocation;
    }
}
