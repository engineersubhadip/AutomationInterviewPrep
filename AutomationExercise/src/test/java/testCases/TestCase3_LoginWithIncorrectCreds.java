package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjects.HomePage;
import pageObjects.SignUpLoginPage;

public class TestCase3_LoginWithIncorrectCreds extends BaseTest {
	
	@Test
	public void testCase3_LoginWithIncorrectCreds() {
		try {
			HomePage homePage = new HomePage(driver);
			boolean homePageStatus = homePage.pageStatus(properties.getProperty("homePageTitle"));
			//Verify that home page is visible successfully
			if (!homePageStatus) {
				System.out.println("Home Page cannot be loaded.");
				Assert.fail();
			}
			homePage.clickSignupLoginLink();	
			
			SignUpLoginPage signUpLoginPage = new SignUpLoginPage(driver);
			boolean signUpLoginPageStatus = signUpLoginPage.pageStatus(properties.getProperty("signUpLoginPageTitle"));
			if (!signUpLoginPageStatus) {
				System.out.println("Sign Up Login Page is not visible.");
				Assert.fail();
			}
			//Verify 'Login to your account' is visible
			boolean loginHeaderMessageStatus = signUpLoginPage.checkLoginHeaderMessageStatus();
			if (!loginHeaderMessageStatus) {
				System.out.println("Verify 'Login to your account' is visible failed");
				Assert.fail();
			}
			signUpLoginPage.enterLoginEmail(properties.getProperty("email"));
			signUpLoginPage.enterLoginPassword(properties.getProperty("password"));
			signUpLoginPage.clickLoginButton();
			
			//Verify error 'Your email or password is incorrect!' is visible
			boolean incorrectMessageStatus = signUpLoginPage.getIncorrectMessage();
			if (!incorrectMessageStatus) {
				System.out.println("Verify error 'Your email or password is incorrect!' is visible failed");
				Assert.fail();
			}
			
			System.out.println("Test Case 3 Execution successfull. All Validations Passed");
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			System.out.println("Test Case 3 Execution failed "+e.getMessage());
			Assert.fail();
		}
	}
}
