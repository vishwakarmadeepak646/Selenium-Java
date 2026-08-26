package day32;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.name("q")).sendKeys("selenium");
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='aajZCb']//ul[@role='listbox']//li"));
		System.out.println("Size of auto suggested name : " + list.size());

		for (WebElement op : list) {

			if (op.getText().equals("selenium rich foods") || op.getText().equals("Selenium rich foods")) {
				Thread.sleep(3000);
				System.out.println("Search result is :" + op.getText());
				op.click();
				break;

			}
			System.out.println(op.getText());
		}

		Thread.sleep(3000);
		driver.quit();
	}
}
