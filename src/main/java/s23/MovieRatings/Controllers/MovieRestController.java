package s23.MovieRatings.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import s23.MovieRatings.Luokat.Movie;
import s23.MovieRatings.Luokat.MovieRepository;


@RestController
public class MovieRestController {
	
	@Autowired
    private MovieRepository repository;
	
	//Kaikki tiedot JSON-muodossa
	
	@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/movies", method = RequestMethod.GET)
    public List<Movie> MovieListRest() {	
        return (List<Movie>) repository.findAll();
    }    

	//ID:n avulla haettavat tiedot tietystä elokuvasta
	
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/movie/{id}", method = RequestMethod.GET)
    
    public Optional<Movie> findMovieRest(@PathVariable("id") Long movieId) {	
    	return repository.findById(movieId);
    }
    
    //Elokuvan lisääminen 
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping (value= "/movie", method = RequestMethod.POST)
    
        public Movie addMovie(@RequestBody Movie movie) {
            return repository.save(movie);
            
}
    
    //Elokuvan poisto ID:llä
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE)
    
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long movieId) {
        Optional<Movie> movie = repository.findById(movieId);
        if (movie.isPresent()) {
            repository.deleteById(movieId);
            return new ResponseEntity<>("Movie with ID " + movieId + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Movie with ID " + movieId + " not found.", HttpStatus.NOT_FOUND);
        }
    }
    
}
