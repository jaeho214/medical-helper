package kr.ac.skuniv.medicalhelper.domain.emergency.service;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.realTime.EmergencyRealTimeDto;
import kr.ac.skuniv.medicalhelper.global.api.ApiConnection;
import kr.ac.skuniv.medicalhelper.global.api.EmergencyApiRequest;
import kr.ac.skuniv.medicalhelper.global.api.XmlParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmergencyRealTimeService {
    @Value("${serviceKey}")
    private String serviceKey;
    private String uri;
    //private final ApiConnection apiConnection;
    //private final XmlParser xmlParser;
    private RestTemplate restTemplate;


    public EmergencyRealTimeDto selectRealTime(String stage1, String stage2, int pageNo)  {
        StringBuilder sb = new StringBuilder();
        uri = EmergencyApiRequest.REALTIME.getUri();
        URI restURi;
        try{
            restURi = new URI((sb.append(String.format(uri, serviceKey, stage1, stage2, pageNo))).toString());
            EmergencyRealTimeDto realTimeDto = restTemplate.getForObject(restURi, EmergencyRealTimeDto.class);

            return realTimeDto;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
//        Map<String, Object> usefulRealTime = new HashMap<>();
//        StringBuilder sb = new StringBuilder();
//        try {
//            sb.append("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEmrrmRltmUsefulSckbdInfoInqire");
//            sb.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
//            sb.append("&" + URLEncoder.encode("STAGE1", "UTF-8") + "=" + URLEncoder.encode(stage1, "UTF-8"));
//            sb.append("&" + URLEncoder.encode("STAGE2", "UTF-8") + "=" + URLEncoder.encode(stage2, "UTF-8"));
//            sb.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + pageNo);
//
//
//        }catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

//        StringBuilder result = apiConnection.connectToApi(url);
//        usefulRealTime = xmlParser.xmlToJson(result.toString());
        return null;
    }

}
