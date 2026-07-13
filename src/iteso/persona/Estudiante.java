package iteso.persona;

public class Estudiante extends Persona
{
    private String planDeEstudios;
    private int creditosCursados;
    private int semestreCursado;

    public Estudiante(String nombre, String apellidoPaterno, String apellidoMaterno, String genero, int edad, String planDeEstudios)
    {
        super(nombre, apellidoPaterno, apellidoMaterno, genero, edad);
        this.planDeEstudios = planDeEstudios;
    }

    //getters
    public String getPlanDeEstudios()
    {
        return planDeEstudios;
    }
    public int getCreditosCursados()
    {
        return creditosCursados;
    }
    public int getSemestreCursado()
    {
        return semestreCursado;
    }

    //setters
    public void setPlanDeEstudios(String planDeEstudios)
    {
        this.planDeEstudios = planDeEstudios;
    }
    public void setCreditosCursados(int creditosCursados)
    {
        this.creditosCursados = creditosCursados;
    }
    public void setSemestreCursado(int semestreCursado)
    {
        this.semestreCursado = semestreCursado;
    }
}