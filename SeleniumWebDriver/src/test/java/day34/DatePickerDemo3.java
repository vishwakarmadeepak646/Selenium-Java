package day34;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo3 {

	// This is just a demo code it will not work bcz on automation Website is changed
	// This code we use where Month not in dropdown but year is in dropdown refer excel sheet Demo 3 image.

	// User define method to convert String month to Object Month
	static Month convertMonth(String month) {

		HashMap<String, Month> monthObj = new HashMap<String, Month>();

		monthObj.put("January", Month.JANUARY);
		monthObj.put("Fabuary", Month.FEBRUARY);
		monthObj.put("March", Month.MARCH);
		monthObj.put("April", Month.APRIL);
		monthObj.put("May", Month.MAY);
		monthObj.put("June", Month.JUNE);
		monthObj.put("July", Month.JULY);
		monthObj.put("August", Month.AUGUST);
		monthObj.put("September", Month.SEPTEMBER);
		monthObj.put("Obtober", Month.OCTOBER);
		monthObj.put("November", Month.NOVEMBER);
		monthObj.put("December", Month.DECEMBER);

		Month monthOb = monthObj.get("March");

		if (monthObj == null) {
			System.out.println("Invalid Month...");
		}
		return monthOb;

	}

	public static void selectDate(WebDriver driver, String requiredYear, String requiredMonth, String requiredDate) {

		// select year
		WebElement yearDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear = new Select(yearDropDown);
		selectYear.selectByVisibleText(requiredYear);

		// select month

		while (true) {

			String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			// convert requiredMonth & displayMonth in to Month Objects
			Month expectedMonth = convertMonth(requiredMonth);
			Month currentMonth = convertMonth(displayMonth);

			// compare
			int result = expectedMonth.compareTo(currentMonth); // It will return 1,0,-1

			// 0 means Month are equal
			// > 0 means Future Month
			// <0 means past month

			if (result < 0) { // past
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();

			}

			else if (result > 0) // future

				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

			else {

				break;

			}

			// date selection
			List<WebElement> allDates = driver
					.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

			for (WebElement dt : allDates) {
				if (dt.getText().equals(requiredDate))

					dt.click();
				break;
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// input DOB
		String requiredYear = "2021";
		String requiredMonth = "June";
		String requiredDate = "15";

		driver.switchTo().frame("frame-one796456169");
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();

		selectDate(driver, requiredYear, requiredMonth, requiredDate);

	}
}
