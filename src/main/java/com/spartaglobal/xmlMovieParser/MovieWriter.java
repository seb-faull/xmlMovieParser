package com.spartaglobal.xmlMovieParser;

import org.w3c.dom.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class MovieWriter {

    private Document NewMoviesList;

    public MovieWriter(String xmlFilePath, String elMovieName, String elMovieGenre, String elCost) {
        try {
            XMLFileReader xMlFileReaderReader = new XMLFileReader(xmlFilePath);
            NewMoviesList = xMlFileReaderReader.getParsedXMLFile();

            Element moviesTag =  (Element) NewMoviesList.getElementsByTagName("movies").item(0);

            Element newRecord = NewMoviesList.createElement("record");

            Element movieName = NewMoviesList.createElement("movie_name");
            movieName.setTextContent(elMovieName);

            Element movieGenre = NewMoviesList.createElement("movie_genre");
            movieGenre.setTextContent(elMovieGenre);

            Element cost = NewMoviesList.createElement("cost");
            cost.setTextContent(elCost);

            newRecord.appendChild(movieName);
            newRecord.appendChild(movieGenre);
            newRecord.appendChild(cost);

            moviesTag.appendChild(newRecord);

            TransformerFactory tfact = TransformerFactory.newInstance();
            Transformer tform = tfact.newTransformer();
            tform.setOutputProperty(OutputKeys.INDENT, "yes");
            tform.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");

            // Generate the XML output to apply the transformation. The result appears on the output stream, System.out.
            //tform.transform(new DOMSource(NewMoviesList), new StreamResult(System.out));

            // Remove generated empty lines from XML file
            XPath xp = XPathFactory.newInstance().newXPath();
            NodeList nl = (NodeList) xp.evaluate("//text()[normalize-space(.)='']", NewMoviesList, XPathConstants.NODESET);
            
            for (int i=0; i < nl.getLength(); ++i) {
                Node node = nl.item(i);
                node.getParentNode().removeChild(node);
            }

            // To write the output directly to a file, use the following.
            tform.transform(new DOMSource(NewMoviesList), new StreamResult(new File("resources/movies_new.xml")));
        } catch (TransformerException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }

    public Document getParsedXMLFile() {
        return NewMoviesList;
    }

}
