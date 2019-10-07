package fileUpload_Download_AutoIT;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {

	@Test(priority = 1, description = "This is for file upload using AutoIT executable.")
	public void upload() throws IOException, Exception {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.get("file:///E:\\Selenium\\AutoIT\\fileUpload.html");

		driver.get("https://www.naukri.com");

		driver.manage().window().maximize();

		// Handling multiple browser based pop-ups

		String parentWindow = driver.getWindowHandle();

		System.out.println("The Parent window handle is ===> " + parentWindow);

		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {

			if (!parentWindow.equals(window)) {

				System.out.println("<******************************>");

				System.out.println("Switching to window - > " + window);

				driver.switchTo().window(window);

				System.out.println("Closing the window ===> " + driver.switchTo().window(window).getTitle());

				driver.close();

				System.out.println("<******************************>");

			}

		}

		driver.switchTo().window(parentWindow);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='mTxt'][contains(text(),'Login')]")).click();

		// Switching to Login window and logging in

		String loginWindow = driver.getWindowHandle();

		driver.switchTo().window(loginWindow);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("krishanuc1001@gmail.com");

		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("alover1001");

		driver.findElement(By.xpath("//button[@value='Login']")).click();

		// Clicking on the Update button

		driver.findElement(By.xpath("//a[@class='btn btn-block btn-large white-text']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Clicking the Attach button and the Update button

		driver.findElement(By.xpath("//li[12]/a[@href='javascript:;' and @class='secondary-content']")).click();

		driver.findElement(By
				.xpath("//input[@id='attachCV'][@type='file'][@class='fileUpload waves-effect waves-light btn-large']"))
				.click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Runtime.getRuntime().exec("E:\\Selenium\\AutoIT\\ResumeUploader.exe");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.quit();

	}

}