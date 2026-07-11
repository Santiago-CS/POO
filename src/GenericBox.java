import java.awt.Color; 

public class GenericBox<T> {
    
    private T contenido;

    public GenericBox() {
        this.contenido = null;
    }

    public void put(T contenido) {
        this.contenido = contenido;
    }

    public T get() {
        return contenido;
    }


    @Override
    public String toString() {
        if (contenido == null) {
            return "Cajón vacío";
        } else if (contenido == this) {
            return "Cajón de [este mismo cajón]"; 
        } else {
            return "Cajón de [" + contenido.toString() + "]";
        }
    }


    public static void main(String[] args) {
        

        GenericBox<GenericBox<Color>> cajonDeCajones = new GenericBox<>();

        GenericBox<Color> cajonRGB = new GenericBox<>();
        cajonRGB.put(new Color(255, 0, 0)); 
        cajonDeCajones.put(cajonRGB);

        GenericBox<Object> cajonInfinito = new GenericBox<>();
        cajonInfinito.put(cajonInfinito);
        
        GenericBox<String> cajonVacio = new GenericBox<>();

        System.out.println(cajonVacio);
        System.out.println(cajonRGB);
        System.out.println(cajonDeCajones);
        System.out.println(cajonInfinito);
    }
}