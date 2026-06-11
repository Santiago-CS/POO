import coloresRGB.RGBColor;

public class TestRGBColor {

    public static void main(String[] args) {
                
        RGBColor colorVacio = new RGBColor();
        System.out.println("Color Vacío: " + colorVacio.toString());
        
        RGBColor colorMorado = new RGBColor(150, 0, 200);
        System.out.println("Color Morado: " + colorMorado.toString());
        
        
        
        
        RGBColor clonMorado = colorMorado.clone();
        System.out.println("Clon Morado creado: " + clonMorado.toString());
        
        if (colorMorado.equals(clonMorado)) {
            System.out.println("Resultado equals: ¡Son idénticos en sus colores!");
        } else {
            System.out.println("Resultado equals: Son diferentes.");
        }
        
        System.out.println("\nLe pintamos más rojo solo al clon...");
        clonMorado.setRed(255);
        
        System.out.println("Color Morado Original: " + colorMorado.toString());
        System.out.println("Clon Modificado: " + clonMorado.toString());
        
        if (colorMorado.equals(clonMorado)) {
            System.out.println("Resultado equals: ¡Siguen siendo idénticos!");
        } else {
            System.out.println("Resultado equals: Ahora sus especificaciones son diferentes.");
        }
    }
}