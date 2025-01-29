package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjects.HomePage;
import pageObjects.ProductDetailPage;
import pageObjects.ProductPage;

public class TestCase8_VerifyAllProductsAndProductDetailPage extends BaseTest {
	
	@Test
	public void testCase8_VerifyAllProductsAndProductDetailPage () {
		try {
			HomePage homePage = new HomePage(driver);
			// Verify that home page is visible successfully
			boolean homePageStatus = homePage.pageStatus(properties.getProperty("homePageTitle"));
			if (!homePageStatus) {
				System.out.println("Verify that home page is visible successfully failed");
				Assert.fail();
			}
			homePage.clickProductLink();
			
			//Verify user is navigated to ALL PRODUCTS page successfully
			ProductPage productPage = new ProductPage(driver);
			boolean productPageStatus = productPage.pageStatus(properties.getProperty("productPageTitle"));
			if (!productPageStatus) {
				System.out.println("Verify user is navigated to ALL PRODUCTS page successfully");
				Assert.fail();
			}
			// The products list is visible
			boolean productListStatus = productPage.checkProductList();
			if (!productListStatus) {
				System.out.println("The products list is visible failed");
				Assert.fail();
			}
			productPage.clickViewProduct(1);
			
			ProductDetailPage productDetailPage = new ProductDetailPage(driver);
			boolean productDetailPageStatus = productDetailPage.pageStatus(properties.getProperty("productDetailPageTitle"));
			//User is landed to product detail page
			if (!productDetailPageStatus) {
				System.out.println("User is landed to product detail page failed");
				Assert.fail();
			}
			//Product Verfication
			boolean productNameStatus = productDetailPage.checkProductName();
			if (!productNameStatus) {
				System.out.println("Product Verfication failed. Product Name Verification failed");
				Assert.fail();
			}
			boolean productCategoryStatus =  productDetailPage.checkCategory();
			if (!productCategoryStatus) {
				System.out.println("Product Verfication failed. Product Category Verification failed");
				Assert.fail();
			}
			boolean productPriceStatus =  productDetailPage.checkPrice();
			if (!productPriceStatus) {
				System.out.println("Product Verfication failed. Product Price Verification failed");
				Assert.fail();
			}
			boolean productAvailabilityStatus =  productDetailPage.checkAvialability();
			if (!productAvailabilityStatus) {
				System.out.println("Product Verfication failed. Product Availability Verification failed");
				Assert.fail();
			}
			boolean productConditionStatus =  productDetailPage.checkCondition();
			if (!productConditionStatus) {
				System.out.println("Product Verfication failed. Product Condition Verification failed");
				Assert.fail();
			}
			boolean productBrandStatus =  productDetailPage.checkBrand();
			if (!productBrandStatus) {
				System.out.println("Product Verfication failed. Product Brand Verification failed");
				Assert.fail();
			}
			
			System.out.println("Test Case 8 Execution Passed. All Verifications Passed");
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			System.out.println("Test Case 8 Execution Failed. "+e.getMessage());
			Assert.fail();
		}
	}
}
