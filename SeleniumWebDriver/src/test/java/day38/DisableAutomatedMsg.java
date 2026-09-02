package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableAutomatedMsg {

	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		
		WebDriver driver = new ChromeDriver(option);
	
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		System.out.println("Title : " + driver.getTitle());
		
		
	}
}
