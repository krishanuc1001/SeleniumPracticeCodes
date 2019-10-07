package Interface;

public class AdvanceCalc implements Calc {

	public static void main(String[] args) {

		// Child class reference and Child class object
		AdvanceCalc obj = new AdvanceCalc();

		// Base class reference and Child class object, a child class implements a base
		// class
		Calc obj1 = new AdvanceCalc();

		// Invalid scenario 1: We cannot create an object of an Interface
		Calc obj2 = new Calc();

		// Invalid scenario 2: A Base class cannot implement a Child class
		AdvanceCalc obj3 = new Calc();

		obj.add();
		obj.subtract();
		obj.calcSin();
		obj.calcCos();

		obj1.add();
		obj1.subtract();
	}

	public void calcSin() {
		System.out.println("I am in calcSin() method");
	}

	public void calcCos() {
		System.out.println("I am in calcCos() method");
	}

	public void add() {
		System.out.println("I am in add() method");
	}

	public void subtract() {
		System.out.println("I am in subtract() method");
	}

}
