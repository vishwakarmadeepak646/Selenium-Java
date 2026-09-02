package day36;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabAndWindows {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//It introduced Selenium 4.X versions 
		
//		driver.switchTo().newWindow(WindowType.TAB); // Open in New Tab
		
		driver.switchTo().newWindow(WindowType.WINDOW); // This will open in New Browser
		driver.get("https://automationexercise.com/");
		
	}
}


