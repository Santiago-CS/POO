import javax.swing.JOptionPane;

public class EntradaSalida {


	public static void main(String[] args) {

		System.out.println("Hola a todos");
		System.out.print("Solo probando");
		System.out.println("La salida");
			
		double d1 = 1.5;
			
		System.out.printf("El valor de d1 es %5.2f\n",d1);
			
		int x = 12345;
			
		System.out.printf("x=%06d\n",x);
		System.out.printf("x=%X\n",x);
			
		String nombre;
			
		nombre = JOptionPane.showInputDialog("¿Cómo te llamas?");
		JOptionPane.showMessageDialog(null,
			nombre,
			"Saludo",
			JOptionPane.INFORMATION_MESSAGE);
		

	}


}
