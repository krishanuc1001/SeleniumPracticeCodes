package polymorphism;

public class CompileTimePolymorphism {

	public static void main(String[] args) {

		CompileTimePolymorphism ctp = new CompileTimePolymorphism();
		ctp.add(1, 1);
		ctp.add(1, 1, 1);
		ctp.add(1, 1.5);
		ctp.add(2.5, 1);	
	}

	/*
	 * Java will not allow to write the same method name with the same signature.
	 * Signature is the number, type and order of the arguments. 
	 * By having different signature only, Method overloading is achieved in Java.
	 * Compile-time polymorphism is achieved using Method Overloading. 
	 */

	/*
	 * Number of args are different
	 */
	public void add(int a, int b)
	{
		int sum1 = a + b;
		System.out.println("The sum1 is: " + sum1);
	}

	public void add(int a, int b, int c)
	{
		int sum2 = a + b + c;
		System.out.println("The sum2 is: " + sum2);
	}

	/*
	 * Type of args are different
	 */
	public void add(int a, double b)
	{
		double sum3 = a + b;
		System.out.println("The sum3 is: " + sum3);
	}

	/*
	 * Order of args are different
	 */
	public void add(double b, int a)
	{
		double sum4 = a + b;
		System.out.println("The sum4 is: " + sum4);
	}
}
