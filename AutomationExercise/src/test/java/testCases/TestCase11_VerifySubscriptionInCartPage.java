package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjects.CartPage;
import pageObjects.HomePage;

public class TestCase11_VerifySubscriptionInCartPage extends BaseTest {
	
	@Test
	public void testCase11_VerifySubscriptionInCartPage() {
		try {
			HomePage homePage = new HomePage(driver);
			//Verify that home page is visible successfully
			boolean homePageStatus = homePage.pageStatus(properties.getProperty("homePageTitle"));
			if (!homePageStatus) {
				System.out.println("Verify that home page is visible successfully failed");
				Assert.fail();
			}
			homePage.clickCartLink();
			
			CartPage cartPage = new CartPage(driver);
			boolean cartPageStatus = cartPage.pageStatus(properties.getProperty("cartPageTitle"));
			if (!cartPageStatus) {
				System.out.println("Cannot load Cart Page");
				Assert.fail();
			}
			
			cartPage.scrollToFooter();
			//Verify text 'SUBSCRIPTION'
			boolean subscriptionTextStatus = cartPage.checkSubscriptionText();
			if (!subscriptionTextStatus) {
				System.out.println("Verify text 'SUBSCRIPTION'");
				Assert.fail();
			}
			cartPage.enterSubscriptionEmail(properties.getProperty("validEmail"));
			cartPage.clickSubscribeButton();
			//Verify success message 'You have been successfully subscribed!' is visible
			boolean subscriptionMessageStatus = cartPage.checkSubscriptionAlertText(properties.getProperty("subscriptionTextAlert"));
			if (!subscriptionMessageStatus) {
				System.out.println("Verify success message 'You have been successfully subscribed!' is visible failed.");
				Assert.fail();
			}
			
			System.out.println("Test Case 11 Execution Passed. All Validations passed.");
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			System.out.println("Test Case 11 Execution Failed. "+e.getMessage());
			Assert.fail();
		}
	}
}
