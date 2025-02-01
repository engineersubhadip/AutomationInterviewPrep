package testCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;

public class TestCase12_AddProductToCart extends BaseTest {
	
	@Test
	public void testCase12_AddProductToCart() {
		try {
			HomePage homePage = new HomePage(driver);
			//Verify that home page is visible successfully
			boolean homePageStatus = homePage.pageStatus(properties.getProperty("homePageTitle"));
			if (!homePageStatus) {
				System.out.println("Verify that home page is visible successfully failed.");
				Assert.fail();
			}
			homePage.clickProductLink();
			
			ProductPage productPage = new ProductPage(driver);
			boolean productPageStatus = productPage.pageStatus(properties.getProperty("productPageTitle"));
			if (!productPageStatus) {
				System.out.println("Could not load product catalogue page");
				Assert.fail();
			}
			List<String> productBought = new ArrayList<>();
			productBought.add(productPage.clickAddToCart(4));
			productPage.clickContinueShoppingButton();
			productBought.add(productPage.clickAddToCart(5));
			productPage.clickViewCartFromPopUp();
			Thread.sleep(1000);
			
			CartPage cartPage = new CartPage(driver);
			boolean cartPageStatus = cartPage.pageStatus(properties.getProperty("cartPageTitle"));
			if (!cartPageStatus) {
				System.out.println("Cart Page could not be loaded.");
				Assert.fail();
			}
			//Verify both products are added to Cart
			boolean validateProductNameStatus = cartPage.validateProductName(productBought);
			if (!validateProductNameStatus) {
				System.out.println("Verify both products are added to Cart failed.");
				Assert.fail();
			}
			//Verify their prices, quantity and total price
			boolean validateProductPriceStatus = cartPage.validateProductPrice();
			if (!validateProductPriceStatus) {
				System.out.println("Verify their prices, quantity and total price");
				Assert.fail();
			}
			
			System.out.println("Test case 12 execution passed. All validations passed.");
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			System.out.println("Test case execution failed. "+e.getMessage());
			Assert.fail();
		}
	}
}
