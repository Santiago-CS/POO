package Tiempo;
import java.util.Calendar;

public class PruebaDate1 {
    public static void main(String[] args) {
        // 1. Probar constructor y toString
        Date fecha1 = new Date(2026, 6, 11);
        System.out.println("Fecha 1: " + fecha1.toString());

        // 2. Probar validación
        Date fechaInvalida = new Date(2026, 13, 40);
        System.out.println("¿Fecha inválida es válida?: " + fechaInvalida.isValid());

        // 3. Probar si es bisiesto
        System.out.println("¿Es 2024 bisiesto?: " + Date.isLeap(2024));
        System.out.println("¿Es 2026 bisiesto?: " + fecha1.isLeap());

        // 4. Probar cálculo de Epoch
        System.out.println("Epoch de la fecha 1 (en segundos): " + fecha1.epoch());

        // 5. Probar día de la semana
        int diaSemanaNum = Date.dow(2026, 6, 11);
        String nombreDia = Date.dowName(11, 6, 2026);
        System.out.println("Día de la semana (num): " + diaSemanaNum);
        System.out.println("Nombre del día: " + nombreDia);
        
        // 6. Prueba de cambio de fecha
        fecha1.setDay(25);
        fecha1.setMonth(12);
        fecha1.setYear(2025);
        System.out.println("Nueva fecha modificada: " + fecha1.toString());
        System.out.println("Día de la semana de la nueva fecha: " + Date.dowName(25, 12, 2025));
        
        Calendar d1 = Calendar.getInstance();
        Calendar d2 = Calendar.getInstance();
        d1.set(2026,Calendar.JUNE,11);
        d2.set(2021,Calendar.SEPTEMBER,23);
        Calendar t1 = Calendar.getInstance();
        Calendar dt1 = (Calendar) d2.clone();
        dt1.set(Calendar.HOUR_OF_DAY, t1.get(Calendar.HOUR_OF_DAY));
        dt1.set(Calendar.MINUTE, t1.get(Calendar.MINUTE));
        dt1.set(Calendar.SECOND, t1.get(Calendar.SECOND));
        int res = d1.compareTo(d2);
         if (res  ==0) 
        	 System.out.println("Son iguales");
        	 else if(res <0)
        		 System.out.println("d1 es menor que d2");
        	 else
        		 System.out.println("d2 es menor que d1");
        	 
         d1.add(Calendar.WEEK_OF_YEAR,2);
         d1.add(Calendar.YEAR,4);
       
         System.out.println(d1.get(Calendar.YEAR)+"/"+(d1.get(Calendar.MONTH)+1)+"/"+d1.get(Calendar.DAY_OF_MONTH));
     System.out.println(t1.get(Calendar.HOUR_OF_DAY)+":"+t1.get(Calendar.MINUTE));
     System.out.println(dt1.get(Calendar.YEAR) + "/" + (dt1.get(Calendar.MONTH) + 1) + "/" + dt1.get(Calendar.DAY_OF_MONTH) + " " + dt1.get(Calendar.HOUR_OF_DAY) + ":" + dt1.get(Calendar.MINUTE) + ":" + dt1.get(Calendar.SECOND));
     
    }
}