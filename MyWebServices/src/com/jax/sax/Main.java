package com.jax.sax;

import com.jax.handler.PrintHandler;
import com.jax.handler.QuantityTotalHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Main {

    private final static String XML_FILE_PATH = "D:\\Education\\MyWebServices\\resources\\po.xml";
    //private final static String XSD_FILE_PATH = "D:\\Education\\MyWebServices\\resources\\po.xsd";

/*    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
	// write your code here
        SAXParserFactory saxParserFactory = null;
        SAXParser saxParser = null;
        //PrintHandler printHandler = null;
        SchemaFactory schemaFactory = null;
        Validator validator = null;
        Schema poSchema = null;
        QuantityTotalHandler quantityTotalHandler = null;


        schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        poSchema = schemaFactory.newSchema(new File(XSD_FILE_PATH));
        validator = poSchema.newValidator();
        Source xmlSource = new StreamSource(new File(XML_FILE_PATH));
        validator.validate(xmlSource);

        saxParserFactory = SAXParserFactory.newInstance();
        saxParser = saxParserFactory.newSAXParser();
        // printHandler = new PrintHandler();
        quantityTotalHandler = new QuantityTotalHandler();
        saxParser.parse(new File(XML_FILE_PATH), quantityTotalHandler);
        //System.out.println("@@@@ Toal Quantity : "+quantityTotalHandler.getTotalQuantity());
        System.out.println("@@@@ Toal Quantity : "+quantityTotalHandler.getItemsQuantityMap());
    }*/


    public static void main(String[] args) throws ParserConfigurationException,
            SAXException, IOException {
        DocumentBuilderFactory factory = null;
        DocumentBuilder builder = null;
        Document doc = null;

        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        doc = builder.parse(new File(XML_FILE_PATH));
        Node root = doc.getFirstChild();
		System.out.println("@@@  @@@@ "+root.getNodeType()+ ", NAMe : "+root.getNodeName()+",,Valude : "+root.getNodeValue());

		Node check = doc.getFirstChild().getFirstChild().getNextSibling();
		Node check1 = doc.getFirstChild().getFirstChild();
        System.out.println("@@@  @@@@ 111 "+check1.getNodeType()+ ", NAMe : "+check1.getNodeName()+",,Valude : "+check1.getNodeValue());
        System.out.println("@@@  @@@@ 111 "+check.getNodeType()+ ", NAMe : "+check.getNodeName()+",,Valude : "+check.getNodeValue());
		Node data = doc.getFirstChild().getFirstChild().getNextSibling()
				.getFirstChild().getNextSibling().getFirstChild()
				.getNextSibling().getFirstChild();

		System.out.println("Data : " + data.getNodeValue() + " type : "
				+ data.getNodeType());

        /*NodeList quantityNodeList = doc.getElementsByTagName("quantity");
        for (int i = 0; i < quantityNodeList.getLength(); i++) {
            Node qNode = quantityNodeList.item(i);
            System.out.println("Name : " + qNode.getNodeName() + " value : "
                    + qNode.getFirstChild().getNodeValue());
        }*/
    }
}
