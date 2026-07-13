package iteso.animal;


public class Animal {
	private double weight;
	private double age;
	
	public Animal() {
		weight = 0.0;
		age = 0.0;
	}
	
	public Animal(double weight, double age) {
		setWeight(weight);
		setAge(age);
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setAge(double age) {
		this.age = age;
	}
	
	public void feed() {
		System.out.println("Animal está comiendo");
	}


	public void vaccine() {
		System.out.println("Aplicar vacunas al animal");
	}


	
	public void print() {
		System.out.println("Animal:{\"weight\":"+weight+",\"age\":"+age+"}");
	}
}
