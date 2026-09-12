package day43;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeClassAndAfterClass {

	@BeforeClass
	void login() {
		System.out.println("Application login...");
	}

	@AfterClass
	void logout() {
		System.out.println("Application Logout...");
	}

	@Test(priority = 1)
	void search() {
		System.out.println("basic search...");
	}

	@Test(priority = 2)
	void advSearch() {
		System.out.println("Adavance search login...");

	}
}
