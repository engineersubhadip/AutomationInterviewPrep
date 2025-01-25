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
	
	@FindBy(xpath="//a[contains(@href,'delete')]/i")
	WebElement deleteAccountLink;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[last()]")
	WebElement loggedInUser;
	
	public void clickSignupLoginLink() {
		this.signUpLoginLink.click();
	}
	
	public void clickDeleteAccountButton() {
		this.deleteAccountLink.click();
	}
	
	public boolean checkUserLoginStatus(String userString) {
		String currentValue = this.loggedInUser.getText();
		currentValue = currentValue.trim();
		if(currentValue.equals(userString)) {
			return true;
		}
		return false;
	}
}
