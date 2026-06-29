package iteso.geometry; 

public class Shape3D {
    
    private double x;
    private double y;
    private double z;

    public Shape3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public double getZ() { return z; }
    public void setZ(double z) { this.z = z; }

   
    public static Shape3D createShape(String tipo, double x, double y, double z, double... dimensiones) {
        
        if (dimensiones == null || dimensiones.length == 0) { 
            System.out.println("Error Factory: No se proporcionaron dimensiones.");
            return null;
        }

        for (double dim : dimensiones) {
            if (dim <= 0 || dim >= 100) {
                System.out.println("Error Factory: Dimensiones inválidas (deben ser > 0 y < 100).");
                return null; 
            }
        }

        
        System.out.println("Falta programar la creación de la figura: " + tipo);
        return null;
    }
}