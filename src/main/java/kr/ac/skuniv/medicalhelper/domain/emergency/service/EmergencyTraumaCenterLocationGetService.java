package kr.ac.skuniv.medicalhelper.domain.emergency.service;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.traumaCenter.location.EmergencyTraumaCenterLocationDto;
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
public class EmergencyTraumaCenterLocationGetService {
    @Value("${serviceKey}")
    private String serviceKey;
    private String uri = EmergencyApiRequest.TRAUMA_CENTER_LOCATION.getUri();

    private RestTemplate restTemplate;

    public EmergencyTraumaCenterLocationGetService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EmergencyTraumaCenterLocationDto getTraumaCenterLocationByLocation(String lon, String lat, int pageNo){
        StringBuilder sb = new StringBuilder(uri);
        try{
            sb.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            sb.append("&" + URLEncoder.encode("WGS84_LON", "UTF-8") + "=" + URLEncoder.encode(lon, "UTF-8"));
            sb.append("&" + URLEncoder.encode("WGS84_LAT", "UTF-8") + "=" + URLEncoder.encode(lat, "UTF-8"));
            sb.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + pageNo);

            return connectToApi(sb.toString());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    private EmergencyTraumaCenterLocationDto connectToApi(String apiUri){

        try {
            URI restURI = new URI(apiUri);
            log.info(restURI.toString());
            EmergencyTraumaCenterLocationDto traumaCenterLocationDto = restTemplate.getForObject(restURI, EmergencyTraumaCenterLocationDto.class);

            return traumaCenterLocationDto;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
