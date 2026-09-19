package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClasses.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;

public class TC002_LoginAccountTest extends BaseClass {

	@Test(groups= {"sanity", "regression","master"})
	public void verify_Login() {

		logger.info("*********TC002_LoginAccountTest Execution started**********");
		try {
			// Home Page
			logger.info("Click on My Account");
			HomePage h = new HomePage(driver);
			h.clickMyAccount();
			logger.info("Click on Login");
			h.clickLogin();

			// Login Page
			logger.info("Entering credentials");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			logger.info("Click on Login button");
			lp.clickLogin_btn();

			// My Account page
			MyAccount ac = new MyAccount(driver);
			boolean val = ac.isMyAccountDisplayed();

			Assert.assertTrue(val);
			logger.info("User loing successfully");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Login failed");
			logger.debug("Debus logs...");
			Assert.fail();

		}
		logger.info("*********TC002_LoginAccountTest Execution Finished**********");
	}
}
