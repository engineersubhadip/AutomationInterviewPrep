package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpLoginPage extends BasePage {

	public SignUpLoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//h2[contains(text(),'New User')]")
	WebElement newUserSignUp;
	
	@FindBy(xpath = "//input[@data-qa='signup-name']")
	WebElement signUpName;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement signUpEmail;

	@FindBy(xpath = "//button[@data-qa='signup-button']")
	WebElement signUpButton;
	
	@FindBy(xpath="//h2[contains(text(),'Login to your account')]")
	WebElement loginHeaderMessage;
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement loginEmail;
	
	@FindBy(xpath="//input[@data-qa='login-password']")
	WebElement loginPassword;
	
	@FindBy(xpath="//button[@data-qa='login-button']")
	WebElement loginButton;
	
	public boolean checkUserAlreadyExists() {
		String actualMessage = signUpEmail.findElement(By.xpath("./following-sibling::p")).getText();
		if (actualMessage.equalsIgnoreCase("Email Address already exist!")) {
			return true;
		}
		return false;
	}
	
	public boolean getIncorrectMessage() {
		String incorrectMessage = loginPassword.findElement(By.xpath("./following-sibling::p")).getText();
		if (incorrectMessage.equalsIgnoreCase("Your email or password is incorrect!")) {
			return true;
		}
		return false;
	}
	
	public boolean checkHeaderStatus () {
		return newUserSignUp.isDisplayed();
	}
	
	public boolean checkLoginHeaderMessageStatus () {
		return loginHeaderMessage.isDisplayed();
	}
	
	public void enterSignUpName(String name) {
		this.signUpName.sendKeys(name);
	}

	public void enterSignUpEmail(String email) {
		this.signUpEmail.sendKeys(email);
	}

	public void clickSignUpButton() {
		this.signUpButton.click();
	}
	
	public void enterLoginEmail(String email) {
		this.loginEmail.sendKeys(email);
	}
	
	public void enterLoginPassword(String password) {
		this.loginPassword.sendKeys(password);
	}
	
	public void clickLoginButton() {
		this.loginButton.click();
	}
}
