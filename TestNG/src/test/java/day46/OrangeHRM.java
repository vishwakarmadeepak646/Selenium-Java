package day46;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

// @Listeners(day46.MyListner.class)  --- If not run using xml then use this or uncomment it
public class OrangeHRM {
	WebDriver driver;

	@BeforeClass
	void setUp() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().window().maximize();

	}

	@Test(priority = 2)
	void logo() throws InterruptedException {
		Thread.sleep(3000);
		boolean logo = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(logo, true);

	}

	@Test(priority = 1)
	void url() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/we.php/auth/login");
	}

	@Test(priority = 3, dependsOnMethods = "url")
	void title() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@AfterClass
	void tearDown() {

		driver.quit();
	}
}
