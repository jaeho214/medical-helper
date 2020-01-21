package kr.ac.skuniv.medicalhelper.domain.emergency.service;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.emergencyCenter.location.EmergencyCenterLocationDto;
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
public class EmergencyCenterLocationGetService {
    @Value("${serviceKey}")
    private String serviceKey;
    private String uri;

    private RestTemplate restTemplate;

    public EmergencyCenterLocationGetService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EmergencyCenterLocationDto getEmergencyLocation(String lon, String lat, int pageNo) {
        StringBuilder sb = new StringBuilder();
        uri = EmergencyApiRequest.LOCATION.getUri();
        try{
            sb.append(uri);
            sb.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            sb.append("&" + URLEncoder.encode("WGS84_LON", "UTF-8") + "=" + URLEncoder.encode(lon, "UTF-8"));
            sb.append("&" + URLEncoder.encode("WGS84_LAT", "UTF-8") + "=" + URLEncoder.encode(lat, "UTF-8"));
            sb.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + pageNo);

            URI restURI = new URI(sb.toString());
            log.info(restURI.toString());
            EmergencyCenterLocationDto locationDto = restTemplate.getForObject(restURI, EmergencyCenterLocationDto.class);

            return locationDto;

        } catch (UnsupportedEncodingException | URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}
