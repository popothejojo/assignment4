import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Movies {

	public static void main(String[] args) throws FileNotFoundException {

		HashMap<Integer, Movie> movieMap = new HashMap<>();

		Scanner sc = new Scanner(new File("movies.csv"), "UTF-8");
		while (sc.hasNextLine()) {
			String line = sc.nextLine();							////PARSING THE WHOLE CSV
			String[] splitline = line.split(",");

			int MovieID = Integer.parseInt(splitline[0]);			//MOVIE ID
			String movieTitle = splitline[1];						//MOVIE TITLE
			String year = splitline[1].substring(splitline[1].indexOf('(') + 1, splitline[1].indexOf('(') + 5);  //MOVIE YEAR

			ArrayList<String> genres = parseGenres(splitline[2]);

			Movie movie = new Movie(movieTitle, year, genres);
			movieMap.put(MovieID, movie);
			
		}
		countGenres(movieMap);
	}

	public static ArrayList<String> parseGenres(String genreList) {  /////BREAKING GENRES UP IN TO PARTS

		ArrayList<String> genreArray = new ArrayList<>();

		String[] movieGenre = genreList.split("/");
		for (int i = 0; i < movieGenre.length; i++)
			genreArray.add(movieGenre[i]);

		return genreArray;
	}
	public static void countGenres(HashMap<Integer, Movie> movieMap) { /////COUNTING GENRES IN CSV
		int adventureCount = 0,actionCount = 0,comedyCount =0;
		
		ArrayList<String> genres = movieMap.get(1).getGenres();
		
		for(int i = 0;i<genres.size();i++) {
			if(genres.get(i).equals("Adventure"));
			adventureCount++;
			if(genres.get(i).equals("Action"));
			actionCount++;
			if(genres.get(i).equals("Comedy"));
			comedyCount++;	
		}
		System.out.println("Comedies: " + comedyCount + " Actions: "+ actionCount + " Adventures " + adventureCount);
	}
}
