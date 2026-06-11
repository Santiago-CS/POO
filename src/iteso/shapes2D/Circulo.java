package iteso.shapes2D;

public class Circulo {
    
    // Atributo
    private double radio;
    
    // Setter y Getter básicos
    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public double getRadio() {
        return this.radio;
    }
    
    // Método para calcular el área
    public double getArea() {
        return Math.PI * (this.radio * this.radio);
    }
    
    // Método para calcular el perímetro
    public double getPerimeter() {
        return 2.0 * Math.PI * this.radio;
    }
    
    // Método para mostrar toda la información en pantalla
    public void print() {
        System.out.println("Radio: " + this.radio);
        // Usamos String.format para redondear a 4 decimales y que se vea más limpio
        System.out.println("Área: " + String.format("%.4f", this.getArea()));
        System.out.println("Perímetro: " + String.format("%.4f", this.getPerimeter()));
    }
}