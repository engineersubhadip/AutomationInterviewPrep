package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsFormPage extends BasePage {

	public ContactUsFormPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='contact-form']/h2")
	WebElement getInTouchHeaderMessage;

	@FindBy(xpath = "//input[@data-qa='name']")
	WebElement name;

	@FindBy(xpath = "//input[@data-qa='email']")
	WebElement email;

	@FindBy(xpath = "//input[@data-qa='subject']")
	WebElement subject;

	@FindBy(id = "message")
	WebElement message;

	@FindBy(xpath = "//input[@name='upload_file']")
	private WebElement uploadButton;
	
	@FindBy(xpath="//input[@data-qa='submit-button']")
	private WebElement submitButton;

	By fileUploadSuccessMessageLoc = By.xpath("//div[@class='contact-form'] //div[contains(@class,'alert-success')]");
	@FindBy(xpath = "//div[@class='contact-form'] //div[contains(@class,'alert-success')]")
	WebElement fileUploadSuccessMessage;

	@FindBy(xpath="//div[@id='form-section']/a")
	WebElement homeButton;
	
	public boolean getInTouchHeaderMessage() {
		try {
			return getInTouchHeaderMessage.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void enterName(String userName) {
		this.name.sendKeys(userName);
	}
	
	public void enterEmail(String userEmail) {
		this.email.sendKeys(userEmail);
	}
	
	public void enterSubject(String userSubject) {
		this.subject.sendKeys(userSubject);
	}
	
	public void enterMessage(String userMessage) {
		this.message.sendKeys(userMessage);
	}
	
	public void uploadFile(String userFilePath) {
		uploadButton.sendKeys(userFilePath);
	}
	
	public void clickSubmitButton() {
		this.submitButton.click();
	}

	public void clickOKAlert() {
		driver.switchTo().alert().accept();
	}

	public boolean checkUploadSuccessMessage() {
		try {
			waitForElementToAppear(fileUploadSuccessMessageLoc);
			return fileUploadSuccessMessage.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickHomeButton() {
		this.homeButton.click();
	}
}
