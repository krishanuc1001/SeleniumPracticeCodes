package crossBrowserTesting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestNGBase {

	@Parameters({ "name", "surname" })
	@BeforeClass
	public void setUp(String name, String surname) {

		System.out.println("**********************************************");
		System.out.println("This is setUp.");
		System.out.println("My name is " + name + " " + surname);
		System.out.println("**********************************************");

	}

	@AfterClass
	public void tearDown() {

		System.out.println("**********************************************");
		System.out.println("This is tearDown.");
		System.out.println("**********************************************");

	}

}
