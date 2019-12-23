package moviesNeo4J.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import moviesNeo4J.model.Movie;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {

	Movie findByTitle(@Param("title") String title);

	Collection<Movie> findByTitleLike(@Param("title") String title);

    @Query("MATCH (m:Movie)<-[r:ACTED_IN]-(a:Person) RETURN m,r,a LIMIT {limit}")
	Collection<Movie> graph(@Param("limit") int limit);
    
    
    @Query("MATCH (m:Movie) <- [r:ACTED_IN]-(p:Person) where p.name = {name} return m,p")
    Collection<Movie> saGlumcem(@Param("name") String name);
    
    List<Movie> findAll();
}
