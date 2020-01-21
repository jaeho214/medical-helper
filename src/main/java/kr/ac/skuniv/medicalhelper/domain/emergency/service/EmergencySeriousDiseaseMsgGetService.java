package kr.ac.skuniv.medicalhelper.domain.emergency.service;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.seriousDisease.message.EmergencySeriousDiseaseMsgDto;
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
public class EmergencySeriousDiseaseMsgGetService {
    @Value("${serviceKey}")
    private String serviceKey;
    private String uri = EmergencyApiRequest.SERIOUS_DISEASE_MSG.getUri();

    private RestTemplate restTemplate;

    public EmergencySeriousDiseaseMsgGetService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EmergencySeriousDiseaseMsgDto getEmergencyMsg(String hpid, int pageNo) {
        StringBuilder sb = new StringBuilder(uri);

        try{
            sb.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            sb.append("&" + URLEncoder.encode("HPID", "UTF-8") + "=" + URLEncoder.encode(hpid, "UTF-8"));
            sb.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + pageNo);

            return connectToApi(sb.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return null;
    }

    public EmergencySeriousDiseaseMsgDto getEmergencyMsgByLocation(String q0, String q1, int pageNo) {
        StringBuilder sb = new StringBuilder(uri);
        try{
            sb.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            sb.append("&" + URLEncoder.encode("Q0", "UTF-8") + "=" + URLEncoder.encode(q0, "UTF-8"));
            sb.append("&" + URLEncoder.encode("Q1", "UTF-8") + "=" + URLEncoder.encode(q1, "UTF-8"));
            sb.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + pageNo);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return connectToApi(sb.toString());
    }

    private EmergencySeriousDiseaseMsgDto connectToApi(String apiUri) {
        try {
            URI restURI = new URI(apiUri);
            log.info(restURI.toString());
            return restTemplate.getForObject(restURI, EmergencySeriousDiseaseMsgDto.class);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

}
