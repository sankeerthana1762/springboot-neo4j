package com.stackroute.neo4j.controller;

import com.stackroute.neo4j.model.Movie;
import com.stackroute.neo4j.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/neo4j/Movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/graph")
    public Collection<Movie> graph() {
        System.out.printf("controller");
        return movieService.getAllMovies();
    }
    @PostMapping("/graph")
    public Movie addMovie(@RequestBody Movie movie)
    {
        return movieService.savemovie(movie);
    }
//    @GetMapping("/graph/{name}")
//    public Movie getmovienyname(@PathVariable String title)
//    {
//        return movieService.findByName(title);
//    }
    @DeleteMapping("/graph/{title}")
    public void deleteMovie(@PathVariable String title)
    {
         movieService.deletemovie(title);
    }

    @PutMapping("/graph")
    public Movie updateMovie(@RequestBody Movie movie){
        return   movieService.update(movie);
    }
    @PostMapping("/graph/{title}/{name}")
    public void createrelation(@PathVariable String title,@PathVariable String name)
    {
        System.out.printf("controller");
        movieService.getrelation(title,name);
    }
    @DeleteMapping("/graph/{title}/{name}")
    public void deleterelation(@PathVariable String title,@PathVariable String name)
    {
        movieService.deleterelation(title,name);
    }

}
