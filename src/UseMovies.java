import iteso.movies.Movie;


public class UseMovies {


	public static void main(String[] args) {
		Movie m1 = new Movie("Perfect Enemy","Kike Maillo",100,2020);
		m1.setGenre(Movie.PSYCHOLOGICAL_THRILLER);
		
		System.out.println(m1);
		
		Movie m2 = new Movie("El manual del hermano mayor","José Luis Elvira",17,2025);
		m2.setGenre(Movie.DRAMA);
		
		System.out.println(m2);
		
		Movie m3 = new Movie("The long walk");
		m3.setGenre(Movie.SUSPENSE);
		
		System.out.println(m3);
		m3.setDirector("Francis Lawrence");
		m3.setYear(2025);
		m3.setDuration(108);
		System.out.println(m3);
	}


}

