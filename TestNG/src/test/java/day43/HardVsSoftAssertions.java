package day43;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {

//	@Test
	void hardAssertion() {

		System.out.println("testing");
		System.out.println("testing");

		Assert.assertEquals(123, 234); // If this assertion passed then rest print stmt will work if it's fail then rest stmt will not work.
										

		System.out.println("testing");
		System.out.println("testing");
	}

	@Test
	void softAssertion() {

		System.out.println("testing");
		System.out.println("testing");

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(123, 234);       // now we get all 4 print stmt.

		System.out.println("testing");
		System.out.println("testing");
		
		sa.assertAll(); // mandatory bcz bydefault it pass the method.
	}
}
