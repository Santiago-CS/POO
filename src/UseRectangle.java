import iteso.shapes2D.Rectangle;


public class UseRectangle {
	public static void main(String[] args) {
		
		System.out.println(Rectangle.getArea(20, 15));
		
		System.out.println(Rectangle.getInstancesCount());
		
		Rectangle r1 = new Rectangle(10,20);


		System.out.println(Rectangle.getInstancesCount());
		
		Rectangle r2 = new Rectangle(12);
		
		System.out.println(Rectangle.getInstancesCount());
		
		System.out.println(r1);
		System.out.println(r2);


	}
}
