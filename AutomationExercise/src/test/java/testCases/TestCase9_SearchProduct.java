package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjects.HomePage;
import pageObjects.ProductPage;

public class TestCase9_SearchProduct extends BaseTest {
	
	@Test
	public void testCase9_SearchProduct() {
		try {
			HomePage homePage = new HomePage(driver);
			// Verify that home page is visible successfully
			boolean homePageStatus = homePage.pageStatus(properties.getProperty("homePageTitle"));
			if (!homePageStatus) {
				System.out.println("Verify that home page is visible successfully failed");
				Assert.fail();
			}
			homePage.clickProductLink();
			
			ProductPage productPage = new ProductPage(driver);
			boolean productPageStatus = productPage.pageStatus(properties.getProperty("productPageTitle"));
			//Verify user is navigated to ALL PRODUCTS page successfully
			if (!productPageStatus) {
				System.out.println("Verify user is navigated to ALL PRODUCTS page successfully failed");
				Assert.fail();
			}
			productPage.searchDesiredProduct(properties.getProperty("targetProduct"));
			productPage.clickSearchButton();
			boolean productSearchStatus = productPage.verifyProductName(properties.getProperty("targetProduct"));
			// Verify all the products related to search are visible
			if (!productSearchStatus) {
				System.out.println("Verify all the products related to search are visible failed");
				Assert.fail();
			}
			System.out.println("Test Case 9 Execution Passed. All validations passed.");
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			System.out.println("Test Case 9 Execution Failed. "+e.getMessage());
			Assert.fail();
		}
	}
}
