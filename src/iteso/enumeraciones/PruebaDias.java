package iteso.enumeraciones;

enum Idioma {
    ESPANOL, INGLES, FRANCES
}

enum Dia {
    LUNES("Lunes", "Monday", "Lundi"),
    MARTES("Martes", "Tuesday", "Mardi"),
    MIERCOLES("Miércoles", "Wednesday", "Mercredi"),
    JUEVES("Jueves", "Thursday", "Jeudi"),
    VIERNES("Viernes", "Friday", "Vendredi"),
    SABADO("Sábado", "Saturday", "Samedi"),
    DOMINGO("Domingo", "Sunday", "Dimanche");

    private final String txtEspanol;
    private final String txtIngles;
    private final String txtFrances;
    
    private Idioma idiomaActual;

    Dia(String txtEspanol, String txtIngles, String txtFrances) {
        this.txtEspanol = txtEspanol;
        this.txtIngles = txtIngles;
        this.txtFrances = txtFrances;
        this.idiomaActual = Idioma.ESPANOL; 
    }

    public void cambiarIdioma(Idioma nuevoIdioma) {
        this.idiomaActual = nuevoIdioma;
    }

    @Override
    public String toString() {
        switch (idiomaActual) {
            case INGLES: return txtIngles;
            case FRANCES: return txtFrances;
            case ESPANOL:
            default: return txtEspanol;
        }
    }
}

public class PruebaDias {
    
    public static void main(String[] args) {
        
        System.out.println("--- Prueba original del requerimiento ---");
        
        Dia d1 = Dia.MIERCOLES;
        d1.cambiarIdioma(Idioma.INGLES);
        System.out.println(d1);  // Imprime Wednesday
        
        Dia d2 = Dia.SABADO;
        System.out.println(d2);  // Imprime Sábado
        
        
        System.out.println("\n--- Todos los días en todos los idiomas (4 líneas) ---");

        for (Idioma i : Idioma.values()) 
            for (Dia d : Dia.values()) {
                d.cambiarIdioma(i); System.out.println(d); 
            }
            
    }
}