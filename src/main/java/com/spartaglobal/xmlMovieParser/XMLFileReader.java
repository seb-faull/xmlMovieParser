package com.spartaglobal.xmlMovieParser;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XMLFileReader {

    private Document parsedXMLFile;

    public XMLFileReader(String xmlFilePath) {
        try {
            DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder xmlBuilder = xmlFactory.newDocumentBuilder();
            parsedXMLFile = xmlBuilder.parse(xmlFilePath);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    public Document getParsedXMLFile() {
        return parsedXMLFile;
    }

}
