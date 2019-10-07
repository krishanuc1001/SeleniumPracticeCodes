package selPackage_3_4;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionScripts_hard {

	@Test(priority = 1)
	public void assertMethod1() {
		Assert.assertEquals(12, 13);
	}

	/*
	 * 
	 * This is Hard Assertion where if an Assert statement fails, the next line of
	 * code will not be executed.
	 * 
	 */

	@Test(priority = 2)
	public void assertMethod2() {
		System.out.println("Test case 2 started");
		Assert.assertEquals(10, 13, "This message will be displayed only if assertion fails !!");
		System.out.println("Test case 2 ended");
	}

	@Test(priority = 3)
	public void assertMethod3() {
		System.out.println("Test case 3 started");
		Assert.assertEquals("Hello", "Hello", "This message will be displayed only if assertion fails !!");
		System.out.println("Test case 3 ended");
	}

	@Test(priority = 3)
	public void assertMethod4() {
		String myName = "Krishanu";
		Assert.assertTrue(myName.contains("Krish"));
	}

}