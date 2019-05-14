package com.spartaglobal.xmlMovieParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MoviesDTO movies = new MoviesDTO("resources/movies.xml");

        // Read movie names
        movies.printAllMovieNames();

        // Write movie names
        movies.writeMoreMovieNames();

        System.out.println(movies.totalRecords());

        // Read movie names again
    }
}
