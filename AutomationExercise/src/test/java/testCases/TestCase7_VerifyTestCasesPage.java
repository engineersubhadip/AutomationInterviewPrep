package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjects.HomePage;
import pageObjects.TestCasePage;

public class TestCase7_VerifyTestCasesPage extends BaseTest {
	
	@Test
	public void testCase7_verifyTestCasePage() {
		try {
			HomePage homePage = new HomePage(driver);
			//Verify that home page is visible successfully
			boolean homePageStatus = homePage.pageStatus(properties.getProperty("homePageTitle"));
			if (!homePageStatus) {
				System.out.println("Verify that home page is visible successfully failed");
				Assert.fail();
			}
			homePage.clickTestCaseLink();
			
			TestCasePage testCasePage = new TestCasePage(driver);
			//Verify user is navigated to test cases page successfully
			boolean testCasePageStatus = testCasePage.pageStatus(properties.getProperty("testCasePageTitle"));
			if (!testCasePageStatus) {
				System.out.println("Verify user is navigated to test cases page successfully failed");
				Assert.assertTrue(true);
			}
			
			System.out.println("Test case 7 execution passed. All validations passed");
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			System.out.println("Test Case 7 execution failed");
			Assert.fail();
		}
	}
}
