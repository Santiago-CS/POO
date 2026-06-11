public class ArreglosCreacionClonacion {


	public static void main(String[] args) {
		int[] a;
		
		a = new int[5];
		
		for(int i=0;i<5;i++)
			a[i] = i;
		
		int[] b = a;
		
		b[0] = 100;
		
		System.out.print("\na: ");
		for(int e:a)
			System.out.print(e+" ");
		
		
		int[] c = a.clone();
		c[0] = 0;
		
		System.out.print("\na: ");
		for(int e:a)
			System.out.print(e+" ");


		System.out.print("\nc: ");
		for(int e:c)
			System.out.print(e+" ");


	}


}

