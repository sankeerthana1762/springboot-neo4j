package com.stackroute.neo4j.repository;

import com.stackroute.neo4j.model.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie,Long> {



    @Query("MATCH(m:Movie)<-[relation:ActedIn]-(b:Actor) RETURN m,relation,b")
    public Collection<Movie> graph();
    @Query("MATCH (m:Movie {title: {title}}) DETACH DELETE m")
    Movie delete(String title);

@Query("MATCH (m:Movie), (b:Actor) WHERE m.title = {title} AND b.name = {name} CREATE (b)-[r: ActedIn]->(m)")
    Movie relation(String title,String name);
@Query("MATCH (a:Actor {name:{name}})-[r:ActedIn]-(m:Movie {title:{title}}) DELETE r ")
    Movie removerelation(String title,String name);

}
