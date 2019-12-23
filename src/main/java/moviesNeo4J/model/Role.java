package moviesNeo4J.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "ACTED_IN")
public class Role {

    @Id
    @GeneratedValue
	private Long id;
	private List<String> roles = new ArrayList<>();	
	//private String[] roles;

	
	@StartNode
	private Person Person;

	@EndNode
	private Movie movie;//	public List<String> getRoles() {
//    return roles;
//}

	public Role() {
	}

	public Role(Movie movie, Person Person) {
		this.movie = movie;
		this.Person = Person;
	}

	public Long getId() {
	    return id;
	}

	public List<String> getRoles() {
	    return roles;
	}

	/*public String[] getRoles() {
	    return roles;
	}
	public void setRoles(String[] roles) {
		this.roles=roles;
	}*/

	public Person getPerson() {
	    return Person;
	}

	public Movie getMovie() {
	    return movie;
	}
	
	public void setMovie(Movie m) {
		this.movie=m;
	}
	
	public void setPerson(Person a) {
		this.Person = a;
	}

   public void addRoleName(String name) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
       this.roles.add(name);
    }


    
    
	
//	public void setRoles(String[] role) {
//		this.roles=role;
//	}
}
