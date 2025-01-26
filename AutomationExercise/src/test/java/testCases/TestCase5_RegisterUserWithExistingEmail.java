package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjects.HomePage;
import pageObjects.SignUpLoginPage;

public class TestCase5_RegisterUserWithExistingEmail extends BaseTest {
	
	@Test
	public void testCase5_RegisterUserWithExistingEmail() {
		try {
			//HomePage
			HomePage homePage = new HomePage(driver);
			//Verify that home page is visible successfully
			boolean homePageStatus = homePage.pageStatus(properties.getProperty("homePageTitle"));
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
			//Verify 'New User Signup!' is visible
			boolean newUserSignUpStatus = signUpLoginPage.checkHeaderStatus();
			if (!newUserSignUpStatus) {
				System.out.println("Verify 'New User Signup!' is visible failed.");
				Assert.fail();
			}
			signUpLoginPage.enterSignUpName(properties.getProperty("validName"));
			signUpLoginPage.enterSignUpEmail(properties.getProperty("validEmail"));
			signUpLoginPage.clickSignUpButton();
			//Verify error 'Email Address already exist!' is visible
			boolean userAlreadyExistStatus = signUpLoginPage.checkUserAlreadyExists();
			if (!userAlreadyExistStatus) {
				System.out.println("Verify error 'Email Address already exist!' is visible failed");
				Assert.fail();
			}
			
			System.out.println("Test Case 5 Execution Passed. All validations passed.");
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			System.out.println("Test Case 5 Execution Failed.");
			Assert.fail();
		}
	}
}
