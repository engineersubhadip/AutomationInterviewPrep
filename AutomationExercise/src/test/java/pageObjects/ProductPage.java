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
	
	@FindBy(id="search_product")
	WebElement searchProduct;
	
	@FindBy(id="submit_search")
	WebElement searchButton;
	
	@FindBy(xpath = "//div[@class='features_items'] //div[@class='product-image-wrapper']")
	List<WebElement> productList;
	
	By productNameLoc = By.xpath("//div[@class='features_items']/div[@id='cartModal']/following-sibling::div //div[@class='single-products'] //p");
	@FindBy(xpath="//div[@class='features_items']/div[@id='cartModal']/following-sibling::div //div[@class='single-products'] //p")
	List<WebElement> productName;
	
	
	public void searchDesiredProduct(String item) {
		this.searchProduct.sendKeys(item);
	}
	
	public void clickSearchButton() {
		this.searchButton.click();
	}

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
	
	public boolean verifyProductName(String refName) {
		try {
			waitForElementToAppear(productNameLoc);
		} catch (Exception e) {
			return false;
		}
		for (int i=0; i<productName.size(); i++) {
			String currName = productName.get(i).getText();
			if (currName.toLowerCase().contains(refName.toLowerCase())) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

}
