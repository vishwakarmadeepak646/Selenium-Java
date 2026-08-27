package day33;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> listcount = driver.findElements(By.xpath("//ul[@id='pagination']//li"));
		int totalpage = listcount.size();
		System.out.println("Total pages : " + totalpage);
		List<WebElement> checkbox = driver.findElements(By.xpath("//table[@id='productTable']//tbody//input"));
		System.out.println("Total checkbox : " + checkbox.size());

		for (int p = 1; p <= totalpage + 1; p++) {

			if (p > 1 && p <= totalpage) {

				driver.findElement(By.xpath("//ul[@id='pagination']//a[text()='" + p + "']")).click();
				System.out.println("-----------------");
			}

			for (int i = 1; i <= 5; i++) {

				for (int j = 1; j <= 5; j++) {

					if (j < 4) {
						String str = driver
								.findElement(
										By.xpath("//table[@id='productTable']//tbody//tr[" + i + "]//td[" + j + "]"))
								.getText();
						System.out.print(str + "\t");

					}

				}
				System.out.println();

				driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + i + "]//td/input")).click();

			}

		}
	}
}