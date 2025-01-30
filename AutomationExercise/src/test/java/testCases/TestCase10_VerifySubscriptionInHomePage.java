package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjects.HomePage;

public class TestCase10_VerifySubscriptionInHomePage extends BaseTest {
	
	@Test
	public void testCase10_VerifySubscriptionInHomePage() {
		try {
			HomePage homePage = new HomePage(driver);
			// Verify that home page is visible successfully
			boolean homePageStatus = homePage.pageStatus(properties.getProperty("homePageTitle"));
			if (!homePageStatus) {
				System.out.println("Verify that home page is visible successfully failed");
				Assert.fail();
			}
			homePage.scrollToFooter();
			boolean subscriptionText = homePage.checkSubscriptionText();
			//Verify text 'SUBSCRIPTION'
			if (!subscriptionText) {
				System.out.println("Verify text 'SUBSCRIPTION' failed");
				Assert.fail();
			}
			homePage.enterSubscriptionEmail(properties.getProperty("validEmail"));
			homePage.clickSubscribeButton();
			boolean subscriptionAlertStatus = homePage.checkSubscriptionAlertText(properties.getProperty("subscriptionTextAlert"));
			//Verify success message 'You have been successfully subscribed!' is visible
			if (!subscriptionAlertStatus) {
				System.out.println("Verify success message 'You have been successfully subscribed!' is visible failed");
				Assert.fail();
			}
			System.out.println("Test Case 10 Execution passed. All Validations passed.");
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			System.out.println("Test case 10 execution failed. "+e.getMessage());
			Assert.fail();
		}
	}
}
