import Fechas.Date; 

public class UseDate {


	public static void main(String[] args) {
		Date[] dateArr = new Date[7];
		
		dateArr[0] = new Date();
		dateArr[1] = new Date(2026,Date.JUNE,4);
		dateArr[2] = new Date(2027,Date.FEBRUARY,29);
		dateArr[3] = new Date(2028,2,29);
		dateArr[4] = new Date(2026,15,40);
		dateArr[5] = new Date(2026,6,31);
		dateArr[6] = new Date(2026,6,50);
		
		for(Date d:dateArr) {
			System.out.println(d);
			if(d.isValid())
				System.out.println("La fecha en el elemento es válida");
			else
				System.out.println("La fecha en el elemento es inválida");
			System.out.println("-------------------------------");
		}
		


	}


}
