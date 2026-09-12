package day43;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationDemo1 {

	@BeforeMethod
	void login() {
		System.out.println("Application login...");
	}

	@AfterMethod
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
