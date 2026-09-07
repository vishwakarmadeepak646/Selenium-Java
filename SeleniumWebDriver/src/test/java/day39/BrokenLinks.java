package day39;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.xpath("//div[@id='maintext']//li//a"));
		System.out.println("Total number of links : " + links.size());

		int NumberOfBrokenLinks = 0;

		for (WebElement link : links) {

			// Capturing valid links

			String hrefAtt = link.getAttribute("href");

			if (hrefAtt == null || hrefAtt.isEmpty()) {
				System.out.println("href link is null so not possible to validate the link");
				continue;
			}

			// try hitting url on server
			try {
				URL url = new URL(hrefAtt); // Convert href String value to url
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.connect(); // Connect to server and sent request to server.

				if (conn.getResponseCode() >= 400) {
					System.out.println("Broken links --------->  " + hrefAtt + "\t Code: " + conn.getResponseCode());
					NumberOfBrokenLinks++;
				} else {
					System.out.println("Not Bronken links :" + hrefAtt);
				}

			} catch (Exception e) {

				// System.out.println(e.printStackTrace());
			}

		}
		System.out.println("Total broken links : " + NumberOfBrokenLinks);
	}
}
