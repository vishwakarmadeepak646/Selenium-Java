package day45;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class ParamTest {  // To run this class use xml file  it will not run using class.
 
	WebDriver driver;

	@BeforeClass
    @Parameters({"browser"})
	void setUp(String br) throws InterruptedException {
		
		switch(br.toLowerCase()) {
		case "chrome" : driver = new ChromeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		default :System.out.print("Invalid browser"); return;
		
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
	//	Thread.sleep(5000);
	}

	@Test(priority = 2)
	void logo() throws InterruptedException {
		Thread.sleep(3000);
		boolean logo = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(logo, true);

	}

	@Test(priority = 1)
	void url() {
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 3)
	void title() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@AfterClass
	void tearDown() {

		driver.quit();
	}
}
