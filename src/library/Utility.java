package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility {

	public static void captureScreenshot(WebDriver driver, String screenshotName){

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File ("./Screenshots/" + screenshotName + ".png"));
		} catch (WebDriverException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}


	}
	
}
		
		

