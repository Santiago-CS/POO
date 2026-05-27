import javax.swing.JOptionPane;

public class ejer5 {

	public static void main(String[] args) {

		//Capturar y convertir la distancia 
        String distKmStr = JOptionPane.showInputDialog("Teclea la distancia recorrida en kilómetros:");
        double distancia = Double.parseDouble(distKmStr);
        
        // 2. Capturar y convertir el tiempo inicial
        String tiempoInicialStr = JOptionPane.showInputDialog("Teclea el tiempo inicial en minutos (ej. 630 para 10:30 hrs):");
        double tiempoInicial = Double.parseDouble(tiempoInicialStr);
        
        // 3. Capturar y convertir el tiempo final
        String tiempoFinalStr = JOptionPane.showInputDialog("Teclea el tiempo final en minutos:");
        double tiempoFinal = Double.parseDouble(tiempoFinalStr);
        
        // Primero, sacamos cuántos minutos pasaron en total
        double tiempoTranscurridoMin = tiempoFinal - tiempoInicial;
        
        // Segundo, convertimos esos minutos a horas (dividiendo entre 60)
        double tiempoEnHoras = tiempoTranscurridoMin / 60.0;
        
        // Tercero, calculo de la velocidad (Velocidad = Distancia / Tiempo)
        double velocidadPromedio = distancia / tiempoEnHoras;
        
        // 5. Mostrar el resultado final
        JOptionPane.showMessageDialog(null,
            "La velocidad promedio fue de: " + velocidadPromedio + " km/h",
            "Resultado del Cálculo",
            JOptionPane.INFORMATION_MESSAGE);

	}

}
