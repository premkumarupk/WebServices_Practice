package com.jax.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PrintHandler extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("START DOCUMENT");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("END DOCUMENT");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("<" + localName + ">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("</" + localName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = null;

        data = new String(ch, start, length);
        System.out.print(data);

    }
}
