package fileUpload_Download_AutoIT;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload_multiple {

	@Test
	public void multipleFileUpload() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("file:///E:\\Selenium\\AutoIT\\fileUpload.html");

		driver.findElement(By.xpath("//*[@id='1']")).click();

		Runtime.getRuntime()
				.exec("E:\\Selenium\\AutoIT\\MultipleFileUpload.exe" + " " + "E:\\Selenium\\AutoIT\\Test1.pdf");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='1']")).click();

		Thread.sleep(3000);

		Runtime.getRuntime()
				.exec("E:\\Selenium\\AutoIT\\MultipleFileUpload.exe" + " " + "E:\\Selenium\\AutoIT\\Test2.txt");

	}
}