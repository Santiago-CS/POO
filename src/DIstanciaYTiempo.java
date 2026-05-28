import javax.swing.JOptionPane;

public class DIstanciaYTiempo {

    public static void main(String[] args) {

        //Capturar y convertir los tres datos solicitados
        String velStr = JOptionPane.showInputDialog("Teclea la velocidad promedio de tu viaje (en km/h):");
        double velocidad = Double.parseDouble(velStr);
        
        String distStr = JOptionPane.showInputDialog("Teclea la distancia que hace falta por recorrer (en kilómetros):");
        double distanciaFaltante = Double.parseDouble(distStr);
        
        String tiempoLimiteStr = JOptionPane.showInputDialog("¿En cuántos minutos tienes que llegar a tu destino?:");
        double tiempoLimiteMinutos = Double.parseDouble(tiempoLimiteStr);
        
        //Calculo el tiempo estimado de viaje en horas
        double tiempoEstimadoHoras = distanciaFaltante / velocidad;
        
        // Convertir ese tiempo estimado a minutos para poder comparar "peras con peras"
        double tiempoEstimadoMinutos = tiempoEstimadoHoras * 60.0;
        
        //TOMAR LA DECISIÓN
        String mensajeResultado;
        
        if (tiempoEstimadoMinutos <= tiempoLimiteMinutos) {
            // debe de tardar menos o igual que el tiempo límite
            mensajeResultado = "Eso gallo, Llegarás a tiempo.\n" +
                               "Tu tiempo estimado de viaje es de: " + String.format("%.1f", tiempoEstimadoMinutos) + " minutos.";
        } else {
            // Si el tiempo estimado es mayor al límite, ya es llegar tarde :(
            mensajeResultado = "Llama, No vas a llegar a tiempo .\n" +
                               "Vas a tardar aproximadamente: " + String.format("%.1f", tiempoEstimadoMinutos) + " minutos.";
        }
        
        //Mostrar el resultado en otro cuadro
        JOptionPane.showMessageDialog(null,
            mensajeResultado,
            "Informe del Viaje",
            JOptionPane.INFORMATION_MESSAGE);

    }
}
