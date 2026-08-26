package day32;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 1) count rows of table

//		List<WebElement> list = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size(); // 7
		// int rows = driver.findElements(By.tagName("tr")).size(); // 14 (In case of
		// multiple table it's not recommended
		System.out.println("Total no. of rows : " + rows);

		// 2) Count column of table

		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]/th")).size();
		System.out.println("Total no. of rows : " + cols);

		// 3) Read data from specific table box
		String s1 = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();
		System.out.println("5th row and 1 column value : " + s1);

		// 4) Read data from all rows and columns

		for (int r = 2; r < rows; r++) {
			for (int c = 1; c < cols; c++) {
				String s = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[" + c + "]"))
						.getText();
				System.out.print(s + "\t ");
			}
			System.out.println();
		}

		// 5) Print book name whose author is Mukesh
		System.out.println("\n---------Books name whose author is Mukesh-----------\n");
		for (int i = 2; i <= rows; i++) {
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]/td[2]")).getText();

			if (author.equals("Mukesh")) {
				String bName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]/td[1]"))
						.getText();
				System.out.println(bName);
			}

		}

		// 6) Capture each book price and total it
		int sum = 0;
		System.out.println("\n---------Capture each book price and total it-----------\n");
		for (int i = 2; i <= rows; i++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]/td[4]")).getText();

			System.out.println(price);
		//	sum = sum + Integer.valueOf(price);
			sum = sum + Integer.parseInt(price);
		}
		System.out.println("Total of books price : " + sum);

		Thread.sleep(3000);
		driver.quit();

	}

}
