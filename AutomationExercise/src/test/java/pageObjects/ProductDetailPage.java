package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage {
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='product-information']/h2")
	WebElement productName;
	
	@FindBy(xpath="//div[@class='product-information']/h2/following-sibling::p[contains(text(),'Category')]")
	WebElement productCategory;
	
	@FindBy(xpath="//div[@class='product-information']/span/span")
	WebElement price;
	
	@FindBy(xpath="//div[@class='product-information']/span/following-sibling::p[1]")
	WebElement availability;
	
	@FindBy(xpath="//div[@class='product-information']/span/following-sibling::p[2]")
	WebElement condition;
	
	@FindBy(xpath="//div[@class='product-information']/span/following-sibling::p[3]")
	WebElement brand;
	
	private boolean checkValidProduct(String product) {
		product = String.join("", product.split(" "));
		if (product.length() < 1) {
			return false;
		}
		for (int i=0; i<product.length(); i++) {
			char currChar = product.charAt(i);
			int currASCII = (int)currChar;
			if ((currASCII >= 65 && currASCII <= 90) || (currASCII >= 97 && currASCII <= 122)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkProductName() {
		if (productName.isDisplayed() == true) {
			String product = productName.getText();
			boolean productStatus = checkValidProduct(product);
			return productStatus;
		} else {
			return false;
		}
	}
	
	private boolean checkValidCategory(String category) {
		String categoryName = String.join("",category.split("[:]")[1].split(" "));
		if (categoryName.length() > 1) {
			return true;			
		} else {
			return false;
		}
	}
	
	
	public boolean checkCategory() {
		if (productCategory.isDisplayed() == true) {
			String category = productCategory.getText();
			boolean checkCategoryStatus = checkValidCategory(category);
			if (checkCategoryStatus) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	private boolean checkValidPrice(String price) {
		String priceAmount = price.split(" ")[1];
		if (priceAmount.charAt(0) == '0') {
			return false;
		}
		for (int i=0; i<priceAmount.length(); i++) {
			char currChar = priceAmount.charAt(i);
			if (currChar >= '0' && currChar <= '9') {
				continue;
			} 
			return false;
		}
		return true;
	}
	
	public boolean checkPrice() {
		if (price.isDisplayed()) {
			String priceAmount = price.getText();
			boolean priceStatus = checkValidPrice(priceAmount);
			if (priceStatus) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}
	
	public boolean checkAvialability() {
		if (availability.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public boolean checkCondition() {
		if (condition.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public boolean checkBrand() {
		if (brand.isDisplayed()) {
			return true;
		}
		return false;
	}
}
