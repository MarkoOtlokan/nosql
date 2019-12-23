package moviesNeo4J;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("moviesNeo4J.repository")
public class PrimerNeo4JApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimerNeo4JApplication.class, args);
	}

}
