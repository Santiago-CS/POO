package iteso.persona;

public class TestPersonas {

    public static void main(String[] args) {
                
        // Instancia general de Persona
        Persona per = new Persona("Guillermo", "Alan", "Sanchez", Persona.GENERO_MAS, 18);
        
        // Instancia de Estudiante
        Estudiante est = new Estudiante("Santiago", "Nuñez", "Perez", Persona.GENERO_MAS, 22, "ICD");
        
        // Instancia de Profesor
        Profesor prof = new Profesor("Jose", "Luis", "Elvira", Persona.GENERO_MAS, 45, "Doctorado", "DESI", 40);
        

        // ESTADO: Exitoso. Un Profesor tiene todo lo de una Persona.
        Persona apuntadorPersona = prof; 
        System.out.println("Prueba 1 exitosa: Un apuntador Persona puede guardar a un Profesor.");
        
        
        // ESTADO: Marca error de compilación. 
        // EXPLICACIÓN: Falla porque la Persona genérica no tiene los atributos exclusivos del Profesor (como gradoAcademico).
        //Profesor apuntadorProfesor1 = per; 
        System.out.println("Prueba 2 comprobada: Un apuntador Profesor NO puede guardar una Persona genérica (código comentado para evitar error).");


         // ESTADO: Marca error de compilación.
        // EXPLICACIÓN: Falla porque son clases "hermanas" incompatibles. El Estudiante no sabe qué es una jornadaLaboral.
        //Profesor apuntadorProfesor2 = est; 
        System.out.println("Prueba 3 comprobada: Un apuntador Profesor NO puede guardar a un Estudiante (código comentado para evitar error).");
        
    }
}