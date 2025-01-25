package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjects.AccountCreatedPage;
import pageObjects.HomePage;
import pageObjects.SignUpLoginPage;
import pageObjects.SignUpPage;

public class TestCase1_RegisterUser extends BaseTest {
	
	@Test
	public void testCase1_RegisterUser () {
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
				System.out.println("Sign Up Login Page not displayed.");
				Assert.fail();
			}
			//Verify 'New User Signup!' is visible
			boolean headerStatus = signUpLoginPage.checkHeaderStatus();
			if (!headerStatus) {
				System.out.println("Verify 'New User Signup!' is visible failed");
				Assert.fail();
			}
			String userSignUpName = generateRandomString();
			signUpLoginPage.enterSignUpName(userSignUpName);
			Thread.sleep(500);
			signUpLoginPage.enterSignUpEmail(generateRandomString()+"@gmail.com");
			Thread.sleep(500);
			signUpLoginPage.clickSignUpButton();
			
			SignUpPage signUpPage = new SignUpPage(driver);
			boolean signUpPageStatus = signUpPage.pageStatus(properties.getProperty("signUpPageTitle"));
			if (!signUpPageStatus) {
				System.out.println("Sign Up Page is not displayed.");
				Assert.fail();
			}
			//Verify that 'ENTER ACCOUNT INFORMATION' is visible
			boolean signUpHeaderStatus = signUpPage.checkHeaderMessage();
			if (!signUpHeaderStatus) {
				System.out.println("Verify that 'ENTER ACCOUNT INFORMATION' failed");
				Assert.fail();
			}
			signUpPage.clickTitle();
			Thread.sleep(500);
			signUpPage.enterPassword(generateRandomString());
			Thread.sleep(500);
			signUpPage.enterDay(generateRandomDay());
			Thread.sleep(500);
			signUpPage.enterMonth("September");
			Thread.sleep(500);
			signUpPage.enterYear("2003");
			Thread.sleep(500);
			signUpPage.clickSignUpNews();
			Thread.sleep(500);
			signUpPage.clickSpecialOffers();
			Thread.sleep(500);
			signUpPage.enterFirstName(generateRandomString());
			Thread.sleep(500);
			signUpPage.enterLastName(generateRandomString());
			Thread.sleep(500);
			signUpPage.enterCompany(generateRandomString());
			Thread.sleep(500);
			signUpPage.enterAddress1(generateRandomString());
			Thread.sleep(500);
			signUpPage.enterAddress2(generateRandomString());
			Thread.sleep(500);
			signUpPage.enterCountry("Singapore");
			Thread.sleep(500);
			signUpPage.enterState(generateRandomString());
			Thread.sleep(500);
			signUpPage.enterCity(generateRandomString());
			Thread.sleep(500);
			signUpPage.enterZipCode(generateRandomNumber());
			Thread.sleep(500);
			signUpPage.enterPhoneNumber(generateRandomNumber());
			Thread.sleep(500);
			signUpPage.clickCreateAccount();
			
			AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
			boolean accountCreationPageStatus = accountCreatedPage.pageStatus(properties.getProperty("accountCreationPageTitle"));
			if (!accountCreationPageStatus) {
				System.out.println("Account Creation Page not displayed");
				Assert.fail();
			}
			boolean accountCreationHeaderMessage = accountCreatedPage.checkCreationHeaderMessage();
			// Verify that 'ACCOUNT CREATED!' is visible
			if (!accountCreationHeaderMessage) {
				System.out.println("Verify that 'ACCOUNT CREATED!' is visible failed");
				Assert.fail();
			}
			accountCreatedPage.clickContinueButton();
			
			//Verify that 'Logged in as username' is visible
			boolean homePageStatusRedirect = homePage.pageStatus(properties.getProperty("homePageTitle"));
			if (!homePageStatusRedirect) {
				System.out.println("Could not land in Home Page after clicking on Continue");
				Assert.fail();
			}
			String userLoginString = " Logged in as "+userSignUpName;
			userLoginString = userLoginString.trim();
			boolean userLoggedConfirm = homePage.checkUserLoginStatus(userLoginString);
			if (!userLoggedConfirm) {
				System.out.println("Verify that 'Logged in as username' is visible failed");
				Assert.fail();
			}
			homePage.clickDeleteAccountButton();
			boolean accountCreationPageRedirect = accountCreatedPage.pageStatus(properties.getProperty("accountCreationPageTitle"));
			if (!accountCreationPageRedirect) {
				System.out.println("Account Creation Page cannot be redirected into");
				Assert.fail();
			}
			boolean deletionHeaderStatus = accountCreatedPage.checkDeletionHeaderMessage();
			// Verify that 'ACCOUNT DELETED!' is visible
			if (!deletionHeaderStatus) {
				System.out.println("Verify that 'ACCOUNT DELETED!' is visible failed");
				Assert.fail();
			}
			accountCreatedPage.clickContinueButton();
		} catch (Exception e) {
			System.out.println("Test Case 1 Execution Failed "+e.getMessage());
			Assert.fail();
		}
	}
}
