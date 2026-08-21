package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstTestCase {

	public static void main(String[] args) {
		// 1. Launch the Browser

		// ChromeDriver driver = new ChromeDriver();
	//	WebDriver driver = new ChromeDriver(); // As WebDriver is a parent and chrome it's child
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// 2. Search the url
		// driver.get("https://google.com");
		driver.get("https://tutorialsninja.com/demo/");
		
		// 3. Validate the Url
		String act_url = driver.getTitle();
		
		if(act_url.equals("Swag Labs")) {
			System.out.println("Title matched and Test Passed");
		}else {
			System.out.println("Title not matched and Test Failed");
		}
		
		
		// 4. close browser
		
		//driver.close();
	//	driver.quit();
	}
}
