package day26;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		String title = driver.getTitle();
		System.out.println("Title of the page : " + title);

		String url = driver.getCurrentUrl();
		System.out.println("Currnet page URL : " + url);

		String pageSource = driver.getPageSource();
		// System.out.println("Page Source : " + pageSource);

		String winId = driver.getWindowHandle();
		System.out.print("Window Id : " + winId + " ,"); // It return dynamic id that's keep changing

		driver.findElement(By.partialLinkText("OrangeHRM, Inc")).click(); // It open another window

		Set<String> multWindID = driver.getWindowHandles();  // It return multiple windows in set as it contains unique value
		System.out.println(multWindID);

		/*
		 * for (String winIds : multWindID) { System.out.println(winIds); }
		 */

		driver.quit();

	}
}
