package Lev_30_lec_10_2;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/*
Комментарий внутри xml
*/

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, IOException, SAXException, ParserConfigurationException, TransformerException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, writer);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new InputSource(new StringReader(writer.toString())));

        NodeList nodes = document.getFirstChild().getChildNodes();

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeName().equals(tagName) && nodes.item(i).getNodeType() == 1) {
                nodes.item(i).getParentNode().insertBefore(document.createComment(comment), nodes.item(i));
                i++;
            }
        }

        StringWriter sW = new StringWriter();

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
        transformer.transform(new DOMSource(document), new StreamResult(sW));

        return sW.toString();
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException, JAXBException {
        System.out.println(toXmlWithComment(new First(), "second", "it's a comment"));
    }
    //object for marshalling to XML
    @XmlType(name = "First")
    @XmlRootElement
    public static class First {
        @XmlElement
        public static List<String> second = new ArrayList<>();

        public First() {
            second.add("Data-1");
            second.add("Data-2");
            second.add("Data-3");
            second.add("");
        }
    }
}
