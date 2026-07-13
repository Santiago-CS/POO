package iteso.persona;

public class Persona
{
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String genero;
    private int edad;

    public static final String GENERO_MAS = "Masculino";
    public static final String GENERO_FEM = "Femenino";

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String genero, int edad)
    {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.edad = edad;
    }

    //getters
    public String getNombre()
    {
        return nombre;
    }
    public String getApellidoPaterno()
    {
        return apellidoPaterno;
    }
    public String getApellidoMaterno()
    {
        return apellidoMaterno;
    }
    public String getGenero()
    {
        return genero;
    }
    public int getEdad()
    {
        return edad;
    }

    //setters
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setApellidoPaterno(String apellidoPaterno)
    {
        this.apellidoPaterno = apellidoPaterno;
    }
    public void setApellidoMaterno(String apellidoaMaterno)
    {
        this.apellidoMaterno = apellidoaMaterno;
    }
    public void setGenero(String genero)
    {
        this.genero = genero;
    }
    public void setEdad(int edad)
    {
        this.edad = edad;
    } 
}