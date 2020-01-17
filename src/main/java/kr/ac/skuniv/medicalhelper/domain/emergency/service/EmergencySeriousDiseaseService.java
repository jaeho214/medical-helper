package kr.ac.skuniv.medicalhelper.domain.emergency.service;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.seriousDisease.EmergencySeriousDiseaseDto;
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
public class EmergencySeriousDiseaseService {
    @Value("${serviceKey}")
    private String serviceKey;
    private String uri;

    private RestTemplate restTemplate;

    public EmergencySeriousDiseaseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EmergencySeriousDiseaseDto selectSeriousDisease(String stage1, String stage2, int pageNo) {
        StringBuilder sb = new StringBuilder();
        uri = EmergencyApiRequest.SERIOUS_DISEASE.getUri();
        try{
            sb.append(uri);
            sb.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            sb.append("&" + URLEncoder.encode("STAGE1", "UTF-8") + "=" + URLEncoder.encode(stage1, "UTF-8"));
            sb.append("&" + URLEncoder.encode("STAGE2", "UTF-8") + "=" + URLEncoder.encode(stage2, "UTF-8"));
            sb.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + pageNo);

            URI restURI = new URI(sb.toString());
            log.info(restURI.toString());
            EmergencySeriousDiseaseDto seriousDiseaseDto = restTemplate.getForObject(restURI, EmergencySeriousDiseaseDto.class);


            return seriousDiseaseDto;
        } catch (UnsupportedEncodingException | URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}
