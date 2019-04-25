package com.spartaglobal.xmlMovieParser;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class XMlFileReaderReader {

    private Document parsedXMLFile;

    public XMlFileReaderReader(String xmlFilePath) {
        try {
        File xmlFile = new File(xmlFilePath);
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
