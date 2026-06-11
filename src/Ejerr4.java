import javax.swing.JOptionPane;
import java.util.Arrays;
 
public class Ejerr4 {
 
    public static void main(String[] args) {
 
        int n = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "¿Cuántas calificaciones deseas capturar?"
                )
        );
 
        float[] calif = new float[n];
 
        for (int i = 0; i < n; i++) {
 
            calif[i] = Float.parseFloat(
                    JOptionPane.showInputDialog(
                            "Ingresa la calificación " + (i + 1)
                    )
            );
        }
 
        Arrays.sort(calif);
 
        float mediana;
 
        if (n % 2 == 0) {
 
            mediana = (calif[n/2 - 1] + calif[n/2]) / 2;
 
        } else {
 
            mediana = calif[n/2];
        }
 
        JOptionPane.showMessageDialog(
                null,
                "La mediana es: " + mediana
        );
    }
}