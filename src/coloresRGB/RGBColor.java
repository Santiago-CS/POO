package coloresRGB;

public class RGBColor {

    // Atributos privados
    private int red;
    private int green;
    private int blue;

    // Constructor por defecto (sin parámetros)
    public RGBColor() {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }

    // Constructor con parámetros
    public RGBColor(int red, int green, int blue) {
        // Llamamos a los setters para aprovechar su validación
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }

    // --- SETTERS CON VALIDACIÓN ---
    public void setRed(int red) {
        if (red >= 0 && red <= 255) {
            this.red = red;
        } else {
            System.out.println("Error: El rojo debe estar entre 0 y 255.");
        }
    }

    public void setGreen(int green) {
        if (green >= 0 && green <= 255) {
            this.green = green;
        } else {
            System.out.println("Error: El verde debe estar entre 0 y 255.");
        }
    }

    public void setBlue(int blue) {
        if (blue >= 0 && blue <= 255) {
            this.blue = blue;
        } else {
            System.out.println("Error: El azul debe estar entre 0 y 255.");
        }
    }

    // --- GETTERS ---
    public int getRed() { return this.red; }
    public int getGreen() { return this.green; }
    public int getBlue() { return this.blue; }

    // 1. toString (Formato tipo JSON)
    public String toString() {
        return "{\"red\": " + this.red + ", \"green\": " + this.green + ", \"blue\": " + this.blue + "}";
    }

    // equalsCompara si dos objetos RGBColor tienen los mismos valores
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if (o == null || this.getClass() != o.getClass()) return false;
        
        // Convierte el objeto genérico a tipo RGBColor
        RGBColor color = (RGBColor) o;
        
        // Compara los 3 atributos
        return this.red == color.red && 
               this.green == color.green && 
               this.blue == color.blue;
    }

    public RGBColor clone() {
        return new RGBColor(this.red, this.green, this.blue);
    }
}
