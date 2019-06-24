package com.jax.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public class QuantityTotalHandler extends DefaultHandler {
    private String elementName = null;
    private long totalQuantity = 0;
    Map<String, Long> itemsQuantityMap = new HashMap<>();
    private String recentItem = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementName = null;
        if(qName.equals("quantity")){
            recentItem = null;
        }
    }

    /*@Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = null;
        System.out.println("@!!!!! :::: "+elementName);
        if(elementName!= null  && elementName.equals("quantity")){
            System.out.println("@@@@@ DONE @@@@@@@@@");
         data = new String(ch, start, length);
         totalQuantity = totalQuantity + Integer.parseInt(data);
        }
    }*/

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = null;
        if(elementName != null && "itemCode".equals(elementName)) {
            data = new String(ch, start, length);
            recentItem = data;
            if (itemsQuantityMap.get(data) == null) {
                itemsQuantityMap.put(data, 0l);
            }
        }
        if(elementName!= null  && elementName.equals("quantity")){
            long count = itemsQuantityMap.get(recentItem);
            data = new String(ch, start, length);
            count = count + Integer.parseInt(data);
            itemsQuantityMap.put(recentItem, count);
        }

    }

    public long getTotalQuantity() {
        return totalQuantity;
    }

    public Map<String, Long> getItemsQuantityMap() {
        return itemsQuantityMap;
    }
}
