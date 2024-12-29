package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage {
	
	public OrderConfirmationPage (WebDriver driver) {
		super(driver);
	}
	
	public By orderConfirmPageTitleLoc = By.xpath("//span[contains(text(),'Checkout: Overview')]");
	
	@FindBy(xpath="//span[contains(text(),'Checkout: Overview')]")
	WebElement orderConfirmPageTitle;
	
	@FindBy(xpath = "//button[@id='finish']")
	WebElement finishButton;
	
	public boolean orderConfirmationPageDisplayStatus () {
		try {
			waitForElementToAppear(orderConfirmPageTitleLoc);
			return orderConfirmPageTitle.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickFinishButton () {
		this.finishButton.click();
	}
}
