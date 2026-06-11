import iteso.shapes2D.Rectangle;
import javax.swing.JOptionPane;

public class Rectangulo {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(-10,2000000);
		
		
		System.out.println("Area :"+r1.getArea());
		
		Rectangle r2 = new Rectangle(10,15,100,150);
		
		System.out.println("Area :"+r2.getArea());
		
		System.out.println("Base de r2: "+r2.getBase());
		System.out.println("Altura de r2: "+r2.getHeight());
		
		r2.setPosX(100);
		r2.setPosY(150);
		
		System.out.println("Posición de r2 es x:"+r2.getPosX()+
				", y:"+r2.getPosY());
		
		r2.move(50, -70);
		
		System.out.println("Posición de r2 es x:"+r2.getPosX()+
				", y:"+r2.getPosY());
		
		Rectangle r3 = new Rectangle(10);
		Rectangle r4 = new Rectangle(10,10);
		
		if(r3.isSquare())
			System.out.println("r3 es un cuadrado");
		else
			System.out.println("r3 no es un cuadrado");


		if(r4.isSquare())
			System.out.println("r4 es un cuadrado");
		else
			System.out.println("r4 no es un cuadrado");
		
		r3.setBase(r3.getBase()*2);
		if(r3.isSquare())
			System.out.println("r3 es un cuadrado");
		else
			System.out.println("r3 no es un cuadrado");


		
System.out.println("\nExperimento Wall-E");
		//con comentarios porque el profe es try hard y yo no para entender :p
		// Usamos la segunda variable (r2) para apuntar a un nuevo rectángulo.
		// Al hacer esto, el rectángulo (10, 15) que cree arriba queda "abandonado".
		System.out.println("Cambiando r2 para que apunte a un nuevo rectángulo...");
		r2 = new Rectangle(40, 40); 
		
		// Llamamos al recolector de basura
		System.out.println("Llamando a la grúa (System.gc())...(garbage collector)");
		System.gc(); 
		
		// Generamos la primera pausa
		JOptionPane.showMessageDialog(null, "*/"
				+ "En la consola sale ue va a destruirse el rectangulo original.");
		
		// Asignamos null a la segunda variable
		System.out.println("\nAsignando null a r2...");
		r2 = null; // Ahora, el rectángulo (40, 40) también queda abandonado.
		
		//Volvemos a llamar al recolector de basura
		System.out.println("Llamando a la grúa por segunda vez...");
		System.gc();
		
		JOptionPane.showMessageDialog(null, "En la consola sale que va a destruirse el rectángulo de 40x40.");
		
		System.out.println("Fin del programa.");
	}
}
