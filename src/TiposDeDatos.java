public class TiposDeDatos {
	public static void main(String args[]) {
		int i1 = 10;
		float f1 = 1.5f;
		float f2 = (float) 1.5;
		double d1 = 1.5;
		double d2 = 1.5f;
		
		char c1 = 65;
		System.out.println("c1='"+c1+"'");
		
		char c2 = 0x41;
		System.out.println("c2='"+c2+"'");
		
		char c3 = 0101;
		System.out.println("c3='"+c3+"'");
		
		long l2 = 2_836_498_726_809_234l;
		
		String nombre = "Santiago";
		String apellidoPaterno = "Nuñez";
		String apellidoMaterno = "Perez";
		String nombreCompleto = nombre + " " + apellidoPaterno + " " + apellidoMaterno;
		
		System.out.println("Hola "+nombreCompleto);
		
		int x = 1;
		int X = 2;
		System.out.println("x:"+x);
		System.out.println("X:"+X);
	}
}
