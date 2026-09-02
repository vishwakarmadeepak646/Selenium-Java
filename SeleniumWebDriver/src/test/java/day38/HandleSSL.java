package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSL {

	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		
		System.out.println("Title of website : " + driver.getTitle()); // Before :  privacy error
																		// After :  expired.badssl.com
		
		
	}
}
