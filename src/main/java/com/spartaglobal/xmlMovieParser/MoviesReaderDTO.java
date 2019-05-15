package com.spartaglobal.xmlMovieParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.print.Doc;

public class MoviesReaderDTO {

    private Document CurrentMoviesList;
    private NodeList AllRecords;

    public MoviesReaderDTO(String XMLMoviesDataFilePath) {
        XMLFileReader xmlFileReader = new XMLFileReader(XMLMoviesDataFilePath);
        CurrentMoviesList = xmlFileReader.getParsedXMLFile();

        setAllRecords();
    }

    // Handling all movie records in NodeList
    private void setAllRecords(){
         AllRecords = CurrentMoviesList.getElementsByTagName("record");
    }

    public NodeList getAllRecords() {
        return AllRecords;
    }

    // Accessor / action methods
    public int totalRecords(){
        return getAllRecords().getLength();
    }

    public void printAllMovieNames(){
        for (int i = 0; i < totalRecords(); i++) {
            Node node = getAllRecords().item(i);
            Element element = (Element) node;
            System.out.println(element.getElementsByTagName("movie_name").item(0).getTextContent());
        }
    }

}
