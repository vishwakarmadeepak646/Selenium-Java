package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		WebElement popup = driver.findElement(By.xpath("//div[@class='cb-close']"));
		
		if(popup.isDisplayed()) {
			popup.click();
		}
			
			//div[@class='cb-close']
		System.out.println("Go forward");
		WebElement sourceBank = driver.findElement(By.xpath("//li[@id='credit2']//a"));
		WebElement targetBank = driver.findElement(By.xpath("//ol[@id='bank']"));
		
		WebElement sourceSales = driver.findElement(By.linkText("SALES "));
		WebElement targetSales = driver.findElement(By.xpath("//ol[@id='loan']"));
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(sourceBank, targetBank).perform();
		action.dragAndDrop(sourceSales, targetSales).perform();
		System.out.println("Go forward");
	}
}
