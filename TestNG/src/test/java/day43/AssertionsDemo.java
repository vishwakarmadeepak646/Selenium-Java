package day43;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {

	@Test
	void titleMatchCheck() {

		String title1 = "Opencart";
		String title2 = "Demo";

		/*
		 * if(title1.equals(title2)) { System.out.println("Test Passed"); }else {
		 * System.out.println("Test Failed"); }
		 */

	//	Assert.assertEquals(title1, title2);

		if (title1.equals(title2)) {

			System.out.println("Test Passed");
			Assert.assertTrue(true);
		} else {
			System.out.println("Test Failed");
			Assert.assertTrue(false);
		}
	}
}
