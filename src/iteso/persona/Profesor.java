package iteso.persona;

public class Profesor extends Persona{
    
    private String gradoAcademico;
    private String departamentoAdscrito;
    private int jornadaLaboral;

    public Profesor(String nombre, String apellidoPaterno, String apellidoMaterno, String genero, int edad, 
                    String gradoAcademico, String departamentoAdscrito, int jornadaLaboral) {
        
        super(nombre, apellidoPaterno, apellidoMaterno, genero, edad);
        
       
        this.gradoAcademico = gradoAcademico;
        this.departamentoAdscrito = departamentoAdscrito;
        this.jornadaLaboral = jornadaLaboral;
    }

    // GETTERS
    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public String getDepartamentoAdscrito() {
        return departamentoAdscrito;
    }

    public int getJornadaLaboral() {
        return jornadaLaboral;
    }

    // SETTERS
    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public void setDepartamentoAdscrito(String departamentoAdscrito) {
        this.departamentoAdscrito = departamentoAdscrito;
    }

    public void setJornadaLaboral(int jornadaLaboral) {
        this.jornadaLaboral = jornadaLaboral;
    }
}