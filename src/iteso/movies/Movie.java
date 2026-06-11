package iteso.movies;


public class Movie {
	private static int instancesCount = 0;
	public final int movieNum;
	public final String TITLE;
	private int genre = NON_ASIGNED;
	private String director="unassigned";
	private int duration=0;
	private int year = 0;
	private double aspectRelX = 1.77;
	private double aspectRelY = 1.0;
	
	public static final int NON_ASIGNED = 0;
	public static final int DRAMA = 1;
	public static final int PSYCHOLOGICAL_THRILLER = 2;
	public static final int COMEDY = 3;
	public static final int SUSPENSE = 4;
	public static final int TERROR = 5;
	
	
	public Movie(String title) {
		movieNum = instancesCount;
		instancesCount++;
		TITLE = title;
	}
	
	public Movie(String title,String director) {
		movieNum = instancesCount;
		instancesCount++;
		TITLE = title;
		setDirector(director);
	}
	
	public Movie(String title,String director,int duration) {
		movieNum = instancesCount;
		instancesCount++;
		TITLE = title;
		setDirector(director);
		setDuration(duration);
	}


	public Movie(String title,String director,int duration,int year) {
		movieNum = instancesCount;
		instancesCount++;
		TITLE = title;
		setDirector(director);
		setDuration(duration);
		setYear(year);
	}
	
	// Setters 


	public void setGenre(int genre) {
		if(genre>0 && genre<6)
			this.genre = genre;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public void setDuration(int duration) {
		if(duration>0 && duration<240)
			this.duration = duration;
	}
	
	public void setYear(int year) {
		if(year>=1900 && year<=2026)
			this.year = year;
	}
	
	public void setAspectRelation(double aspectRelX,double aspectRelY) {
		if(aspectRelX == 4.0 && aspectRelY == 3.0 ||
		   aspectRelX == 16.0 && aspectRelY == 9.0 ||
		   aspectRelX == 2.0 && aspectRelY == 1.0 ||
		   aspectRelX == 2.35 && aspectRelY == 1.0) {
			this.aspectRelX = aspectRelX / aspectRelY;
			this.aspectRelY = 1;
		}
	}
	
	// Getters
	public double getAspectRelX() {
		return aspectRelX;
	}
	
	public double getAspectRelY() {
		return aspectRelY;
	}
	
	public String getGenre() {
		String retValue = "Invalid";
		switch(genre) {
			case 0:
				retValue = "Non Assigned";
				break;
			case 1:
				retValue = "Drama";
				break;
			case 2:
				retValue = "Psychological Thriller";
				break;
			case 3:
				retValue = "Comedy";
				break;
			case 4:
				retValue = "Suspense";
				break;
			case 5:
				retValue = "Terror";
		}
		return retValue;
	}
	
	public String toString() {
		return "Movie:{\n"+
			"\t\"movieNum\":"+movieNum+",\n"+
			"\t\"TITLE\":\""+TITLE+"\",\n"+
			"\t\"genre\":\""+getGenre()+"\",\n"+
			"\t\"director\":\""+director+"\",\n"+
			"\t\"year\":"+year+",\n"+
			"\t\"duration\":"+duration+"\n"+
			"}";
	}




}
