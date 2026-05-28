import javax.swing.JOptionPane;

public class ColoresRGB {

	public static void main(String[] args) {

		String sColor;
		int colorRGB;
		int red,green,blue;
		
		sColor = JOptionPane.showInputDialog("Dame el color en hexadecimal");
		colorRGB = Integer.parseInt(sColor,16);
		
		red = colorRGB >> 16 & 0xFF;
		green = colorRGB >> 8 & 0xFF;
		blue = colorRGB & 0xFF;
		
		JOptionPane.showMessageDialog(null, "Rojo: " +red+ "\nVerde: "+green+"\nAzul: "+blue);
		
		//Cambiar rango y promocion de operandos
		double r = red / 255.0;
		double g = green / 255.0;
		double b = blue / 255.0;
		
		//Para el color negro que se calcula con 1 - rojo verde y azul 
		double maxRGB = Math.max(r, Math.max(g,b));
		double BLK = 1-maxRGB;
		
		//Para el color cian que se calcula con rojo y negro
		double c = (1.0-r-BLK) / (1.0-BLK);
		
		//Para el color magenta con color verde y negro
		double m = (1.0-g-BLK) / (1.0-BLK);
		
		//Para el color amarillo scon azul y negro
		double a = (1.0-b-BLK) / (1.0-BLK);
		
		String resultado_C_M_A_BLK = String.format("(%.2f, %.2f, %.2f, %.2f)", c, m, a, BLK);
		
		JOptionPane.showMessageDialog(null, 
                "El resultado C_M_A_BLK es: " + resultado_C_M_A_BLK, 
                "Conversión de Color", 
                JOptionPane.INFORMATION_MESSAGE);
	}

}
