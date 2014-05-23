package com.udm.atp;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RSSParserHandler extends DefaultHandler{
	boolean firstItemFound = false;
    private List<RSSItem> messages;
    private RSSItem currentMessage;
    private StringBuilder builder;
    
    public List<RSSItem> getMessages(){
        return this.messages;
    }
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
        builder.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
        super.endElement(uri, localName, name);
        if (this.currentMessage != null && firstItemFound){
            if (localName.equalsIgnoreCase("title")){
                currentMessage.setTitle(builder.toString().trim());
            } else if (localName.equalsIgnoreCase("guid")){
                currentMessage.setGuid(builder.toString().trim());
            } else if (localName.equalsIgnoreCase("description")){
                currentMessage.setDescription(builder.toString().trim());
            } else if (localName.equalsIgnoreCase("pubdate")){
            	String temp = builder.toString().trim();
            	int end = temp.indexOf(':');
            	temp = temp.substring(0, end-3);
                currentMessage.setDate(temp);
            } else if (localName.equalsIgnoreCase("itunes:duration") || localName.equalsIgnoreCase("duration")){
                currentMessage.setDuration(builder.toString().trim());
            } else if (localName.equalsIgnoreCase("item")){
                messages.add(currentMessage);
            }    
        }
        builder.setLength(0);
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        messages = new ArrayList<RSSItem>();
        builder = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String name,
            Attributes attributes) throws SAXException {
        super.startElement(uri, localName, name, attributes);
        if (localName.equalsIgnoreCase("item")){
            this.currentMessage = new RSSItem();
            firstItemFound = true;
        }
    }
}
