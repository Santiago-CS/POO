import iteso.shapes2D.Circulo;

public class TestCircle {

    public static void main(String[] args) {
        
        // 1. Creamos y configuramos el Círculo 1
        Circulo circulo1 = new Circulo();
        circulo1.setRadio(2.5);
        
        // 2. Creamos y configuramos el Círculo 2
        Circulo circulo2 = new Circulo();
        circulo2.setRadio(6.6);
        
        // 3. Creamos y configuramos el Círculo 3
        Circulo circulo3 = new Circulo();
        circulo3.setRadio(7.5);
        
        
        // 4. Mostramos la información en pantalla usando nuestro método print()
        System.out.println(" DATOS DEL CÍRCULO 1 ");
        circulo1.print();
        
        System.out.println("\n DATOS DEL CÍRCULO 2 ");
        circulo2.print();
        
        System.out.println("\n DATOS DEL CÍRCULO 3 ");
        circulo3.print();
        
    }
}