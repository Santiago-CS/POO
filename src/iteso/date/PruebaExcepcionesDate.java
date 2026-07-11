package iteso.date;

public class PruebaExcepcionesDate {

    public static void main(String[] args) {
        

        //Una fecha válida
        try {
            System.out.print("Prueba 1 (Fecha válida): ");
            Date fecha1 = new Date(2023, 10, 15);
            System.out.println("Éxito. Se creó la fecha " + fecha1.getDay() + "/" + fecha1.getMonth() + "/" + fecha1.getYear());
        } catch (InvalidDateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //Día inválido (30 de febrero)
        try {
            System.out.print("\nPrueba 2 (30 de Febrero): ");
            Date fecha2 = new Date(2023, 2, 30);
            System.out.println("Éxito al crear fecha 2."); // Esta línea nunca se va a ejecutar
        } catch (InvalidDateException e) {
            System.out.println("\n  Esta mal -> " + e.getMessage());
        }

        //Mes inválido (Mes 13)
        try {
            System.out.print("\nPrueba 3 (Mes 13): ");
            Date fecha3 = new Date(2023, 13, 1);
            System.out.println("Éxito al crear fecha 3.");
        } catch (InvalidDateException e) {
            System.out.println("\n  Esta Mal -> " + e.getMessage());
        }

        //Modificar una fecha válida con un setter inválido (29 de febrero en año NO bisiesto)
        try {
            System.out.print("\nPrueba 4 (Setter año no bisiesto): ");
            Date fecha4 = new Date(2024, 2, 29); 
            System.out.println("\n  Nace bien: 29/2/2024");
            
            System.out.print("  Intentando cambiar el año a 2023... ");
            fecha4.setYear(2023); // Aquí va a tronar 
            
            System.out.println("Cambio exitoso.");
        } catch (InvalidDateException e) {
            System.out.println("\n  Esta mal -> " + e.getMessage());
        }
        
    }
}