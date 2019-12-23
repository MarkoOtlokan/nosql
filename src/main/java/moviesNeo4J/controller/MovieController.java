package moviesNeo4J.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import moviesNeo4J.model.Movie;
import moviesNeo4J.model.Person;
import moviesNeo4J.model.Role;
import moviesNeo4J.repository.MovieRepository;
import moviesNeo4J.repository.PersonRepository;
import moviesNeo4J.repository.RoleRepository;

@RestController
@RequestMapping(value="/movies")
public class MovieController {

	@Autowired
	MovieRepository mr;
	
	@Autowired
	PersonRepository pr;
	
	@Autowired
	RoleRepository rr;
	
	@RequestMapping(value="/saveMovie", method=RequestMethod.POST)
	public Movie saveMovie(@RequestBody Movie m) {
		Movie movie = mr.save(m);
		return movie;
	}
	
	@RequestMapping(value="/savePerson", method=RequestMethod.POST)
	public Person savePerson(@RequestBody Person p) {
		Person person = pr.save(p);
		return person;
	}
	
	@RequestMapping(value="/saveRole", method=RequestMethod.POST)
	public Role saveRole(String title, String name, String role) throws JsonProcessingException {
		Movie m = mr.findByTitle(title);
		Person p = pr.findByName(name);
	
		Role r = new Role(m, p);
        r.addRoleName(role);
		ObjectMapper om = new ObjectMapper();
		System.out.println(om.writeValueAsString(r));
		rr.save(r);
		return r;
	}
	
	@RequestMapping(value="/findByTitle", method=RequestMethod.GET)
	public Movie findByTitle(String title) {
		Movie movie = mr.findByTitle(title);
		return movie;
	}
	
	@RequestMapping(value="/findById", method=RequestMethod.GET)
	public Movie findById(Long id) {
		Movie movie = mr.findById(id).get();
		return movie;
	}
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public List<Movie> findAll() {
		List<Movie> movies = mr.findAll();
		System.out.println("Number of movies: "+movies.size());
		return movies;
	}
	
	@RequestMapping(value="/findActors", method=RequestMethod.GET)
	public List<Person> findActors(String movie) {
		List<Person> p = pr.findActedIn(movie);
		System.out.println("Number of actors for movie: "+p.size());
		return p;
	}
	
	@RequestMapping(value="/showGraph", method=RequestMethod.GET)
	public Collection<Movie> showGraph(int limit) {
		Collection<Movie> g = mr.graph(limit);
		return g;
	}
	
	@RequestMapping(value="/updateMovie", method=RequestMethod.GET)
	public Movie updateMovie(String movieT, int released) {
		Movie m = mr.findByTitle(movieT);
		m.setReleased(released);
		Movie mov = mr.save(m);
		return mov;
	}
	
	@RequestMapping(value="/deleteMovie", method=RequestMethod.POST)
	public void deleteMovie(long id) {
		mr.deleteById(id);
	}
	
	@RequestMapping(value="/saGlumcem", method=RequestMethod.GET)
	public Collection<Movie> saGlumcem(String name){
		return mr.saGlumcem(name);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
