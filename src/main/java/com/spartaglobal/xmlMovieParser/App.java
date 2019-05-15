package com.spartaglobal.xmlMovieParser;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        // Read movie names
        MoviesReaderDTO moviesReader = new MoviesReaderDTO("resources/movies.xml");
        moviesReader.printAllMovieNames();
        System.out.println(moviesReader.totalRecords());

        // Write movies
        MovieWriter movieWriter = new MovieWriter("resources/movies.xml", "Finding Nemo", "Animation | Adventure | Comedy", "£2.99");
    }

}
