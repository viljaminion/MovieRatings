package s23.MovieRatings.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import s23.MovieRatings.MovieRatingsApplication;
import s23.MovieRatings.Luokat.CategoryRepository;
import s23.MovieRatings.Luokat.Movie;
import s23.MovieRatings.Luokat.MovieRepository;




@Controller
public class MovieController {
	
	private static final Logger log = LoggerFactory.getLogger(MovieRatingsApplication.class);

    @Autowired
    private MovieRepository repository;
    
    @Autowired
    private CategoryRepository crepository;
    
//Kirjautuminen
  
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }

//Uloskirjautuminen
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    
    
//Listanäkymä
    
    @RequestMapping(value = {"/", "/movielist"})
    public String movieList(Model model) {    
        model.addAttribute("movies", repository.findAll());
        return "movielist";
    }
    
//Elokuvan lisäys
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/add")
    public String addMovie(Model model) {
    	log.info("Adding a new movie..." + crepository.findAll());
        model.addAttribute("movie", new Movie());
        model.addAttribute("categories", crepository.findAll());
        return "addmovie";
    }
    
//Elokuvan tallennus repositorioon
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    public String saveMovie(@Valid @ModelAttribute Movie movie, BindingResult bindingResult, Model model) {
        log.info("Validation error occured - please check validation of movie: " + movie);
    	if (bindingResult.hasErrors()) {
    		log.info("Validation error occured, movie: " + movie);
        	model.addAttribute("addmovie", movie);
        	model.addAttribute("categories", crepository.findAll());
            return "addmovie";
        }
        {
            repository.save(movie);
            return "redirect:/movielist";
        }
    }



//Elokuvan poisto listalta
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/movielist";
    }

//Olemassaolevan elokuvan haku
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/edit/{id}")
    public String editMovieForm(@PathVariable("id") Long movieId, Model model) {
        
        Movie existingMovie = repository.findById(movieId).orElse(null);

        if (existingMovie != null) {
            model.addAttribute("movie", existingMovie);
            model.addAttribute("categories", crepository.findAll());
            return "editmovie";
        } else {
           
            return "error";
        }
    }
    
//Olemassaolevan elokuvan muokkaus
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/edit/{id}")
    public String updateMovie(@PathVariable("id") Long movieId, @Valid @ModelAttribute Movie updatedMovie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editmovie";
        } else {
            Movie existingMovie = repository.findById(movieId).orElse(null);

            if (existingMovie != null) {
                existingMovie.setName(updatedMovie.getName());
                existingMovie.setDirector(updatedMovie.getDirector());
                existingMovie.setPubyear(updatedMovie.getPubyear());
                existingMovie.setLength(updatedMovie.getLength());
                existingMovie.setRating(updatedMovie.getRating());

                repository.save(existingMovie);
            }

            return "redirect:/movielist";
        }
    }

}







