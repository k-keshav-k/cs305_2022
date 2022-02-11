package org.assign1_temp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class xml_parser {
    public List<Queries> parse_xml() {
        List<Queries> queries = new ArrayList<Queries>();
        try {
            File file = new File("queries.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File("D:\\Course_materials\\CS305\\Assignments\\assign1_temp\\lib\\src\\main\\java\\org\\assign1_temp\\queries.xml"));
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            for(int i=0;i<nodeList.getLength();i++){
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    String ID = elem.getAttributes().getNamedItem("id").getNodeValue();
                    String paramType = elem.getAttributes().getNamedItem("paramType").getNodeValue();
                    String query_value = elem.getTextContent();
                    queries.add(new Queries(ID, paramType, query_value));
                }
            }
            System.out.println("Queries are: ");
            for(Queries q: queries) {
                System.out.println(q.ID + " " + q.paramType + " " + q.sql_query.trim());
            }
        } catch (Exception e) {e.printStackTrace();}
        return queries;
    }
}