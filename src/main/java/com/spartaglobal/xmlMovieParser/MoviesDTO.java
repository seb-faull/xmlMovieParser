package com.spartaglobal.xmlMovieParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.print.Doc;

public class MoviesDTO {

    private Document MoviesList;

    public MoviesDTO(String XMLMoviesDataFilePath) {
        XMlFileReaderReader xMlFileReaderReader = new XMlFileReaderReader(XMLMoviesDataFilePath);
        MoviesList = xMlFileReaderReader.getParsedXMLFile();
    }

    private NodeList getAllRecords(){
        return MoviesList.getElementsByTagName("record");
    }

    public int totalRecords(){
        return getAllRecords().getLength();
    }

//     private Node returnElement(String elementName){
//         for (int i = 0; i < totalRecords(); i++) {
//             Node node = getAllRecords().item(i);
//             Element element = (Element) node;
//             System.out.println(element.getElementsByTagName("movie_name").item(0).getTextContent());
//         }
//     }

    public void printAllMovieNames(){
        for (int i = 0; i < totalRecords(); i++) {
            Node node = getAllRecords().item(i);
            Element element = (Element) node;
            System.out.println(element.getElementsByTagName("movie_name").item(0).getTextContent());
        }
    }


}
