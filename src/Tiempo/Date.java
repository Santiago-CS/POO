package Tiempo;
 
//AGREGADO: Importamos la librería para obtener la fecha del sistema 
import java.util.Calendar;
 
public class Date {
 
	private int day=1;
	private int month=1;
	private int year=1970;
	private int valDay=1;
	private int valMonth=1;
	private int valYear=1;
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
 
	
	//constructors
	// AGREGADO: Constructor modificado para tomar la fecha del sistema
	public Date() {
		Calendar actual = Calendar.getInstance();
		setYear(actual.get(Calendar.YEAR));
		// En Calendar, los meses van de 0 a 11, por eso sumamos 1
		setMonth(actual.get(Calendar.MONTH) + 1); 
		setDay(actual.get(Calendar.DAY_OF_MONTH));
	}
	public Date(int year, int month, int day) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}
 
	//setters
	public void setDay(int day){
		if(month == 2 && ((year %4 ==0 && year %100!=0) || (year %400==0))) {
			if(day > 0 && day <= 29) {
				this.day = day;
				valDay = 1;
			}
			else {
				valDay = 0;
		}
		}
		else if (month == 2 && !((year %4 ==0 && year %100!=0) || (year %400==0))) {
			if(day > 0 && day <= 28) {
				this.day = day;
				valDay = 1;
				}
			else {
				valDay = 0;
		}
		}
		else if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
			if(day > 0 && day <= 31) {
				this.day = day;
				valDay = 1;
			}
			else {
				valDay = 0;
		}
		}
		else {
			if(day > 0 && day <= 30) {
				this.day = day;
				valDay = 1;
			}
			else {
				valDay = 0;
		}
		}
	}
	public void setMonth(int month){
		if(month > 0 && month <= 12) {
			this.month = month;
			valMonth=1;
			}
			else {
				valMonth = 0;
		}
	}
	public void setYear(int year){
		if(year >= 0 && year <= 9999) {
			this.year = year;
			valYear=1;
		}
		else {
			valYear = 0;
	}
	}
	//getters
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
 
	public  boolean isValid() {
		if (valDay==1&& valMonth==1&& valYear==1)
			 return true;
		else
			return false;
	}
	public String monthName(int month) {
		  String array[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		return array[month-1];
	}
	public String toString() {
		return(day+" de "+monthName(month)+" de "+year);
	}
	public long epoch() {
		int totalday =0;
		for (int i = 1970; i<year;i++) {
			if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
				totalday += 366;
			} else {
				totalday += 365;
			}
		}
 
		// PASO 2: Sumar los días de los meses completos del año actual
		int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		// Si nuestro año actual es bisiesto, actualizamos febrero a 29
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			diasPorMes[1] = 29;
		}
 
		// Sumamos los meses anteriores al nuestro (month - 1)
		for (int i = 0; i < month - 1; i++) {
			totalday += diasPorMes[i];
		}
 
		// PASO 3: Sumar los días del mes actual
		// Se resta 1 porque el 1 de enero de 1970 es el día 0 del Epoch.
		totalday += (day - 1);
		long epochsec = totalday*86400L;
		return epochsec;
	}
	public static boolean isLeap(int year) {
		return year%4==0 && year%100!=0 || year%400==0;
	}
	public boolean isLeap() {
		return isLeap(year);
	}
 
		public static int dow(int year, int month, int day) {
			Date tempDate = new Date(year,month,day);
			 if(!tempDate.isValid())
				 return -1;
			 int siglo = (year - (year % 100)) / 100;
			 int baseYear =2 * (3 - (siglo % 4));
			int codeMonth[] = {0,3,3,6,1,4,6,2,5,0,3,5};
		    int baseMonth = codeMonth[month - 1];
		    if(isLeap(year) && month <=2) {
		    	baseMonth -=1;
		    }
		    if(baseMonth < 0) {
	            baseMonth = 6; 
	        }
		    return(baseYear+(year%100)/4 + year%100 +baseMonth+day)%7;
		} 
		public  static String dowName(int day,int month, int year) {
			int weekDay = dow(year,month,day);
		    switch (weekDay) {
		        case 0:
		            return "Domingo";
		        case 1:
		            return "Lunes";
		        case 2:
		            return "Martes";
		        case 3:
		            return "Miércoles";
		        case 4:
		            return "Jueves";
		        case 5:
		            return "Viernes";
		        case 6:
		            return "Sábado";
		        default:
		            return null;
		    }
		}
	}