package com.stackroute.neo4j.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Movie {

    @Id
    private int id;
    private String title;
    private String genre;
//    @JsonIgnoreProperties("movie")
    @Relationship(type = "ActedIn")
    private List<Actor> actors;
//    @Relationship(type = "ACTED_IN" , direction = Relationship.INCOMING)
//    private List<Actress> actresses = new ArrayList<>();


    public Movie() {
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Movie(int id, String title, String genre, List<Actor> actors) {
        this.id = id;
        this.title = title;
       this.genre=genre;
       this.actors=actors;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre=genre;
    }


}
