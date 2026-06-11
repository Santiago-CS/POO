public class TestDate {

	public static void main(String[] args) {
		
		System.out.println(" PRUEBA DE MÉTODOS DEL PROFE ");
		
		// Probamos si funciona la validación bisiesta directamente desde la clase
		System.out.println("¿2024 es bisiesto?: " + Date.isLeap(2024));
		System.out.println("¿2026 es bisiesto?: " + Date.isLeap(2026));
		
		// Probamos la fórmula del pizarrón calculando qué día de la semana es hoy
		// Hoy es 10 de Junio de 2026
		int diaSemanaNumero = Date.dow(2026, 6, 10);
		String nombreDia = Date.dowName(diaSemanaNumero);
		
		System.out.println("\nCálculo de fecha (10/Junio/2026):");
		System.out.println("Número del día " + diaSemanaNumero);
		System.out.println("Nombre del día: " + nombreDia + " ");
		
				
		// Verificamos cuántas fechas hay antes de crear nada
		System.out.println("Fechas creadas al inicio: " + Date.getInstancesCount());
		
		// Creamos 3 fechas para probar el contador
		Date fecha1 = new Date();
		Date fecha2 = new Date(2025, 12, 25);
		Date fecha3 = new Date(1990, 5, 15);
		
		System.out.println("Fechas creadas al final: " + Date.getInstancesCount());
		
	}
}