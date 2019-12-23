package moviesNeo4J.model;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Actor {
	
	@Id 
	@GeneratedValue
	private long id;
	private int born;
	private String name;
	
	@Relationship(type = "ACTED_IN")
	private List<Movie> movies = new ArrayList<>();

	public Actor() {
	}

	public Actor(String name, int born) {
		this.name = name;
		this.born = born;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBorn() {
		return born;
	}

	public List<Movie> getMovies() {
		return movies;
}
}
