package day36;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkNewTabKeyboardAction {
	
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		WebElement signUp = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[4]//a"));
		
		Actions action = new Actions(driver);
		
		// This will perfrom Ctrl + Click on signUp element
		action.keyDown(Keys.CONTROL).click(signUp).keyUp(Keys.CONTROL).perform();
		
		//It will convert Set to List for window handler
		List<String> list = new ArrayList(driver.getWindowHandles());
		
		driver.switchTo().window(list.get(1)); // switch to new open window
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Deepak");
		driver.findElement(By.xpath("//form[@action='/signup']//input[3]")).sendKeys("Deepak@gmail.com");
		
	}

}
