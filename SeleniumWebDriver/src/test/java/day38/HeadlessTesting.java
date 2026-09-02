package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");   // Browser Setting for headless mode execution

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://tutorialsninja.com/demo/");

		String act_url = driver.getTitle();
		
		if (act_url.equals("Your Store")) {
			System.out.println("Title matched and Test Passed");
		} else {
			System.out.println("Title not matched and Test Failed");
		}

	}
}
