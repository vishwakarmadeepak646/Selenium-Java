package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		Select s = new Select(driver.findElement(By.id("country")));
	//	s.selectByIndex(3);
	//	s.selectByValue("france"); 
		s.selectByVisibleText("France");
		
		// Capture optoins from dropdown
		
		List<WebElement> options = s.getOptions();
		System.out.println("Total number of options in dropdown : " + options.size());
		
		// printing the options 
		System.out.println("Below are the options listed in dropdown : ");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
			
		}
		
	}
}
