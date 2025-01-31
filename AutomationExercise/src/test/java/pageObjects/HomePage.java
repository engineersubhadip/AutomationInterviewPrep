package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Signup')]")
	WebElement signUpLoginLink;

	@FindBy(xpath = "//a[contains(@href,'delete')]/i")
	WebElement deleteAccountLink;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li[last()]")
	WebElement loggedInUser;

	@FindBy(xpath = "//a[contains(@href,'logout')]")
	WebElement logoutLink;

	@FindBy(xpath = "//a[contains(@href,'contact')]")
	WebElement contactUsLink;
	
	@FindBy(xpath="//li/a[contains(@href,'test_cases')]")
	WebElement testCaseLink;
	
	@FindBy(xpath="//ul[contains(@class,'navbar')]//a[contains(@href,'products')]")
	WebElement productLink;
	
	@FindBy(id="footer")
	WebElement footerSection;
	
	@FindBy(xpath="//footer[@id='footer'] //h2")
	WebElement subscriptionText;
	
	@FindBy(id="susbscribe_email")
	WebElement subscribeEmail;
	
	@FindBy(id="subscribe")
	WebElement subscribeButton;
	
	By subscriptionAlertLoc = By.xpath("//div[@id='success-subscribe']/div");
	@FindBy(xpath="//div[@id='success-subscribe']/div")
	WebElement subscriptionAlert;
	
	public void clickContactUsLink() {
		this.contactUsLink.click();
	}

	public void clickSignupLoginLink() {
		this.signUpLoginLink.click();
	}

	public void clickLogoutLink() {
		this.logoutLink.click();
	}

	public void clickDeleteAccountButton() {
		this.deleteAccountLink.click();
	}
	
	public void clickTestCaseLink() {
		this.testCaseLink.click();
	}
	
	public void clickProductLink() {
		this.productLink.click();
	}

	public boolean checkUserLoginStatus(String userString) {
		String currentValue = this.loggedInUser.getText();
		currentValue = currentValue.trim();
		userString = userString.trim();
		if (currentValue.equals(userString)) {
			return true;
		}
		return false;
	}

	
}
