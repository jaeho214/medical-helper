package kr.ac.skuniv.medicalhelper.global.common;

import kr.ac.skuniv.medicalhelper.domain.emergency.dto.EmergencyRequest;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class XmlParser {
    DocumentBuilder builder;
    Document doc = null;
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    public List<EmergencyRequest> stringToXml(String result){
        List<EmergencyRequest> emergency = new ArrayList<>();
        try{
            InputSource is = new InputSource(new StringReader(result));
            builder = factory.newDocumentBuilder();
            doc = builder.parse(is);
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            XPathExpression expr = xPath.compile("//items/item");
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for(int i=0;i<nodeList.getLength(); i++){
                NodeList child = nodeList.item(i).getChildNodes();
                for(int j=0;j<child.getLength();j++){
                    Node node = child.item(j);
                    EmergencyRequest dto = new EmergencyRequest();
                    dto.setItem(node.getNodeName());
                    dto.setValue(node.getTextContent());
                    emergency.add(dto);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return emergency;
    }
}
