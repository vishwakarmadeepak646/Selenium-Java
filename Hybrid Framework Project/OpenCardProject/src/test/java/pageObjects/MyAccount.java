package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {

	public MyAccount(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Change your password']")
	WebElement changePasswordText;

	@FindBy(xpath = "(//a[@class='list-group-item'][normalize-space()='Logout'])[1]")
	WebElement logout;

	public boolean isMyAccountDisplayed() {
		try {
			return changePasswordText.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLogout() {
		logout.click();
	}
}
