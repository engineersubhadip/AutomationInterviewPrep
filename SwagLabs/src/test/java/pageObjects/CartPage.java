package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
	
	public CartPage (WebDriver driver) {
		super(driver);
	}
	
	public By cartPageTitleLoc = By.xpath("//span[contains(text(),'Your Cart')]");
	
	@FindBy(xpath = "//span[contains(text(),'Your Cart')]")
	WebElement cartPageTitle;
	
	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkoutBtn;
	
	
	public boolean cartPageDisplayStatus () {
		try {
			waitForElementToAppear(cartPageTitleLoc);
			return cartPageTitle.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public void clickCheckoutButton () {
		this.checkoutBtn.click();
	}
}
