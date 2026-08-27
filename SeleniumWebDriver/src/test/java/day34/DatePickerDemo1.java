package day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo1 {

	public static void selectFutureDate(WebDriver driver, String month, String year, String day) {

		// Method for selecting month and year from date picker
		while (true) {

			// Year webelement
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			// month webElement
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			if (currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // next

		}

		// Code selecting month and day
		List<WebElement> dates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));

		for (WebElement dt : dates) {

			if (dt.getText().equals(day)) {
				dt.click(); // selecting date
				break;
			}
		}

	}

	public static void selectPastDate(WebDriver driver, String month, String year, String day) {

		// Method for selecting month and year from date picker
		while (true) {

			// Year webelement
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			// month webElement
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			if (currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // previous
		}

		// Code selecting month and day
		List<WebElement> dates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));

		for (WebElement dt : dates) {

			if (dt.getText().equals(day)) {
				dt.click(); // selecting date
				break;
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.switchTo().frame(0);

		// Method-1 send date directly to input box
		// driver.findElement(By.id("datepicker")).sendKeys("08/05/2026"); //mm/dd/yyyy

		// click on date picker
		driver.findElement(By.id("datepicker")).click();

		// Method-2
		String year = "2024";
		String month = "January";
		String day = "1";

		// selectFutureDate(driver, month, year, day);
		selectPastDate(driver, month, year, day);
	}
}
