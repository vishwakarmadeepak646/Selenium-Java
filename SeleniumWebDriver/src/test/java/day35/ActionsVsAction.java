package day35;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
public class ActionsVsAction {

//	Actions : class, will be used to perform mouse actions,
//	Action :  interface, will be used to store created actions.
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement button = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		Actions action = new Actions(driver);
		
		// Right Click using mouse
		// We created but we do not perform any action  
		Action act = action.contextClick(button).build();  //Building/Creating an action and stored it in a variable
		Thread.sleep(1000);
		
		act.perform(); // Now here we perform action that is stored in act variable.
		
		
}
}
