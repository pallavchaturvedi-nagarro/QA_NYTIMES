package com.ams.objectsRepos.obejctReader;

import org.openqa.selenium.By;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public final class ObjectRepoReader {

    private ObjectRepoReader(){}

    public static By getElementLocator(String elementName, String DATA_FILE){
        //String fileName=pageName+".xml";
        try {
//            File file = new File(System.getProperty("user.dir")+"/src/main/java/com/ams/objectsRepos/"+fileName);
            File file = new File(DATA_FILE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Element");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getElementsByTagName("NameOfElement").item(0).getTextContent();
                    if (name.equals(elementName)) {
                        String type = element.getElementsByTagName("Type").item(0).getTextContent();
                        String value = element.getElementsByTagName("Value").item(0).getTextContent();

                        return getBy(type, value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static By getBy(String type, String value) {
        switch (type.toLowerCase()) {
            case "xpath":
                return By.xpath(value);
            // Add more cases as needed (e.g., id, name, cssSelector, etc.)
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + type);
        }
    }
}
