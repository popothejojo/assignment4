import java.util.*;
public class Movie {
	
	private String title;
	private String year;
	private ArrayList<String> genres;

	public Movie(String title, String year, ArrayList<String> genres) {
		this.title = title;
		this.year = year;
		this.genres = genres;	
	}
	public String getYear() {
		return year;
	}
	public String getTitle() {
		return title;
	}
	public ArrayList getGenres() {
		return genres;
	}
}
