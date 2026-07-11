package iteso.shapes2D;


public class Rectangle {
	private static int instancesCount = 0;
	public final int rectangleNumber;


	public static final double MIN_BASE = 1;
	public static final double MIN_HEIGHT = 1;	
	public static final double MAX_BASE = 100;
	public static final double MAX_HEIGHT = 100;
	
	private double base;
	private double height;
	private double posX;
	private double posY;
	
	// Constructores
	
	public Rectangle() {
		rectangleNumber = instancesCount;
		instancesCount++;
		base = MIN_BASE;
		height = MIN_HEIGHT;
		posX = 0.0;
		posY = 0.0;
	}
	
	public Rectangle(double side) {
		rectangleNumber = instancesCount;
		instancesCount++;
		setBase(side);
		setHeight(side);
	}
	
	public Rectangle(double base,double height) {
		rectangleNumber = instancesCount;
		instancesCount++;
		setBase(base);
		setHeight(height);
	}
	
	public Rectangle(double base,double height,double posX,double posY) {
		rectangleNumber = instancesCount;
		instancesCount++;
		setBase(base);
		setHeight(height);
		setPosX(posX);
		setPosY(posY);
	}
	
	
	// Setters, métodos para establecer los valores VÁLIDOS para los atributos
	public void setBase(double base) {
		if(base>0 && base<50)
			this.base = base;	// con this.base refiero al atributo base
								// de este objeto
	}
	
	public void setHeight(double height) {
		if(height>0 && height<50)
			this.height= height;
	}
	
	public void setPosX(double posX) {
		if(posX>=0 && posX<=1920)
			this.posX = posX;
	}


	public void setPosY(double posY) {
		if(posY>=0 && posY<=1080)
			this.posY = posY;
	}
	
	public void move(double dX,double dY) {
		setPosX(posX + dX);
		setPosY(posY + dY);
	}
	
	// Getters 
	public static int getInstancesCount() {
		return instancesCount;
	}
	
	
	public double getBase() {
		return base;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getPosX() {
		return posX;
	}
	
	public double getPosY() {
		return posY;
	}
	
	public static double getArea(double base,double height) {
		return base * height;
	}
	
	public double getArea() {
		return getArea(base,height);
	}
	
	public static double getPerimeter(double base,double height) {
		return 2 * base + 2 * height;
	}
	
	public double getPerimeter() {
		return getPerimeter(base,height);
	}
	
	public boolean isSquare() {
		return base == height;
	}
	
	public Rectangle clone() {
		return new Rectangle(base,height);
	}
	
	public boolean equals(Object o) {
		if(o instanceof Rectangle) {
			Rectangle r = (Rectangle) o;
			return r.getBase() == base && r.getHeight() == height;
		}
		return false;
	}
	
	public String toString() {
		return "Rectangle:{" +
				"\"rectangleNumber\":"+rectangleNumber+","+
				"\"base\":"+base+"," +
				"\"height\":" + height + 
				"}";
	}
}
