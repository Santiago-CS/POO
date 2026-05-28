import javax.swing.JOptionPane;


public class Ejer1 {


	public static void main(String[] args) {
		
		String entrada;
		
		while(true) {
			entrada = JOptionPane.showInputDialog("Contraseña:");
			
			if(entrada==null) {
				System.out.println("No tecleaste contraseña");
				continue;
			}
			if(entrada.equals("exit"))
				break;
			
			System.out.println(entrada);
		}


	}


}
