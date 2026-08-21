package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {
	
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Declaration 
				
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		//condition
		WebElement txtUserName =  mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Username']")));
		txtUserName.sendKeys("Admin");
		
		WebElement txtPassword = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']"))); // It return the WebElement
		txtPassword.sendKeys("admin123");
		
		WebElement button  = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));
		button.click();
		
		driver.quit();
	}

}
