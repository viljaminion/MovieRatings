package s23.MovieRatings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import s23.MovieRatings.Luokat.Category;
import s23.MovieRatings.Luokat.CategoryRepository;
import s23.MovieRatings.Luokat.Movie;
import s23.MovieRatings.Luokat.MovieRepository;
import s23.MovieRatings.Luokat.User;
import s23.MovieRatings.Luokat.UserRepository;

@SpringBootApplication
public class MovieRatingsApplication {
	private static final Logger log = LoggerFactory.getLogger(MovieRatingsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MovieRatingsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner categoryDemo(MovieRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("Categories");
			crepository.save(new Category("Action"));
			crepository.save(new Category("Adventure"));
			crepository.save(new Category("Animation"));
			crepository.save(new Category("Comedy"));
			crepository.save(new Category("Crime and mystery"));
			crepository.save(new Category("Drama"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Historical"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Romance"));
			crepository.save(new Category("Satire"));
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Thriller"));
			crepository.save(new Category("Western"));
			crepository.save(new Category("Other"));
			
	//name,director,year,length,rating
			
			repository.save(new Movie("Ace Ventura: Pet Detective", "Tom Shadyac", 1994, 86, 59, crepository.findByName("Comedy").get(0)));
			repository.save(new Movie("Ace Ventura: When Nature Calls", "Steve Oedekerk", 1995, 94, 72, crepository.findByName("Comedy").get(0)));
			repository.save(new Movie("Alien vs. Predator", "Paul W.S. Anderson", 2004, 101, 66, crepository.findByName("Scifi").get(0)));
			repository.save(new Movie("Alien vs. Predator: Requiem", "The Brothers Strause", 2007, 94, 12, crepository.findByName("Scifi").get(0)));
			repository.save(new Movie("Barbie", "Greta Gerwig", 2023, 78, 67, crepository.findByName("Comedy").get(0)));
			repository.save(new Movie("Braveheart", "Mel Gibson", 1995, 178, 78, crepository.findByName("Historical").get(0)));
			repository.save(new Movie("Creepshow", "George A. Romero", 1982, 120, 68, crepository.findByName("Horror").get(0)));
			repository.save(new Movie("Escape from Alcatraz", "Don Siegel", 1979, 112, 75, crepository.findByName("Drama").get(0)));
			repository.save(new Movie("Forrest Gump", "Robert Zemeckis", 1994, 142, 83, crepository.findByName("Drama").get(0)));
			repository.save(new Movie("Gladiator", "Ridley Scott", 2000, 155, 85, crepository.findByName("Action").get(0)));
			repository.save(new Movie("Harold & Kumar Escape from Guantanamo Bay", "Jon Hurwitz, Hayden Schlossberg", 2008, 104, 62, crepository.findByName("Comedy").get(0)));
			repository.save(new Movie("Harold & Kumar Go to White Castle", "Danny Leiner", 2004, 88, 79, crepository.findByName("Comedy").get(0)));
			repository.save(new Movie("House of Wax", "Jaume Collet-Serra", 2005, 113, 70, crepository.findByName("Horror").get(0)));
			repository.save(new Movie("Inception", "Christopher Nolan", 2010, 148, 88, crepository.findByName("Scifi").get(0)));
			repository.save(new Movie("Indiana Jones and the Kingdom of the Crystal Skull", "Steven Spielberg", 2008, 122, 54, crepository.findByName("Adventure").get(0)));
			repository.save(new Movie("Indiana Jones and the Last Crusade", "Steven Spielberg", 1989, 127, 81, crepository.findByName("Adventure").get(0)));
			repository.save(new Movie("Indiana Jones and the Temple of Doom", "Steven Spielberg", 1984, 118, 77, crepository.findByName("Adventure").get(0)));
			repository.save(new Movie("It", "Andy Muschietti", 2017, 135, 85, crepository.findByName("Horror").get(0)));
			repository.save(new Movie("It Chapter Two", "Andy Muschietti", 2019, 169, 78, crepository.findByName("Horror").get(0)));
			repository.save(new Movie("Jaws", "Steven Spielberg", 1975, 124, 90, crepository.findByName("Thriller").get(0)));
			repository.save(new Movie("Jaws 2", "Jeannot Szwarc", 1978, 116, 69, crepository.findByName("Thriller").get(0)));
			repository.save(new Movie("Jaws 3-D", "Joe Alves", 1983, 99, 43, crepository.findByName("Thriller").get(0)));
			repository.save(new Movie("Jaws: The Revenge", "Joseph Sargent", 1987, 89, 9, crepository.findByName("Thriller").get(0)));
			repository.save(new Movie("Kadaver", "Jarand Herdal", 2020, 86, 79, crepository.findByName("Crime and mystery").get(0)));
			repository.save(new Movie("Ocean's Eleven", "Steven Soderbergh", 2001, 116, 82, crepository.findByName("Crime and mystery").get(0)));
			repository.save(new Movie("Pan's Labyrinth", "Guillermo del Toro", 2006, 118, 95, crepository.findByName("Fantasy").get(0)));
			repository.save(new Movie("Poltergeist", "Tobe Hooper", 1982, 114, 76, crepository.findByName("Horror").get(0)));
			repository.save(new Movie("Prisoners", "Denis Villeneuve", 2013, 153, 55, crepository.findByName("Thriller").get(0)));
			repository.save(new Movie("Raiders of the Lost Ark", "Steven Spielberg", 1981, 115, 85, crepository.findByName("Adventure").get(0)));
			repository.save(new Movie("Saw", "James Wan", 2004, 103, 91, crepository.findByName("Horror").get(0)));
			repository.save(new Movie("Saw II", "Darren Lynn Bousman", 2005, 93, 83, crepository.findByName("Horror").get(0)));
			repository.save(new Movie("Saw III", "Darren Lynn Bousman", 2006, 108, 39, crepository.findByName("Horror").get(0)));
			repository.save(new Movie("Saw IV", "Darren Lynn Bousman", 2007, 93, 60, crepository.findByName("Horror").get(0)));
			repository.save(new Movie("Saw V", "David Hackl", 2008, 92, 13, crepository.findByName("Horror").get(0)));
			repository.save(new Movie("Saw 3D: The Final Chapter", "Kevin Greutert", 2010, 90, 34, crepository.findByName("Horror").get(0)));
			repository.save(new Movie("Saw VI", "Kevin Greutert", 2009, 90, 39, crepository.findByName("Horror").get(0)));
			repository.save(new Movie("Saw X", "Darren Lynn Bousman", 2023, 118, 88, crepository.findByName("Horror").get(0)));
			repository.save(new Movie("Schindler's List", "Steven Spielberg", 1993, 195, 93, crepository.findByName("Historical").get(0)));
			repository.save(new Movie("Se7en", "David Fincher", 1995, 127, 81, crepository.findByName("Thriller").get(0)));
			repository.save(new Movie("Spirited Away", "Hayao Miyazaki", 2001, 125, 97, crepository.findByName("Fantasy").get(0)));
			repository.save(new Movie("Star Wars: Episode IV - A New Hope", "George Lucas", 1977, 121, 89, crepository.findByName("Scifi").get(0)));
			repository.save(new Movie("The Black Cauldron", "Ted Berman, Richard Rich", 1985, 80, 99, crepository.findByName("Animation").get(0)));
			repository.save(new Movie("The Dark Knight", "Christopher Nolan", 2008, 152, 90, crepository.findByName("Action").get(0)));
			repository.save(new Movie("The Godfather", "Francis Ford Coppola", 1972, 175, 91, crepository.findByName("Crime and mystery").get(0)));
			repository.save(new Movie("The Good, the Bad and the Ugly", "Sergio Leone", 1966, 178, 43, crepository.findByName("Western").get(0)));
			repository.save(new Movie("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", 2001, 178, 91, crepository.findByName("Fantasy").get(0)));
			repository.save(new Movie("The Matrix", "The Wachowskis", 1999, 136, 88, crepository.findByName("Scifi").get(0)));
			repository.save(new Movie("The Nun", "Corin Hardy", 2018, 96, 79, crepository.findByName("Horror").get(0)));
			repository.save(new Movie("The Nun II", "Michael Chaves", 2023, 110, 74, crepository.findByName("Horror").get(0)));
			repository.save(new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 142, 95, crepository.findByName("Drama").get(0)));
			repository.save(new Movie("The Silence of the Lambs", "Jonathan Demme", 1991, 118, 85, crepository.findByName("Thriller").get(0)));
			repository.save(new Movie("Titanic", "James Cameron", 1997, 195, 84, crepository.findByName("Drama").get(0)));
			repository.save(new Movie("Treasure Planet", "Ron Clements, John Musker", 2002, 95, 70, crepository.findByName("Animation").get(0)));
			repository.save(new Movie("Twilight", "Catherine Hardwicke", 2008, 122, 48, crepository.findByName("Romance").get(0)));
			repository.save(new Movie("Wallace and Gromit: The Curse of the Were-Rabbit", "Nick Park, Steve Box", 2005, 85, 90, crepository.findByName("Animation").get(0)));

			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			
			
			log.info("Movies");
			for (Movie movie : repository.findAll()) {
				log.info(movie.toString());
			};
		};
}
}
