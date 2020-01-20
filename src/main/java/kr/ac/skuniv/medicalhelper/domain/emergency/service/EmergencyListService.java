package kr.ac.skuniv.medicalhelper.domain.emergency.service;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.listInfo.EmergencyListInfoDto;
import kr.ac.skuniv.medicalhelper.global.api.EmergencyApiRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class EmergencyListService {
    @Value("${serviceKey}")
    private String serviceKey;
    private String uri;
    private RestTemplate restTemplate;

    public EmergencyListService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EmergencyListInfoDto selectEmergentListByLocation(String q0, String q1, int pageNo) {
        StringBuilder sb = new StringBuilder();
        uri = EmergencyApiRequest.EMERGENT_LIST.getUri();
        try{
            sb.append(uri);
            sb.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            sb.append("&" + URLEncoder.encode("Q0", "UTF-8") + "=" + URLEncoder.encode(q0, "UTF-8"));
            sb.append("&" + URLEncoder.encode("Q1", "UTF-8") + "=" + URLEncoder.encode(q1, "UTF-8"));
            sb.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + pageNo);

            URI restURI = new URI(sb.toString());
            log.info(restURI.toString());
            EmergencyListInfoDto emergencyListInfoDto = restTemplate.getForObject(restURI, EmergencyListInfoDto.class);

            return emergencyListInfoDto;

        } catch (UnsupportedEncodingException | URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    public EmergencyListInfoDto selectEmergentListByName(String qn, int pageNo) {
        StringBuilder sb = new StringBuilder();
        uri = EmergencyApiRequest.EMERGENT_LIST.getUri();
        try{
            sb.append(uri);
            sb.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            sb.append("&" + URLEncoder.encode("QN", "UTF-8") + "=" + URLEncoder.encode(qn, "UTF-8"));


            URI restURI = new URI(sb.toString());
            log.info(restURI.toString());
            EmergencyListInfoDto emergencyListInfoDto = restTemplate.getForObject(restURI, EmergencyListInfoDto.class);

            return emergencyListInfoDto;

        } catch (UnsupportedEncodingException | URISyntaxException e) {
            e.printStackTrace();
        }

        return null;

    }
}
