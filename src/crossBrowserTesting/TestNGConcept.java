package crossBrowserTesting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGConcept {

	// In this class, I tested whether I could run a @Test method having a return
	// type and which is not void with
	// another @Test which has void return type.
	// Conclusion: Only the void @Test methods execution is shown in the execution
	// log of TestNG.

	// @Test(priority = 1)
	// public HashMap<String,String> test11() {
	//
	// String serverURL = "abcde";
	// String sessionID = "abcde12345";
	//
	// HashMap<String, String> tags = new HashMap<String, String>();
	// tags.put("serverUrl", serverURL);
	// tags.put("sessionId", sessionID);
	//
	// System.out.println("Testing test1");
	// return tags;
	//
	// }

	// @Test(priority = 1)
	// public void test1() {
	//
	// String serverURL = "abcde";
	// String sessionID = "abcde12345";
	//
	// HashMap<String, String> tags = new HashMap<String, String>();
	// tags.put("serverUrl", serverURL);
	// tags.put("sessionId", sessionID);
	//
	// System.out.println("Testing test1");
	// // return tags;
	//
	// }
	//
	// @Test(priority = 2)
	// public void test2() {
	//
	// System.out.println("Testing test2");
	//
	// }

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am at Before Suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am at Before Test");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I am at Before Class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am at Before Method");
	}

	@Test
	public void test() {
		System.out.println("I am at Test");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am at After Method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("I am at After Class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am at After Test");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am at After Suite");
	}

}
