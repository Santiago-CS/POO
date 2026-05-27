import javax.swing.JOptionPane;

public class ejer6 {
	
	public static void main(String[] args) {
		
	//Solicita el nombre
    String nombre = JOptionPane.showInputDialog("Teclea tu nombre");
    
    //Solicita apellido paterno
    String apellido_pat = JOptionPane.showInputDialog("Teclea tu Apellido Paterno");
    
    // Solicita apellido materno
    String apellido_mat = JOptionPane.showInputDialog("Teclea tu Apellido Materno");
    
    //Ya nombre completo
    String nombre_completo = nombre + " " + apellido_pat + " " + apellido_mat;
    
    
    JOptionPane.showMessageDialog(null,
            "Nombre Completo: " + nombre_completo,
            "Tu Mero Nombre",
            JOptionPane.INFORMATION_MESSAGE);
	}
	
}
