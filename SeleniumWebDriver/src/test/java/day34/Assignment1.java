package day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@role='button']")).click();

		driver.findElement(By.linkText("Click here to enter your code"));
		driver.findElement(By.xpath("//input[@name='coupon_code']")).sendKeys("Indore");
		driver.findElement(By.xpath("//button[@name='apply_coupon']")).click();

		driver.findElement(By.id("travname")).sendKeys("Ram");
		driver.findElement(By.xpath("//input[@name='travlastname']")).sendKeys("sharma");

		// date picker

		driver.findElement(By.xpath("//input[@id='dob']")).click();

		Select year = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year.selectByVisibleText("2022");

		Select month = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month.selectByValue("4");

		List<WebElement> date = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));

		for (WebElement d : date) {

			if (d.getText().equals("23")) {
				d.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@id='sex_1']")).click();
		driver.findElement(By.xpath("//input[@id='addmorepax']")).click();
		driver.findElement(By.xpath("//span[@id='select2-addpaxno-container']")).click();
		
		WebElement checkbox = driver.findElement(By.xpath("//ul[@role='listbox']//li[3]"));
		checkbox.click();
	}
}