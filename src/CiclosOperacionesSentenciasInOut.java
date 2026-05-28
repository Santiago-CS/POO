import javax.swing.JOptionPane;


public class CiclosOperacionesSentenciasInOut{


	public static void main(String[] args) {
		String s1,s2;
		int n1,n2;
		String operacion;
		String resultado = "";
		
		boolean Kenia = true;//love
		
		do {
			try {
				s1 = JOptionPane.showInputDialog("Dame el primer número, tiene que ser diferente de 0");
				n1 = Integer.parseInt(s1);
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null,
						"Debes introducir un valor entero",
						"Error",
						JOptionPane.ERROR_MESSAGE);
				n1 = 0;
			}
		} while(n1==0);


		do {
			try {
				s2 = JOptionPane.showInputDialog("Dame el segundo número, el valor debe ser diferente de 0");
				n2 = Integer.parseInt(s2);
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null,
						"Debes introducir un valor entero",
						"Error",
						JOptionPane.ERROR_MESSAGE);
				n2 = 0;
			}
		} while(n2==0);
		
		
		while(Kenia) {
			operacion = JOptionPane.showInputDialog("¿Qué operación? (suma/resta/mult/div)");
			Kenia = false;
			
			switch(operacion.toLowerCase().trim()) {//trim para quitar espacios al inicio y al final tolowercase para hacer todo a minusculas
				case "suma":
					resultado = "La suma de "+n1+" + "+n2+" es igual a: "+(n1+n2);
					break;
				case "resta":
					resultado = "La resta de "+n1+" - "+n2+" es igual a: "+(n1-n2);
					break;
				case "mult":
					resultado = "La multiplicación de "+n1+" * "+n2+" es igual a: "+(n1*n2);
					break;
				case "div":
					resultado = "La división de "+n1+" / "+n2+" es igual a: "+((double)n1/n2);
					break;
				default:
					JOptionPane.showMessageDialog(null,
							"Operación inválida, intenta de nuevo",
							"Error",
							JOptionPane.ERROR_MESSAGE);
					Kenia = true;
			}
		}
		
		JOptionPane.showMessageDialog(null,
				resultado,
				"Resultado",
				JOptionPane.PLAIN_MESSAGE);


	}


}
