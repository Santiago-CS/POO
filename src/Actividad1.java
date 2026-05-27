import javax.swing.JOptionPane;

public class Actividad1 {

    public static void main(String[] args) {
        
    	int registro1 = 100;
    	// int 1registro = 100; //este no es valido no puede empezar con un numero
    	String archivo_3 = "archivos asi muy confidenciales";
    	
    	//while esta tampoco es valida ya que esta reservada a una funcion para los ciclos
    	
    	double $impuesto = 32.00;
    	int año = 2026;
    	//primer apellido no admitido por el espacio
    	
    	String primer_apellido = "Nuñez";
    	
    	//Primer-apellido es el simbolo de resta no admite esto
    	//1primerApellido no admite no puede empezar con numero
    	//Tom´s no permite las comillas o apostrofes
    	
    	String C3PO = "El droide de anakin";
    	
    	
    	
    	
        
        int k = 5;
        double e = 4.56;
        char n = 'a';
        
        //El valor de cada variable.
        System.out.println("Variable k = " + k);
        System.out.println("Variable e = " + e);
        System.out.println("Variable n = " + n);
        
        //La suma de N + A
        System.out.println(k + " + " + e + " = " + (k + e));
        
        //La diferencia de A - N
        System.out.println(e + " - " + k + " = " + (e - k));
        
        //El valor numérico correspondiente al carácter que contiene la variable C.
        System.out.println("Valor numérico del carácter " + n + " = " + (int) n);
        
        
        
     // Literales double 
        double val1 = 0.5;
        double val2 = .5;
        double val3 = 9.3e12;
        double val4 = 9.3e-12;
        
        // Literal entero decimal
        int val5 = 12345678;
        
        // Literales Octales (Base 8)
        int val6 = 05_15; 
        int val7 = 010101; // Se lee como octal. comenta el profe
        int val8 = 0_557;
        
        // Literales Hexadecimales (Base 16)
        int val9 = 0XBC5DA;
        int val10 = 0x87e3a;
        
        // Literales tipo long 
        long val11 = 234567L;
        long val12 = 12_234L;
        
        // Literal tipo float 
        float val13 = .3e3f;
        
        // Literal Binario (Base 2)
        int val14 = 0b111;
        
        //CON ERRORES	
        //long err1 = 12345678_L; 
        // double err2 = 0.8E+0.8; 
        // double err3 = 0.8E 8;   
        // int err4 = 018CDF;      
        // int err5 = 0_B11;      
        // double err6 = .00.8E2;  
        
        
        //Declaracion de variables segun su tipo
        // 1. Estatura de una persona (en metros)
        double estaturaMetros = 1.75;
        
        // 2. RFC de un cliente
        String rfcCliente = "XAXX010101000";
        
        // 3. Tecla presionada
        char teclaPresionada = 'A';
        
        // 4. Población de un país (Ej. México)
        long poblacionPais = 130_000_000L;
        
        // 5. Dirección de memoria (Representación hexadecimal)
        long direccionMemoria = 0x7FFA4C;
        
        // 6. Masa de un planeta (Ej. La Tierra en kilogramos)
        double masaTierraKg = 5.972e24;
        
        // 7. ¿El año es bisiesto?
        boolean esBisiesto = true;
        
        // 8. Edad de una persona
        byte edadPersona = 25;
        
        //IMPRESIÓN PARA VERIFICAR
        System.out.println("Estatura: " + estaturaMetros + "m");
        System.out.println("RFC: " + rfcCliente);
        System.out.println("Tecla: " + teclaPresionada);
        System.out.println("Población: " + poblacionPais);
        System.out.println("Memoria (Decimal): " + direccionMemoria);
        System.out.println("Masa del planeta: " + masaTierraKg + " kg");
        System.out.println("¿Es bisiesto?: " + esBisiesto);
        System.out.println("Edad: " + edadPersona + " años");
        
        
        String s1 = "Hola";
        String s2 = "Hola";
        String s3 = new String("Hola");
                
        if(s1==s2)
        System.out.println("s1 == s2");    
        if(s1==s3)
        System.out.println("s1 == s3"); 
                
        if(s1.equals(s2))
        System.out.println("s1 igual a s2"); 

        if(s1.equals(s3))                        
        System.out.println("s1 igual a s3"); 

        /* 8 ¿Que aprendiste con esta actividad?
         * Personalmente aprendi a dominar un poco mas los tipos de datos y los inputs y outputs a trabajar 
         * con ellos en este lenguaje que nunca habia tocado e igual un ejercicio se me obligo a investigar
         * en como transformar datos en el caso que hice fue de strings a doubles, que igual aun con esto
         * tengo mucho por delante que dominar de este lenguaje ya que algunas cosas solo se dan con la
         * intuicion previa que tengo de programar en python pero si es muy diferente
         * 
        */
    }
}