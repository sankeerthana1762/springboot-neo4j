package com.stackroute.neo4j.service;

import com.stackroute.neo4j.model.Movie;
import com.stackroute.neo4j.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {
    private  MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> getAllMovies() {
        System.out.printf("service");
        return movieRepository.graph();
    }

    public Movie savemovie(Movie movie)
    {
        return movieRepository.save(movie);
    }

    public void deletemovie(String title)
    {
        movieRepository.delete(title);
    }
    public Movie update(Movie movie) {
        return movieRepository.save(movie);
    }
    public void getrelation(String title,String name)
    {
        System.out.printf("service");
        movieRepository.relation(title,name);
    }
    public void deleterelation(String title,String name)
    {
        movieRepository.removerelation(title,name);
    }

}





