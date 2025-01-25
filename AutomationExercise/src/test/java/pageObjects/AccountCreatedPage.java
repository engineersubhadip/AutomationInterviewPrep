package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage {
	
	public AccountCreatedPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[contains(text(),'Account Created!')]")
	WebElement confirmationMessage;
	
	@FindBy(xpath="//div/a[text()='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//*[contains(text(),'Account Deleted!')]")
	WebElement deletionMessage;
	
	public boolean checkCreationHeaderMessage() {
		return confirmationMessage.isDisplayed();
	}
	
	public boolean checkDeletionHeaderMessage() {
		return deletionMessage.isDisplayed();
	}
	public void clickContinueButton() {
		this.continueButton.click();
	}
}
