package SingletonDesign;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 extends BaseClass {

	@Test
	public void testCase2() {
		try {
			System.out.println(driver + " from test case 2");
			Thread.sleep(3500);
			System.out.println(driver.getTitle());
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
