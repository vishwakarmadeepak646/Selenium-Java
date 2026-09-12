package day43.pack;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {

	@Test
	void xyz() {
		System.out.println("C1- xyz method");
	}
	
	@BeforeTest
	void beforeTestMethod() {
		System.out.println("BeforeTest Method...");
	}
}
