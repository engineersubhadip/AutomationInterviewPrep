package SingletonDesign;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends BaseClass {
	
	@Test
	public void testCase1 () {
		try {
			System.out.println(driver+" from test 1");
			Thread.sleep(3500);
			System.out.println(driver.getTitle());
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
