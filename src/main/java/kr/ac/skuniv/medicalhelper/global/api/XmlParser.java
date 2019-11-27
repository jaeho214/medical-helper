package kr.ac.skuniv.medicalhelper.global.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class XmlParser {
    public Map<String, Object> xmlToJson(String str){
        Map<String, Object> resultMap = new HashMap<>();
        try {
            JSONObject xmlJsonObj = XML.toJSONObject(str);
            String xmlJsonObjString = xmlJsonObj.toString();

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = new HashMap<>();

            map = objectMapper.readValue(xmlJsonObjString, new TypeReference<Map<String, Object>>() {
            });

            Map<String, Object> dataResponse = (Map<String, Object>) map.get("response");
            Map<String, Object> body = (Map<String, Object>) dataResponse.get("body");
            Map<String, Object> items = null;
            List<Map<String, Object>> itemList = null;

            resultMap.put("Result", "0000");
            resultMap.put("numOfRows", body.get("numOfRows"));
            resultMap.put("pageNo", body.get("pageNo"));
            resultMap.put("totalCount", body.get("totalCount"));

            items = (Map<String, Object>) body.get("items");
            int totalCount = (int) body.get("totalCount");

            if(totalCount > 1) {
                itemList = (List<Map<String, Object>>) items.get("item");
                resultMap.put("data", itemList);
            }else{
                Map<String, Object> item = (Map<String, Object>) items.get("item");
                resultMap.put("data", item);
            }

        } catch (Exception e) {
            e.printStackTrace();
            resultMap.clear();
            resultMap.put("Result", "0001");
        }

        return resultMap;
    }
}
