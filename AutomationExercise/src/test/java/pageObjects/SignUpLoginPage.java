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
	
	public boolean checkHeaderStatus () {
		return newUserSignUp.isDisplayed();
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
}
