package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage (WebDriver driver) {
		super(driver);
	}
	
	By loginPageTitleLoc = By.xpath("//div[@class='login_logo']");
	
	@FindBy(xpath = "//div[@class='login_logo']")
	WebElement loginPageTitle;
	
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginBtn;
	
	public boolean loginPageDisplayStatus () {
		try {
			waitForElementToAppear(loginPageTitleLoc);
			return loginPageTitle.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public void enterUserName (String userName) {
		this.userName.sendKeys(userName);
	}
	
	public void enterPassword (String password) {
		this.password.sendKeys(password);
	}
	
	public void clickLoginButton () {
		this.loginBtn.click();;
	}
}
