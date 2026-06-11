public class Arreglos2D {


	public static void main(String[] args) {
		int[][] m = {{ 1, 2, 3, 4},
				     { 5, 6, 7, 8},
				     { 9,10,11},
				     {13,14,15,16}};
		
		
		// Mostrar la matriz en pantalla
		System.out.println("\nMatriz m:");
		for(int i=0;i<m.length;i++) {		// El tamaño de la matriz m en su primera dimensión, en este caso los renglones
			for(int j=0;j<m[i].length;j++)	// El tamaño de cada renglón i
				System.out.print(m[i][j]+" ");
			System.out.println(""); // Salto de línea después del renglón
		}
		
		System.out.println("\nMatriz m:");
		for(int[] row:m) {	// El apuntador a cada una de las filas de m, se copia a row
			for(int e:row)	// e toma cada uno de los enteros que están en row
				System.out.print(e+" ");
			System.out.print("\n");
		}
		
		int[][] m1;
		
		m1 = m.clone();	// Haciendo un clon de la primera dimensión,
						// Pero los apuntadores que están en los dos, 
						// apuntan a los mismos renglones
		
		// Necesitamos clonar cada uno de los renglones
		for(int i=0;i<m.length;i++)
			m1[i] = m[i].clone();


		System.out.println("\nMatriz m1:");
		for(int[] row:m1) {	// El apuntador a cada una de las filas de m, se copia a row
			for(int e:row)	// e toma cada uno de los enteros que están en row
				System.out.print(e+" ");
			System.out.print("\n");
		}
		
		for(int i=0;i<m1.length;i++)
			for(int j=0;j<m1[i].length;j++)
				m1[i][j]*=10;


		System.out.println("\nMatriz m1:");
		for(int[] row:m1) {	// El apuntador a cada una de las filas de m, se copia a row
			for(int e:row)	// e toma cada uno de los enteros que están en row
				System.out.print(e+" ");
			System.out.print("\n");
		}
		
		System.out.println("\nMatriz m:");
		for(int[] row:m) {	// El apuntador a cada una de las filas de m, se copia a row
			for(int e:row)	// e toma cada uno de los enteros que están en row
				System.out.print(e+" ");
			System.out.print("\n");
		}


		
	}
}
