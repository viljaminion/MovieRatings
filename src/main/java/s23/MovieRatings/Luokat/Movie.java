package s23.MovieRatings.Luokat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;



@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size (min=1, max=75, message = "Name must be between 1 and 75 digits")
	private String name;
	
	@Size (min=1, max=75, message = "Director must be between 1 and 75 digits")
	private String director;
	
	@Min (value = 1800, message = "Please put the publication year correctly (1800-3000)")
	@Max (value = 3000, message = "Please put the publication year correctly (1800-3000")
	private int pubyear;
	
	@Min (value = 1, message = "Please put the length correctly (1-1000)")
	@Max (value = 1000, message = "Please put the length correctly (1-1000")
	private int length;
	
	@Min(value = 0, message = "Rating must be at least 0")
    @Max(value = 100, message = "The best rating you can give is 100, please don't get too excited")
	private int rating;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Movie(String name, String director, int pubyear, int length, int rating, Category category) {
		super();
		this.name = name;
		this.director = director;
		this.pubyear = pubyear;
		this.length = length;
		this.rating = rating;
		this.category = category;
	}
	
	public Movie () {}
	
	public Movie(Long id) {
		super();
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getPubyear() {
		return pubyear;
	}
	public void setPubyear(int pubyear) {
		this.pubyear = pubyear;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	

	@Override
	public String toString() {
		
		if (this.category != null)
			return "Movie [id=" + id + ", name=" + name + ", director=" + director + ", pubyear=" + pubyear + ", length=" + length
				+ ", rating=" + rating + ", category=" + category +"]";
		else
			return "Movie [id=" + id + ", name=" + name + ", director=" + director + ", pubyear=" + pubyear + ", length=" + length
					+ ", rating=" + rating + "]";
			
	}
	


}
		
