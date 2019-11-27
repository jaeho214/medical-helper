package kr.ac.skuniv.medicalhelper.global.api;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ApiConnection {
    public StringBuilder connectToApi(StringBuilder builder) {
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(builder.toString());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-type", "application/json");


            BufferedReader br;
            if(urlConnection.getResponseCode() >= 200 && urlConnection.getResponseCode() <= 300)
                br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            else
                br = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));


            String returnLine;

            while ((returnLine = br.readLine()) != null) {
                result.append(returnLine.trim());
            }

            br.close();
            urlConnection.disconnect();

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
