package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjects.HomePage;
import pageObjects.SignUpLoginPage;

public class TestCase4_LogoutUser extends BaseTest {
	
	@Test
	public void testCase4_LogoutUser() {
		try {
			//HomePage
			HomePage homePage = new HomePage(driver);
			boolean homePageStatus = homePage.pageStatus(properties.getProperty("homePageTitle"));
			//Verify that home page is visible successfully
			if (!homePageStatus) {
				System.out.println("Verify that home page is visible successfully failed");
				Assert.fail();
			}
			homePage.clickSignupLoginLink();
			
			//SignUpLoginPage
			SignUpLoginPage signUpLoginPage = new SignUpLoginPage(driver);
			boolean signUpLoginPageStatus = signUpLoginPage.pageStatus(properties.getProperty("signUpLoginPageTitle"));
			if (!signUpLoginPageStatus) {
				System.out.println("Could not load Sign Up Login Page.");
				Assert.fail();
			}
			//Verify 'Login to your account' is visible
			boolean loginHeaderMessageStatus = signUpLoginPage.checkLoginHeaderMessageStatus();
			if (!loginHeaderMessageStatus) {
				System.out.println("Verify 'Login to your account' is visible failed");
				Assert.fail();
			}
			signUpLoginPage.enterLoginEmail(properties.getProperty("validEmail"));
			signUpLoginPage.enterLoginPassword(properties.getProperty("validPassword"));
			signUpLoginPage.clickLoginButton();
			
			//HomePage
			boolean homePageRedirectStatus = homePage.pageStatus(properties.getProperty("homePageTitle"));
			if (!homePageRedirectStatus) {
				System.out.println("Could not redirect to Home Page.");
				Assert.fail();
			}
			//Verify that 'Logged in as username' is visible
			boolean loggedInStatus = homePage.checkUserLoginStatus("Logged in as "+properties.getProperty("validName"));
			if (!loggedInStatus) {
				System.out.println("Verify that 'Logged in as username' is visible failed");
				Assert.fail();
			}
			homePage.clickLogoutLink();
			
			//SignUpLoginPage
			boolean signUpLoginPageRedirectStatus = signUpLoginPage.pageStatus(properties.getProperty("signUpLoginPageTitle"));
			//Verify that user is navigated to login page
			if (!signUpLoginPageRedirectStatus) {
				System.out.println("Verify that user is navigated to login page failed");
				Assert.fail();
			}
			
			System.out.println("Test Case 4 Execution Passed. All validations passed");
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			System.out.println("Test Case 4 Execution failed.");
			Assert.fail();
		}
	}
}
