package Fechas;


public class Date {
	private int year=1970;
	private int month=1;
	private int day=1;
	
	public static final int JANUARY = 1;
	public static final int FEBRUARY = 2;
	public static final int MARCH = 3;
	public static final int APRIL = 4;
	public static final int MAY = 5;
	public static final int JUNE = 6;
	public static final int JULY = 7;
	public static final int AUGUST = 8;
	public static final int SEPTEMBER = 9;
	public static final int OCTOBER = 10;
	public static final int NOVEMBER = 11;
	public static final int DECEMBER = 12;
	
	public static final int SUNDAY = 0;
	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;
	
	public final int FIRST_YEAR;
	public final int FIRST_MONTH;
	public final int FIRST_DAY;
	
	
	// Constructores
	public Date() {
		FIRST_YEAR = year;
		FIRST_MONTH = month;
		FIRST_DAY = day;
	}
	
	public Date(int year,int month,int day) {
		setYear(year);
		setMonth(month);
		setDay(day);
		FIRST_YEAR = this.year;
		FIRST_MONTH = this.month;
		FIRST_DAY = this.day;
	}
	
	// Setters
	public void setYear(int year) {
		if(year>=0 && year<=9999)
			this.year = year;
	}
	
	public void setMonth(int month) {
		if(month>=1 && month<=12)
			this.month = month;
	}
	
	public void setDay(int day) {
		if(day>=1 && day<=31)
			this.day = day;
	}
	
	
	// Getters
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	//
	
	public boolean isLeap() {
		return year%4==0 && year%100!=0 || year%400==0;
	}
	
	private int daysPerMonth() {		
		if(month==JANUARY || month==MARCH || month==MAY || month==JULY || month == AUGUST || month == OCTOBER || month == DECEMBER)
			return 31;
		else if(month==APRIL || month==JUNE || month==SEPTEMBER || month==NOVEMBER)
			return 30;
		else if(month==FEBRUARY && isLeap())
			return 29;
		else if(month==FEBRUARY && !isLeap())
			return 28;
		else
			return 0;
	}
	
	public boolean isValid() {
		return day<=daysPerMonth();
	}
	
	public String toString() {
		return "Date:{\n"+
				"\t\"year\":"+year+",\n"+
				"\t\"month\":"+month+",\n"+
				"\t\"day\":"+day+",\n"+
				"\t\"FIRST_DATE\":"+String.format("\"%02d/%02d/%04d\"\n",FIRST_DAY,FIRST_MONTH,FIRST_YEAR)+
				"}\n";
	}
}
