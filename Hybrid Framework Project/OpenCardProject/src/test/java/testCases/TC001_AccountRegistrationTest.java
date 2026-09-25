package testCases;

import BaseClasses.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = { "sanity", "master" })
	public void verify_account_registration() {
		try {
			logger.info("******Starting TC001_AccountRegistrationTest******");
			HomePage phome = new HomePage(driver);

			logger.info("Clicking on My Account");
			phome.clickMyAccount();
			logger.info("Clicking on Register");
			phome.clickRegister();

			AccountRegistrationPage acpage = new AccountRegistrationPage(driver);

			logger.info("Entering the details of Register form");
			acpage.setFirstName(randomString());
			acpage.setLastName(randomString());
			acpage.setEmail(randomString() + "@gmail.com");
			acpage.setTelephone(randomNumeric());

			String pass = randomAlphaNumeric();

			acpage.setPassword(pass);
			acpage.setCnfPassword(pass);
			logger.info("Clicking on policy check-box");
			acpage.clickPolicy();
			logger.info("Submmitting Register form");
			acpage.clickSubmt();

			String succText = acpage.compareSuccessText(); // "Your Account Has Been Created!

			if (succText.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test Failed...");
				logger.debug("Debug logs...");
				Assert.assertTrue(false);
			}

			logger.info("Validating expected message");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("******Finished TC001_AccountRegistrationTest******");

	}

}
