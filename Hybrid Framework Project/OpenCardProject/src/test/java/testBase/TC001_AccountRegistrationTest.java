package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test
	public void verify_account_registration() {

		HomePage phome = new HomePage(driver);

		phome.clickMyAccount();
		phome.clickRegister();

		AccountRegistrationPage acpage = new AccountRegistrationPage(driver);

		acpage.setFirstName(randomString());
		acpage.setLastName(randomString());
		acpage.setEmail(randomString() + "@gmail.com");
		acpage.setTelephone(randomNumeric());

		String pass = randomAlphaNumeric();

		acpage.setPassword(pass);
		acpage.setCnfPassword(pass);
		acpage.clickPolicy();
		acpage.clickSubmt();

		String succText = acpage.compareSuccessText(); // "Your Account Has Been Created!

		Assert.assertEquals("Your Account Has Been Created!", succText);

	}

}
