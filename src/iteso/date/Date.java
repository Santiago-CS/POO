package iteso.date;

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
		java.util.Calendar c = java.util.Calendar.getInstance();
		this.year = c.get(java.util.Calendar.YEAR);
		this.month = c.get(java.util.Calendar.MONTH) + 1;
		this.day = c.get(java.util.Calendar.DAY_OF_MONTH);
		
		FIRST_YEAR = this.year;
		FIRST_MONTH = this.month;
		FIRST_DAY = this.day;
	}
	
	public Date(int year,int month,int day) {
		setDate(year,month,day);
		FIRST_YEAR = this.year;
		FIRST_MONTH = this.month;
		FIRST_DAY = this.day;
	}
	
	// ==========================================
	// SETTERS MODIFICADOS PARA LANZAR EXCEPCIÓN
	// ==========================================
	
	public void setDate(int year,int month,int day) {
		if(!isValid(year, month, day)) {
			// Lanza el error usando tu nueva clase
			throw new InvalidDateException("Fecha inválida o fuera de rango: " + day + "/" + month + "/" + year);
		}
		// Si es válida, asigna los valores
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public void setYear(int year) {
		if(year < 0 || year > 9999 || !isValid(year, this.month, this.day)) {
			throw new InvalidDateException("El año " + year + " no es válido para la fecha actual.");
		}
		this.year = year;
	}
	
	public void setMonth(int month) {
		if(!isValid(this.year, month, this.day)) {
			throw new InvalidDateException("El mes " + month + " no es válido para la fecha actual.");
		}
		this.month = month;
	}
	
	public void setDay(int day) {
		if(!isValid(this.year, this.month, day)) {
			throw new InvalidDateException("El día " + day + " no es válido para la fecha actual.");
		}
		this.day = day;
	}
	
	
	// ==========================================
	// GETTERS Y DEMÁS MÉTODOS (Se quedan igual)
	// ==========================================
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public static boolean isLeap(int year) {
		return year%4==0 && year%100!=0 || year%400==0;
	}
	
	public boolean isLeap() {
		return isLeap(year);
	}

	public static int daysPerMonth(int year,int month) {
		int daysPerMonth = 0;
		if(month==JANUARY || month==MARCH || month==MAY || month==JULY || month == AUGUST || month == OCTOBER || month == DECEMBER)
			daysPerMonth = 31;
		else if(month==APRIL || month==JUNE || month==SEPTEMBER || month==NOVEMBER)
			daysPerMonth = 30;
		else if(month==FEBRUARY && isLeap(year))
			daysPerMonth = 29;
		else if(month==FEBRUARY && !isLeap(year))
			daysPerMonth = 28;
		return daysPerMonth;
	}
	
	public static boolean isValid(int year,int month,int day) {
		return day>0 && day<=daysPerMonth(year,month);
	}
	
	public boolean isValid() {
		return isValid(year,month,day);
	}
	
	public static int getDow(int year,int month,int day) {
		int centuryBase = 6 - 2 * (year/100) % 4;
		int[] monthBase = {-1,0,3,3,6,1,4,6,2,5,0,3,5};
		int yy = year%100;
		int leapDays = yy / 4;
		
		int sum = centuryBase + yy + leapDays + monthBase[month] + day;
		
		if(isLeap(year) && month < MARCH)
			sum--;
		
		return sum % 7;
	}
	
	public int getDow() {
		return getDow(year,month,day);
	}
	
	public static String getDowName(int dow) {
		return "";
	}
	
	public String getDowName() {
		return getDowName(getDow());
	}
	
	public static String getMonthName(int month) {
		return ""; 
	}
	
	public String getMonthName() {
		return getMonthName(month);
	}
	
	public void next() {
		day++;
		if(day>daysPerMonth(year,month)) {
			day=1;
			month++;
			if(month>DECEMBER) {
				month=1;
				year++;
			}
		}
	}
	
	public void before() {
		day--;
		if(day<1) {
			month--;
			if(month<JANUARY) {
				year--;
				month=DECEMBER;
			}
			day=daysPerMonth(year,month);
		}
	}
	
	public String toString() {
		return "Date:{"+
				"\"year\":"+year+","+
				"\"month\":"+month+","+
				"\"day\":"+day+","+
				"\"dow\":"+getDow()+","+
				"\"FIRST_DATE\":"+String.format("\"%02d/%02d/%04d\"",FIRST_DAY,FIRST_MONTH,FIRST_YEAR)+
				"}";
	}
	
	public boolean equals(Object o) {
		if (o instanceof Date) {
			Date d = (Date) o;
			return this.year == d.getYear() && this.month == d.getMonth() && this.day == d.getDay();
		}
		return false;
	}
}