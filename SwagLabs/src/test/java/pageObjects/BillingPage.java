package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BillingPage extends BasePage {

	public BillingPage(WebDriver driver) {
		super(driver);
	}

	public By billingPageTitleLoc = By.xpath("//span[contains(text(),'Checkout: Your Information')]");
	
	@FindBy(xpath = "//span[contains(text(),'Checkout: Your Information')]")
	WebElement billingPageTitle;
	
	@FindBy(xpath = "//input[@id='first-name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement zipCode;
	
	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueButton;
	
	public boolean billingPageDisplayStatus () {
		try {
			waitForElementToAppear(billingPageTitleLoc);
			return billingPageTitle.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void enterFirstName (String firstName) {
		this.firstName.sendKeys(firstName);
	}
	
	public void enterLastName (String lastName) {
		this.lastName.sendKeys(lastName);
	}
	
	public void enterZipCode (String zipCode) {
		this.zipCode.sendKeys(zipCode);
	}
	
	public void clickContinueButton () {
		this.continueButton.click();
	}
}
