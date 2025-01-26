package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjects.AccountCreatedPage;
import pageObjects.HomePage;
import pageObjects.SignUpLoginPage;

public class TestCase2_LoginUserWithCorrectCreds  extends BaseTest {
	
	@Test
	public void testCase2_LoginUserWithCorrectCreds () {
		try {
			HomePage homePage = new HomePage(driver);
			boolean homePageStatus = homePage.pageStatus(properties.getProperty("homePageTitle"));
			// Verify that home page is visible successfully
			if (!homePageStatus) {
				System.out.println("Verify that home page is visible successfully failed");
				Assert.fail();
			}
			homePage.clickSignupLoginLink();
			
			SignUpLoginPage signUpLoginPage = new SignUpLoginPage(driver);
			boolean signUpLoginPageStatus = signUpLoginPage.pageStatus(properties.getProperty("signUpLoginPageTitle"));
			if (!signUpLoginPageStatus) {
				System.out.println("Sign Up login Page cannot be loaded.");
				Assert.fail();
			}
			// Verify 'Login to your account' is visible
			boolean loginHeaderMessageStatus = signUpLoginPage.checkLoginHeaderMessageStatus();
			if (!loginHeaderMessageStatus) {
				System.out.println("Verify 'Login to your account' is visible failed");
				Assert.fail();
			}
			signUpLoginPage.enterLoginEmail(properties.getProperty("email"));
			signUpLoginPage.enterLoginPassword(properties.getProperty("password"));
			signUpLoginPage.clickLoginButton();
			
			boolean homePageRedirectStatus = homePage.pageStatus(properties.getProperty("homePageTitle"));
			if (!homePageRedirectStatus) {
				System.out.println("Could not redirect to Home Page after entering the Credentials.");
				Assert.fail();
			}
			
			//Verify that 'Logged in as username' is visible
			String userLoggedInString = "Logged in as "+properties.getProperty("userName");
			boolean userLoginStatus = homePage.checkUserLoginStatus(userLoggedInString);
			if (!userLoginStatus) {
				System.out.println("Verify that 'Logged in as username' is visible failed");
				Assert.fail();
			}
			
			homePage.clickDeleteAccountButton();
			
			//Verify that 'ACCOUNT DELETED!' is visible
			AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
			boolean accountCreatedPageStatus = accountCreatedPage.pageStatus(properties.getProperty("accountCreationPageTitle"));
			if (!accountCreatedPageStatus) {
				System.out.println("Could not redirect to Account Creation Page.");
				Assert.fail();
			}
			
			boolean accountDeletionHeaderMessageStatus = accountCreatedPage.checkDeletionHeaderMessage();
			if (!accountDeletionHeaderMessageStatus) {
				System.out.println("Verify that 'ACCOUNT DELETED!' is visible failed");
				Assert.fail();
			}
			System.out.println("Test Case Execution Success. All Validations successfull.");
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("Test Case 2 Execution Failed "+e.getMessage());
			Assert.fail();
		}
	}
}
