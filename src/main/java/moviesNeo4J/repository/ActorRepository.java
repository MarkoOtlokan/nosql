package moviesNeo4J.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import moviesNeo4J.model.Actor;

public interface ActorRepository extends Neo4jRepository<Actor, Long>{
	List<Actor> findByName(String name);
}
