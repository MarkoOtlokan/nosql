package moviesNeo4J.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import moviesNeo4J.model.Role;

public interface RoleRepository extends Neo4jRepository<Role, Long> {

}
