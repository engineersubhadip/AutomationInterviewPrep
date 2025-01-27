package pageObjects;

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
