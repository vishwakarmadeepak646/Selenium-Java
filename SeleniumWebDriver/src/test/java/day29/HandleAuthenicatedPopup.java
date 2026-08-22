package day29;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAuthenicatedPopup {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
	//	driver.get("http://the-internet.herokuapp.com/basic_auth");  // This will not work so we have to pass username and pass in side url
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	//	driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	}
}
