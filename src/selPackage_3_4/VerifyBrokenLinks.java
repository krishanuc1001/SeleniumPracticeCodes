package selPackage_3_4;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyBrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_3_3\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.freecrm.com");

		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(3000);

		driver.findElement(By.xpath(".//input[@value='Login']")).click();

		driver.switchTo().frame("mainpanel");

		// links: //a href="http://......"
		// images: //img href="

		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));

		System.out.println("The total number of links and images are: " + links.size());

		// activeLinks are the ones which do not have null href property.
		List<WebElement> activeLinks = new ArrayList<WebElement>();

		// iterate the Links and exclude all the links/images which does not have any
		// href attribute

		for (int i = 0; i < links.size(); i++) {

			// System.out.println(links.get(i).getAttribute("href"));
			String href_url = links.get(i).getAttribute("href");
			if (href_url != null && (href_url.contains("javascript") == false)) {
				activeLinks.add(links.get(i));
			}
		}

		System.out.println(
				"The number of Active links and images which have href attribute and do not contain 'javascript' are: "
						+ activeLinks.size());

		// check the link and image URL's having href attribute, with HttpURLConnection
		// api of java.net package
		for (int j = 0; j < activeLinks.size(); j++) {

			try {
				URL url = new URL(activeLinks.get(j).getAttribute("href"));

				// We have to cast the url object and open the connection

				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setConnectTimeout(3000);
				connection.connect();
				String response = connection.getResponseMessage();

				// Gets the HTTP response message, if any, returned along with the response code
				// from a server.
				// From responses like:
				// HTTP/1.0 200 OK
				// HTTP/1.0 404 Not Found
				//
				// Extracts the Strings "OK" and "Not Found" respectively.
				// Returns null if none could be discerned from the responses (the result was
				// not valid HTTP).
				// Returns:the HTTP response message, or nullThrows:IOException - if an error
				// occurred connecting to the server.

				// System.out.println(activeLinks.get(j).getAttribute("href") + "=======>" +
				// response);

				if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					System.out.println(activeLinks.get(j).getAttribute("href") + "======>" + response);
				}
				if (connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
					System.out.println(activeLinks.get(j).getAttribute("href") + "======>" + response);
				}
				connection.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// driver.quit();
	}
}

// Mukesh Otwani code

// public static void verifyLinkActive(String linkUrl)
// {
// try
// {
// URL url = new URL(linkUrl);
//
// HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
//
// httpURLConnect.setConnectTimeout(3000);
//
// httpURLConnect.connect();
//
// if(httpURLConnect.getResponseCode()==200)
// {
// System.out.println(linkUrl +" - "+ httpURLConnect.getResponseMessage());
// }
// if(httpURLConnect.getResponseCode()== HttpURLConnection.HTTP_NOT_FOUND)
// {
// System.out.println(linkUrl+" - "+ httpURLConnect.getResponseMessage() + " -
// "+ HttpURLConnection.HTTP_NOT_FOUND);
// }
// } catch (Exception e) {
//
// }
// }
// }