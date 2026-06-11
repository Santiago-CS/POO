public class Ejerr1 {

    public static void main(String[] args) {
        
        // Declaración y asignación de las matrices A y B hardcodeadas :p
        double[][] A = {
            {1.5, 2.3, 4.1},
            {5.0, 6.2, 7.8}
        };
        
        double[][] B = {
            {2.5, 1.7, 3.9},
            {4.0, 3.8, 1.2}
        };
        
        int filas= A.length;
        int columnas = A[0].length;
        
        //matriz c con mismas dimensiones
        double[][] C= new double[filas][columnas];
        
            
        
        for (int i = 0; i < filas; i++ )
        {
        	for (int j	 = 0; j < columnas; j++)
        	{
        		C[i][j] = A[i][j] + B[i][j];
        	}
        }
        for (int i = 0; i < filas; i++ )
        {
        	for (int j	 = 0; j < columnas; j++)
        	{
        		System.out.printf("%.1f\n", C[i][j]);
        	}
        }
        
    }
}