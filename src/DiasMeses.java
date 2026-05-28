import javax.swing.JOptionPane;

public class DiasMeses {

	public static void main(String[] args) {
	
		//Solicitar el mes y limpiarlo
        String mesEntrada = JOptionPane.showInputDialog("Introduce el nombre del mes:");
        
        // Protegemos el programa por si el usuario presiona "Cancelar"
        if (mesEntrada == null) {
            System.exit(0);
        }
        
        // Quitamos espacios de las orillas y convertimos todo a minúsculas
        String mesLimpio = mesEntrada.trim().toLowerCase();
        
        //Solicitar el año y convertirlo a número entero
        String yearEntrada = JOptionPane.showInputDialog("Introduce el año (Ej. 1992, 2004, 2100):");
        if (yearEntrada == null) {
            System.exit(0);
        }
        int year = Integer.parseInt(yearEntrada.trim());
        
        //Evaluar si el año es bisiesto 
        boolean esBisiesto = false;
        
        // Un año es bisiesto si es múltiplo de 4, pero no de 100, a menos que sea de 400.
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            esBisiesto = true;
        }
        
        //Determinar los días del mes 
        int dias = 0;
        
        switch (mesLimpio) {
            case "enero":
            case "marzo":
            case "mayo":
            case "julio":
            case "agosto":
            case "octubre":
            case "diciembre":
                dias = 31;
                break;
                
            case "abril":
            case "junio":
            case "septiembre":
            case "noviembre":
                dias = 30;
                break;
                
            case "febrero":
                // Si es febrero, se usa el resultado de 'if' anterior
                if (esBisiesto) {
                    dias = 29;
                } else {
                    dias = 28;
                }
                break;
                
            default:
                //entra aquí, es porque el texto no coincidió con ningún mes válido
                JOptionPane.showMessageDialog(null, 
                    "Mes no válido. Revisa la ortografía.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return; 
        }
        
        //Mostrar el resultado final
        JOptionPane.showMessageDialog(null, 
            "El mes de " + mesEntrada.trim() + " en el año " + year + " tiene " + dias + " días.", 
            "Resultado de Días", 
            JOptionPane.INFORMATION_MESSAGE);
	}

}
