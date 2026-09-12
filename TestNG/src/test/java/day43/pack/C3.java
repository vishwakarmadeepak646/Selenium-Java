package day43.pack;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {

	@Test
	void xyz() {
		System.out.println("C3- pqr method");
	}
	
	@BeforeSuite
	void beforeSuiteMthod() {
		System.out.println("Before Suite Method...");
	}
	
	@AfterSuite
	void afterSuiteMethod() {
		System.out.println("After Suite Method...");
	}

}
