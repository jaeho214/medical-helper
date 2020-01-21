package kr.ac.skuniv.medicalhelper.domain.emergency.service;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.traumaCenter.list.EmergencyTraumaCenterDto;
import kr.ac.skuniv.medicalhelper.global.api.EmergencyApiRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

@Slf4j
@Service
public class EmergencyTraumaCenterListGetService {
    @Value("${serviceKey}")
    private String serviceKey;
    private String uri = EmergencyApiRequest.TRAUMA_CENTER.getUri();

    private RestTemplate restTemplate;

    public EmergencyTraumaCenterListGetService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EmergencyTraumaCenterDto getTraumaCenterByLocation(String q0, String q1, int pageNo){
        StringBuilder sb = new StringBuilder(uri);
        try{
            sb.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            sb.append("&" + URLEncoder.encode("Q0", "UTF-8") + "=" + URLEncoder.encode(q0, "UTF-8"));
            sb.append("&" + URLEncoder.encode("Q1", "UTF-8") + "=" + URLEncoder.encode(q1, "UTF-8"));
            sb.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + pageNo);

            return connectToApi(sb.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public EmergencyTraumaCenterDto getTraumaCenterByName(String qn, int pageNo){
        StringBuilder sb = new StringBuilder(uri);
        try{
            sb.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            sb.append("&" + URLEncoder.encode("QN", "UTF-8") + "=" + URLEncoder.encode(qn, "UTF-8"));
            sb.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + pageNo);

            return connectToApi(sb.toString());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    private EmergencyTraumaCenterDto connectToApi(String apiUri){

        try {
            URI restURI = new URI(apiUri);
            log.info(restURI.toString());
            EmergencyTraumaCenterDto traumaCenterDto = restTemplate.getForObject(restURI, EmergencyTraumaCenterDto.class);

            return traumaCenterDto;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
