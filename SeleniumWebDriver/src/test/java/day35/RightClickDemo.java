package day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement button = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		Actions action = new Actions(driver);
		
		// Right Click using mouse
		action.contextClick(button).perform();
		Thread.sleep(1000);
		//Copy from menu
		driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']//li[3]//span")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
	}
}
