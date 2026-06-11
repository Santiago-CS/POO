import javax.swing.JOptionPane;

public class Ejer3 {

    public static void main(String[] args) {

        String entrada;
        double precio = 0.0;
        
        while(true) {
            entrada = JOptionPane.showInputDialog(
                    "Teclea el precio del producto\n" +
                    "Introduce el precio o 'exit' para salir del programa:");
            
            // Si presionan Cancelar o la X
            if(entrada == null) {
                System.out.println("Operación Cancelada");
                break;
            }
            
            // Si escriben exit
            if(entrada.equals("exit")) {
                break;
            }
            
            // Intentamos convertir la entrada a número
            try {
                // CORRECCIÓN 1: Aquí convertimos el texto a número antes de evaluarlo.
                // Sin esta línea, el catch nunca detectaría si hay letras.
                precio = Double.parseDouble(entrada.trim());
                
                if(precio <= 0) {
                    JOptionPane.showMessageDialog(null, "El número debe ser mayor a 0.");
                    continue;
                }
               
                break; 
                
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, 
                        "Error: Debes introducir un número entero sin letras.", 
                        "Dato Inválido", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }    
        
        // CORRECCIÓN 2: Se eliminó el "while(true);" suelto que estaba aquí y que congelaba tu programa.
                
        // Cálculo del IVA
        if (precio > 0) {
            double precioConIva = precio * 1.16;
            
            // Usamos String.format para redondear a 2 decimales
            JOptionPane.showMessageDialog(null, 
                    "Precio capturado: $" + precio + "\n" +
                    "Precio total con IVA (16%): $" + String.format("%.2f", precioConIva),
                    "Resultado final",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}