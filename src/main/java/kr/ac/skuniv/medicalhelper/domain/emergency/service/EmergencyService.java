package kr.ac.skuniv.medicalhelper.domain.emergency.service;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.EmergencyRequest;
import kr.ac.skuniv.medicalhelper.global.common.XmlParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmergencyService {
    private final XmlParser xmlParser;
    private final String serviceKey = "";

    //응급실 실시간 가용 병상 정보 조회
    public List<EmergencyRequest> selectRealTime(String stage1, String stage2) throws UnsupportedEncodingException {
        List<EmergencyRequest> usefulRealTime = new ArrayList<>();

        StringBuilder url = new StringBuilder("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEmrrmRltmUsefulSckbdInfoInqire");
        url.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey);
        url.append("&" + URLEncoder.encode("STAGE1","UTF-8") + "=" + URLEncoder.encode(stage1, "UTF-8"));
        url.append("&" + URLEncoder.encode("STAGE2","UTF-8") + "=" + URLEncoder.encode(stage2, "UTF-8"));

        usefulRealTime = connectToApi(url);

        return usefulRealTime;
    }

    public List<EmergencyRequest> searchLocation(String lon, String lat) throws UnsupportedEncodingException {
        List<EmergencyRequest> searchLocation = new ArrayList<>();
        StringBuilder url = new StringBuilder("http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEgytLcinfoInqire");
        url.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey);
        url.append("&" + URLEncoder.encode("WGS84_LON","UTF-8") + "=" + URLEncoder.encode(lon, "UTF-8"));
        url.append("&" + URLEncoder.encode("WGS84_LAT","UTF-8") + "=" + URLEncoder.encode(lat, "UTF-8"));

        searchLocation = connectToApi(url);

        return searchLocation;
    }


    private List<EmergencyRequest> connectToApi(StringBuilder builder) {
        String result ="";
        try {
            URL url = new URL(builder.toString());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;
            while ((returnLine = br.readLine()) != null) {
                result += returnLine.trim();
            }

            urlConnection.disconnect();

        }catch (Exception e){
            e.printStackTrace();
        }

        return xmlParser.stringToXml(result);
    }

}
