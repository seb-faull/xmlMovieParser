package com.spartaglobal.xmlMovieParser;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class XMLFileWriter {

    private Document NewMoviesList;
    private Document parsedXMLFile;

    public XMLFileWriter(String xmlFilePath) {
        try {
            XMLFileReader xMlFileReaderReader = new XMLFileReader(xmlFilePath);
            NewMoviesList = xMlFileReaderReader.getParsedXMLFile();

            Element moviesTag =  (Element) NewMoviesList.getElementsByTagName("movies").item(0);

            Element newRecord = NewMoviesList.createElement("record");

            Element movieName = NewMoviesList.createElement("movie_name");
            movieName.setTextContent("Pulp Fiction");

            Element movieGenre = NewMoviesList.createElement("movie_genre");
            movieGenre.setTextContent("Dark Comedy");

            newRecord.appendChild(movieName);
            newRecord.appendChild(movieGenre);

            moviesTag.appendChild(newRecord);

            TransformerFactory tfact = TransformerFactory.newInstance();
            Transformer tform = tfact.newTransformer();
            tform.setOutputProperty(OutputKeys.INDENT, "yes");
            tform.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");

            // Generate the XML output is to apply the transformation. The result appears on the output stream, System.out.
            // tform.transform(new DOMSource(NewMoviesList), new StreamResult(System.out));

            // To write the output directly to a file, use the following.
            tform.transform(new DOMSource(NewMoviesList), new StreamResult(new File("resources/movies_new.xml")));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public Document getParsedXMLFile() {
        return NewMoviesList;
    }

}
