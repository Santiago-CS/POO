package iteso.persona;
public class TestPersonas {

    public static void main(String[] args) {
        
        System.out.println("=== CREANDO INSTANCIAS ===");
        
        Persona per = new Persona("Carlos", "Gómez", "López", Persona.GENERO_MAS, 35);
        
        Estudiante est = new Estudiante("Santiago", "Nuñez", "Perez", Persona.GENERO_MAS, 22, "Ingeniería en Ciencia de Datos");
        
        Profesor prof = new Profesor("Roberto", "Martínez", "Salas", Persona.GENERO_MAS, 45, "Doctorado", "DESI", 40);
        
        System.out.println("Instancias creadas con éxito.\n");


        System.out.println("=== PRUEBAS DE APUNTADORES (POLIMORFISMO) ===");

        Persona apuntadorPersona = prof; 
        System.out.println("Prueba 1 exitosa: Un apuntador Persona puede guardar a un Profesor.");
        

        
        System.out.println("Prueba 2 falla: Un apuntador Profesor NO puede guardar una Persona genérica directamente.");
        
        System.out.println("Prueba 3 falla: Un apuntador Profesor NO puede guardar a un Estudiante, son clases distintas.");
    }
}