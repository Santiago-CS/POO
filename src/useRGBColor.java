import colorRGBClase.colorRGBClase;


public class useRGBColor {


	public static void main(String[] args) {
		RGBColor c1 = new RGBColor();
		RGBColor c2 = new RGBColor(100,200,300);
		RGBColor c3 = new RGBColor(63,127,255);
		
		c1.setRed(c1.getRed()+50);
		c2.setGreen(c2.getGreen()+50);
		
		int tmp = c3.getBlue();
		c3.setBlue(c3.getGreen());
		c3.setGreen(tmp);
		
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		System.out.println("c3="+c3);
		System.out.println("Los primeros colores de c3 fueron:"+
				c3.FIRST_RED_VALUE+","+c3.FIRST_GREEN_VALUE+","+c3.FIRST_BLUE_VALUE);
		
		RGBColor c4 = c3.clone();


		c4.grayScaleConvert();
		System.out.println("c4="+c4);
	}


}
