package moviesNeo4J.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import moviesNeo4J.model.Person;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    Person findByName(String name);

    @Query("MATCH (m:Movie)<-[r:ACTED_IN]-(p:Person) where m.title = {t} RETURN p")
 	List<Person> findActedIn(@Param("t") String t);

}
