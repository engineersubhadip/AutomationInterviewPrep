package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjects.ContactUsFormPage;
import pageObjects.HomePage;

public class TestCase6_ContactUsForm extends BaseTest {
	
	@Test
	public void testCase6_ContactUsForm() {
		try {
			HomePage homePage = new HomePage(driver);
			//Verify that home page is visible successfully
			boolean homePageStatus = homePage.pageStatus(properties.getProperty("homePageTitle"));
			if (!homePageStatus) {
				System.out.println("Verify that home page is visible successfully failed");
				Assert.fail();
			}
			homePage.clickContactUsLink();
			
			ContactUsFormPage contactUsPage = new ContactUsFormPage(driver);
			boolean contactUsPageStatus = contactUsPage.pageStatus(properties.getProperty("contactUsPageTitle"));
			if (!contactUsPageStatus) {
				System.out.println("Could not load Contact Us Page Form");
				Assert.fail();
			}
			// Verify 'GET IN TOUCH' is visible
			boolean getInTouchHeaderMessageStatus = contactUsPage.getInTouchHeaderMessage();
			if (!getInTouchHeaderMessageStatus) {
				System.out.println("Verify 'GET IN TOUCH' is visible failed");
				Assert.fail();
			}
			contactUsPage.enterName(generateRandomString());
			Thread.sleep(500);
			contactUsPage.enterEmail(generateRandomString()+"@sify.com");
			Thread.sleep(500);
			contactUsPage.enterSubject(generateRandomString());
			Thread.sleep(500);
			contactUsPage.enterMessage(generateRandomString());
			Thread.sleep(500);
			contactUsPage.uploadFile(properties.getProperty("filePath"));
			Thread.sleep(500);
			contactUsPage.clickSubmitButton();
			Thread.sleep(500);
			contactUsPage.clickOKAlert();
			//Verify success message 'Success! Your details have been submitted successfully.' is visible
			boolean successMessageStatus = contactUsPage.checkUploadSuccessMessage();
			if (!successMessageStatus) {
				System.out.println("Verify success message 'Success! Your details have been submitted successfully.' is visible failed");
				Assert.fail();
			}
			Thread.sleep(500);
			contactUsPage.clickHomeButton();
			
			//verify that landed to home page successfully
			boolean homePageRedirect = homePage.pageStatus(properties.getProperty("homePageTitle"));
			if (!homePageRedirect) {
				System.out.println("Verify that landed to home page successfully failed");
				Assert.fail();
			}
			System.out.println("Test case 6 Execution Passed. All validations passed");
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			System.out.println("Test Case 6 Execution failed");
			Assert.fail();
		}
	}
}
