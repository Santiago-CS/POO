package colorRGBClase;

public class colorRGBClase {
	private int red = 0;
	private int green = 0;
	private int blue = 0;
	
	/* Los atributos final deben ser inicializados forzosamente 
	 * puede hacerse en la declaración de los atributos o
	 * en los constructores. No se puede hacer en ambos
	 */
	public final int FIRST_RED_VALUE;
	public final int FIRST_GREEN_VALUE;
	public final int FIRST_BLUE_VALUE;
	public final int FIRST_RGB;
	
	
	public colorRGBClase() {
		FIRST_RED_VALUE = 0;
		FIRST_GREEN_VALUE = 0;
		FIRST_BLUE_VALUE = 0;
		FIRST_RGB = 0;
	}
	
	public colorRGBClase(int red,int green,int blue) {
		setRed(red);
		setGreen(green);
		setBlue(blue);
		FIRST_RED_VALUE = this.red;
		FIRST_GREEN_VALUE = this.green;
		FIRST_BLUE_VALUE = this.blue;
		FIRST_RGB = this.red<<16 | this.green<<8 | this.blue;
	}
	
	public void setRed(int red) {
		if(red>=0 && red<=255)
			this.red = red;
	}
	
	public void setGreen(int green) {
		if(green>=0 && green<=255)
			this.green = green;
	}
	
	public void setBlue(int blue) {
		if(blue>=0 && blue<=255)
			this.blue = blue;
	}
	
	public int getRed() {
		return red;
	}
	
	public int getGreen() {
		return green;
	}
	
	public int getBlue() {
		return blue;
	}
	
	public void grayScaleConvert() {
		double gray = 0.2126 * red + 0.7152 * green + 0.0722 * blue;
		red = (int) gray;
		green = (int) gray;
		blue = (int) gray;
	}
	
	// public porque debe poder usarse desde fuera de esta clase, es decir desde UseRGBColor
	// RGBColor porque devuelve un apuntador a un objeto de la clase RGBColor
	// clone es el nombre del método
	public colorRGBClase clone() {
		return new colorRGBClase(red,green,blue); // crea un nuevo objeto RGBColor y regresa el apuntador a ese nuevo objeto
	}


	// public porque debe poder usarse desde fuera de esta clase, es decir desde UseRGBColor
	// boolean porque regresa verdadero o falso
	// equals es el nombre del método
	// o el argumento que es un apuntador a un objeto de cualquier clase
	public boolean equals(Object o) {
		if(o instanceof colorRGBClase) {		// Asegurar que el objeto es de la clase RGBColor
			colorRGBClase color = (colorRGBClase) o;	// Hacer que el apuntador al objeto sea de la clase RGBColor
			return color.red == this.red && 
					color.green == this.green && 
					color.blue == this.blue;
		}
		return false;	// o no es instancia de RGBColor
	}
	
	public String toString() {
		return "RGBColor:{" +
				"\"red\":"+red+","+
				"\"green\":"+green+","+
				"\"blue\":"+blue+","+
				"FIRST_RGB:"+String.format("%06X", FIRST_RGB)+"}";
	}




}

