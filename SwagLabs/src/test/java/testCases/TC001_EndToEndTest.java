package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseTest.BaseTest;
import pageObjects.BillingPage;
import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.OrderConfirmationPage;
import pageObjects.ProductPage;
import pageObjects.ThankYouPage;

public class TC001_EndToEndTest extends BaseTest {
	
	@Test
	public void validate_EndToEndTest () {
		
		System.out.println("**** Started TC001_EndToEndTest Execution *****");
		SoftAssert sf = new SoftAssert();
		
		try {
			LoginPage loginPage = new LoginPage(driver);

			sf.assertEquals(loginPage.loginPageDisplayStatus(), true);
			
			loginPage.enterUserName(properties.getProperty("userName"));
			loginPage.enterPassword(properties.getProperty("password"));
			loginPage.clickLoginButton();
			
			ProductPage productPage = new ProductPage(driver);
			sf.assertEquals(productPage.productPageDisplayStatus(), true);
			
			productPage.addToCart(properties.getProperty("itemNeeded"));
			productPage.clickCartIcon();
			
			CartPage cartPage = new CartPage(driver);
			sf.assertEquals(cartPage.cartPageDisplayStatus(), true);
			
			cartPage.clickCheckoutButton();
			
			BillingPage billingPage = new BillingPage(driver);
			sf.assertEquals(billingPage.billingPageDisplayStatus(), true);
			
			billingPage.enterFirstName(properties.getProperty("firstName"));
			billingPage.enterLastName(properties.getProperty("lastName"));
			billingPage.enterZipCode(properties.getProperty("zipCode"));
			billingPage.clickContinueButton();
			
			OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
			sf.assertEquals(orderConfirmationPage.orderConfirmationPageDisplayStatus(), true);
			
			orderConfirmationPage.clickFinishButton();
			
			ThankYouPage thankYouPage = new ThankYouPage(driver);
			sf.assertEquals(thankYouPage.thankYouPageDisplayStatus(), true);
			
			sf.assertEquals(thankYouPage.displayStatus(), true);
			
			sf.assertAll();
			
		} catch (Exception e) {
			System.out.println("Test case failed "+e.getMessage());
			Assert.fail();
		}
		
		System.out.println("**** Finished TC001_EndToEndTest Execution *****");
	}
}
