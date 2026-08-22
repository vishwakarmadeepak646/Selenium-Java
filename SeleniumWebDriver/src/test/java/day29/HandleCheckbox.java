package day29;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckbox {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// 1) To select specific checkbox

		driver.findElement(By.id("sunday")).click();

		// 2) To select multiple checkboxs

		List<WebElement> checkboxs = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

		/*
		 * for (int i = 0; i < checkboxs.size(); i++) { checkboxs.get(i).click(); }
		 */

		/*
		 * for (WebElement checkbox : checkboxs) { checkbox.click(); }
		 */

		// Select last 3 checkboxes
		/*
		 * for (int i = checkboxs.size() - 3; i < checkboxs.size(); i++) {
		 * checkboxs.get(i).click(); }
		 */

		// Select first 3 checkboxs
		/*
		 * for (int i = 0; i < 3; i++) { checkboxs.get(i).click(); }
		 */

		// un-select checkbox if they are selected

		for (int i = 0; i < 3; i++) {
			checkboxs.get(i).click();
		}

		Thread.sleep(3000);

		for (int i = 0; i < checkboxs.size(); i++) {

			if (checkboxs.get(i).isSelected()) {
				checkboxs.get(i).click();
			}
		}

		Thread.sleep(3000);
		driver.quit();
	}

}
