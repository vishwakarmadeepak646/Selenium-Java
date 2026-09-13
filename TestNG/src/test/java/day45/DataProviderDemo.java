package day45;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	WebDriver driver;

	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(dataProvider = "dp")
	void testLogin(String email, String pwd) {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		
		if (status == true) {
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
			Assert.assertTrue(true);
		}

		else {

			Assert.fail();
		}
	}

	@AfterClass
	void tearDown() {

		driver.close();
	}
	
	// Most of the time we pass excel sheet very rarely we pass hard coded or database
	
	@DataProvider(name="dp" ,  indices= {0,2,4}) // indices will run only 0 index and 4th one email id it is not a range.
	public Object[][] loginData() {               // we can pass return type String/Object but most of the time Object preferred bcz it accept all type of data
		
		Object  data [][] = {
				{"ravi123ravi@gmail.com" , "pass123"},
				{"xyz@example.com" , "pass123"},
				{"deepak@example.com" , "pass123"},
				{"ram@example.com" , "pass123"},
				{"shyam@example.com" , "pass123"},
				{"krish@example.com" , "pass123"},
				
		};
		
		return data;
	}
}
