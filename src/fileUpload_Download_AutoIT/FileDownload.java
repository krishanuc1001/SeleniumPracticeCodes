package fileUpload_Download_AutoIT;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileDownload {
	
	@Test
	public void fileDownload() throws IOException {
		
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.seleniumhq.org/download/");
		
		Runtime.getRuntime().exec("E:\\Selenium\\AutoIT\\DownloadFileAutoITScript.exe");
		
	}

}
