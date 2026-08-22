package day_28;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("selenium");
		driver.findElement(By.cssSelector("input.wikipedia-search-button")).click();

		List<WebElement> links = driver.findElements(By.id("wikipedia-search-result-link"));

		System.out.println("Totla searched links : " + links.size());

		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.linkText("Selenium in biology")).click();
		driver.findElement(By.linkText("Selenium (software)")).click();
		driver.findElement(By.linkText("Selenium disulfide")).click();
		driver.findElement(By.linkText("Selenium dioxide")).click();

		Set<String> ids = driver.getWindowHandles();

		for (String id : ids) {
			String url = driver.switchTo().window(id).getCurrentUrl();
			System.out.println(url);

			if (url.equals("https://en.wikipedia.org/wiki/Selenium_(software)")
					|| url.equals("https://en.wikipedia.org/wiki/Selenium_in_biology")) {
				driver.close();
			}

		}

		Thread.sleep(3000);
		driver.quit();
	}
}
