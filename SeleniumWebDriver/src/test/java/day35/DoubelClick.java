package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubelClick {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		WebElement box1 = driver.findElement(By.id("field1"));
		WebElement box2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

		Actions action = new Actions(driver);

		Thread.sleep(2000);
		box1.clear();
		box1.sendKeys("Deepak Don");
		box2.clear();
		Thread.sleep(2000);
		action.doubleClick(button).build().perform();
		
		//Validation : get Value of box and compare you are getting correct values or not
		
	//	String valueBox2  = box2.getText();  // Here we will not get any value bcz we changed value at run time and in DOM run time value not stored.
		String valueBox2  = box2.getAttribute("value"); // use this method to get value of any specific attribute like here we need html value attribute value.
		System.out.println("Value of box2 : " + valueBox2);
		
	//	String valueBox1 = box1.getText();
		String valueBox1  = box1.getAttribute("value");
		System.out.println("Value of box1 : "  + valueBox1); //// Here we will not get any value bcz we changed value at run time and in DOM run time value not stored.

	}
}
