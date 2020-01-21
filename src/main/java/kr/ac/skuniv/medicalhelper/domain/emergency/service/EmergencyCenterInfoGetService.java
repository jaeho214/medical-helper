package kr.ac.skuniv.medicalhelper.domain.emergency.service;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.emergencyCenter.info.EmergencyCenterInfoDto;
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
public class EmergencyCenterInfoGetService {

    @Value("${serviceKey}")
    private String serviceKey;
    private String uri;

    private RestTemplate restTemplate;

    public EmergencyCenterInfoGetService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EmergencyCenterInfoDto getEmergencyInformation(String hpid, int pageNo) {
        StringBuilder sb = new StringBuilder();
        uri = EmergencyApiRequest.INFORMATION.getUri();
        try{
            sb.append(uri);
            sb.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            sb.append("&" + URLEncoder.encode("HPID", "UTF-8") + "=" + URLEncoder.encode(hpid, "UTF-8"));
            sb.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + pageNo);

            return connectToApi(sb.toString());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private EmergencyCenterInfoDto connectToApi(String apiUri){

        try {
            URI restURI = new URI(apiUri);
            log.info(restURI.toString());
            EmergencyCenterInfoDto informationDto = restTemplate.getForObject(restURI, EmergencyCenterInfoDto.class);

            return informationDto;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
