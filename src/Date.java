
public class Date {
	private int year=1970;
	private int month=1;
	private int day=1;
	
	// Agregue codigo aqui abajo para el contador de instancias 
	private static int instancesCount = 0;
	
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
		
		// Agregue codigo aqui abajo para incrementar el contador cada vez que nace un objeto
		instancesCount++;
	}
	
	public Date(int year,int month,int day) {
		setDate(year,month,day);
		FIRST_YEAR = this.year;
		FIRST_MONTH = this.month;
		FIRST_DAY = this.day;
		
		// Agregue codigo aqui abajo para incrementar el contador cada vez que nace un objeto
		instancesCount++;
	}
	
	// Setters
	public void setDate(int year,int month,int day) {
		if(isValid(year,month,day)) {
			setYear(year);
			setMonth(month);
			setDay(day);
		}
	}
	
	public void setYear(int year) {
		if(year>=0 && year<=9999 && isValid(year,month,day))
			this.year = year;
	}
	
	public void setMonth(int month) {
		if(isValid(year,month,day))
			this.month = month;
	}
	
	public void setDay(int day) {
		if(isValid(year,month,day))
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
	
	// Agregue codigo aqui abajo para devolver la cantidad de instancias creadas 
	public static int getInstancesCount() {
		return instancesCount;
	}
	
	
	// Agregue codigo aqui abajo para validar si un año es bisiesto 
	public static boolean isLeap(int year) {
		return year%4==0 && year%100!=0 || year%400==0;
	}
	
	public boolean isLeap() {
		return isLeap(year);
	}

	// Agregue codigo aqui abajo para validar si una fecha es correcta 
	public static boolean isValid(int year,int month,int day) {
		int daysPerMonth = 0;
		if(month==JANUARY || month==MARCH || month==MAY || month==JULY || month == AUGUST || month == OCTOBER || month == DECEMBER)
			daysPerMonth = 31;
		else if(month==APRIL || month==JUNE || month==SEPTEMBER || month==NOVEMBER)
			daysPerMonth = 30;
		else if(month==FEBRUARY && isLeap(year))
			daysPerMonth = 29;
		else if(month==FEBRUARY && !isLeap(year))
			daysPerMonth = 28;

		return day>0 && day<=daysPerMonth;
	}

	public boolean isValid() {
		return isValid(year,month,day);
	}
	
	// Agregue codigo aqui abajo para calcular el dia de la semana usando la formula del pizarron
	public static int dow(int year, int month, int day) {
		if(!isValid(year, month, day)) {
			return -1; // Regresa -1 si la fecha es inválida
		}
		
		//Cálculo de la "base Siglo"
		int siglo = year / 100;
		int baseSiglo = (3 - (siglo % 4)) * 2;
		
		//Cálculo de la "Base mes"
		int[] basesMes = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
		int baseMes = basesMes[month - 1];
		
		// Ajuste especial para la "Base mes" en Enero y Febrero si es año bisiesto
		if (isLeap(year)) {
			if (month == JANUARY) baseMes = 6;
			if (month == FEBRUARY) baseMes = 2;
		}
		
		// Aplicación exacta de la fórmula
		int yy = year % 100; // Extraemos los últimos dos dígitos del año 
		
		int diaSemana = (baseSiglo + (yy / 4) + yy + baseMes + day) % 7;
		
		return diaSemana;
	}
	
	public int dow() {
		return dow(year, month, day);
	}
	
	// Agregue codigo aqui abajo para devolver el nombre del dia de la semana 
	public static String dowName(int dow) {
		if(dow < 0 || dow > 6) {
			return null;
		}
		String[] names = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
		return names[dow];
	}
	
	public String dowName() {
		return dowName(dow());
	}
	
	// Agregue codigo aqui abajo para devolver el nombre del mes 
	public static String monthName(int month) {
		if(month < 1 || month > 12) {
			return null;
		}
		String[] names = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		return names[month - 1]; 
	}
	
	public String monthName() {
		return monthName(month);
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