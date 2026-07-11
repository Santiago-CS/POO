package itesoDate;

import java.util.HashSet;

public class PruebaHash {
    public static void main(String[] args) {
        
        int N = 100000;

        // Crear el HashSet
        HashSet<Date> conjuntoFechas = new HashSet<>();

        // Resetear contadores
        Date.equalsConteo = 0;
        Date.hashCodeConteo = 0;

        // Insertar 100,000 fechas aleatorias
        for (int i = 0; i < N; i++) {
            Date d = new Date();
            d.setRandomDate(); 
            conjuntoFechas.add(d); 
        }

        //Imprimir el tamaño
        int T = conjuntoFechas.size();
        System.out.println("Fechas intentadas (N): " + N);
        System.out.println("Tamaño final del conjunto (T): " + T);

        //¿Hubo repetidos?
        int repetidos = N - T;
        System.out.println("¿Hubo repetidos?: " + (repetidos > 0 ? "Sí" : "No"));
        System.out.println("Fechas duplicadas que fueron ignoradas: " + repetidos);

        //Imprimir los conteos
        System.out.println("Veces que se llamó a hashCode(): " + Date.hashCodeConteo);
        System.out.println("Veces que se llamó a equals(): " + Date.equalsConteo);
    }
}