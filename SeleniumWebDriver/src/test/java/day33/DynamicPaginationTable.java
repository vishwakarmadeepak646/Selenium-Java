package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencartmarketplace.com/d1/oc_demo/demo_2/admin/?utm_source=chatgpt.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//User login Id
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.clear();
		username.sendKeys("demo");

		// User password
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		pass.clear();
		pass.sendKeys("demo");

		//login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//User name drop-down
		driver.findElement(By.xpath("//a[@href='#collapse5']")).click();
		
		// Inner User name drop-down
		driver.findElement(By.xpath("//ul[@id='collapse5']/descendant::a[1]")).click();
		
		//Getting PageNo for Pagination
		String text = driver.findElement(By.xpath("//div[contains(text() ,'Showing')]")).getText(); // text where pageNo metioned
		System.out.println("Page No count String : " + text);
		int totalpages = Integer.parseInt( text.substring(text.indexOf("(") + 1 , text.indexOf("Pages")-1)); // extract index and convert string to int
		
		// clicking on page
		for(int p =1; p< 2; p++) { // p<2 = totalpages needs to pass but pageNo is 1900+ so not passing
			
			if(p>1) {
				
			WebElement pageNo =	driver.findElement(By.xpath("//ul[@class='pagination']//*[text()='"+p+"']"));
			pageNo.click();
			}
		}
		
		// To reading table data using loop
		int rows = driver.findElements(By.xpath("//div[@class='table-responsive']//tbody/tr")).size();
		System.out.println("Sr No\t" + "Customer name  |" + "\t\t Customer Email");
		
		for(int r=1; r<=rows; r++) {
			
		String cName = 	driver.findElement(By.xpath("//div[@class='table-responsive']//tbody/tr["+r+"]/td[2]")).getText();
		String email = driver.findElement(By.xpath("//div[@class='table-responsive']//tbody/tr["+r+"]/td[3]")).getText();
		
		System.out.println(r + "\t" + cName + "\t\t" +email);
		}
		
		
		
		
		
		Thread.sleep(3000);
		// driver.quit();
	}
}
