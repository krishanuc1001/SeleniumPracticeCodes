package selPackage_3_4;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionScripts_soft {
	
	
	@Test
	public void softAssertMethod()
	{
	
		/*
		 *  This is Soft assertion. Class SoftAssert is used. We have to create an Object of this class.
		 *  We have to use the object thereafter to perform any assertion statement.
		 *  
		 *  Even if the assertion statement fails, the script execution will not stop,
		 *  but the test case /test method will fail as a whole after the execution completes.
		 *  
		 *  Also, we must use assertAll() at the end.
		 *  
		 */
		
		
		SoftAssert assertObj = new SoftAssert();
		System.out.println("Test has started");
		assertObj.assertEquals(12, 13, "The count does not match !!");
		System.out.println("Test has ended");
		assertObj.assertAll();
		
	}

}
