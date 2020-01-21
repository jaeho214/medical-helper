package kr.ac.skuniv.medicalhelper.domain.emergency.service;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.traumaCenter.info.EmergencyTraumaCenterInfoDto;
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
public class EmergencyTraumaCenterInfoGetService {
    @Value("${serviceKey}")
    private String serviceKey;
    private String uri = EmergencyApiRequest.TRAUMA_CENTER_INFO.getUri();

    private RestTemplate restTemplate;

    public EmergencyTraumaCenterInfoGetService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EmergencyTraumaCenterInfoDto getTraumaCenterInfo(String hpid, int pageNo){
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
    private EmergencyTraumaCenterInfoDto connectToApi(String apiUri){

        try {
            URI restURI = new URI(apiUri);
            log.info(restURI.toString());
            EmergencyTraumaCenterInfoDto traumaCenterInfoDto = restTemplate.getForObject(restURI, EmergencyTraumaCenterInfoDto.class);

            return traumaCenterInfoDto;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
