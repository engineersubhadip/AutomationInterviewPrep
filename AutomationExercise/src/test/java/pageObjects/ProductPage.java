package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
	private JavascriptExecutor js;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor)driver;
	}

	@FindBy(xpath = "//div[@class='features_items'] //div[@class='product-image-wrapper']")
	List<WebElement> productList;

	public boolean checkProductList() {
		return productList.size() > 0;
	}

	public void clickViewProduct(int count) {
		if (productList.size() > 0 && count < productList.size()) {
			List<WebElement> product = driver.findElements(By.xpath("//div[@class='features_items'] //div[@class='product-image-wrapper'] //a[contains(@href,'product_details')]"));
			WebElement target = product.get(count);
			js.executeScript("arguments[0].click()", target);
		}
	}

}
