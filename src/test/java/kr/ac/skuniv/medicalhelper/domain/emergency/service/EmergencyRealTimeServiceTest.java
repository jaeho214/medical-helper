package kr.ac.skuniv.medicalhelper.domain.emergency.service;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.realTime.EmergencyRealTimeDto;
import kr.ac.skuniv.medicalhelper.global.api.EmergencyApiRequest;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
class EmergencyRealTimeServiceTest {
    @Value("${serviceKey}")
    private String serviceKey;
    private String uri;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private EmergencyRealTimeService emergencyRealTimeService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void select() throws URISyntaxException {
        String stage1 = "경기도";
        String stage2 = "시흥시";
        int pageNo = 1;

        EmergencyRealTimeDto realTimeDto = emergencyRealTimeService.getRealTime(stage1, stage2, pageNo);

        assertThat(realTimeDto.getBody()).isNotNull();
    }

}