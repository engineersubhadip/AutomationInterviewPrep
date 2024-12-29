package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThankYouPage extends BasePage {
	
	public ThankYouPage (WebDriver driver) {
		super(driver);
	}
	
	public By thankYouPageTitleLoc = By.xpath("//span[@class='title']");
	
	@FindBy(xpath = "//span[@class='title']")
	WebElement thankYouPageTitle;
	
	@FindBy(xpath = "//h2[normalize-space()='Thank you for your order!']")
	WebElement confirmationMessage;
	
	public boolean thankYouPageDisplayStatus () {
		try {
			waitForElementToAppear(thankYouPageTitleLoc);
			return thankYouPageTitle.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean displayStatus () {
		try {
			Thread.sleep(4000);
			return confirmationMessage.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
