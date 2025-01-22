package ThreadLocal_ForParallelTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 extends BaseClass {
	
	@Test
	public void testCase1 () {
		try {
			System.out.println(driver);
			driver.navigate().to("https://leetcode.com/");
			Thread.sleep(2500);
			System.out.println(driver.getTitle());
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
