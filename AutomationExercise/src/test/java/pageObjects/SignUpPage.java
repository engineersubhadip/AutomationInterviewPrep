package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {
	
	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//b[contains(text(),'Enter Account')]")
	WebElement headerMessage;
	
	@FindBy(id="id_gender1")
	WebElement mrRadio;
	
	@FindBy(id="id_gender2")
	WebElement mrsRadio;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(id="days")
	WebElement day;
	
	@FindBy(id="months")
	WebElement month;
	
	@FindBy(id="years")
	WebElement year;
	
	@FindBy(xpath="//input[@id='newsletter']")
	WebElement clickNewsPaperYES;
	
	@FindBy(xpath="//input[@id='optin']")
	WebElement clickReceiveSpecialOffers;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="last_name")
	WebElement lastName;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="address2")
	WebElement address2;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="zipcode")
	WebElement zipCode;
	
	@FindBy(id="mobile_number")
	WebElement phoneNumber;
	
	@FindBy(xpath="//button[contains(text(),'Create')]")
	WebElement createAccountButton;
	
	public boolean checkHeaderMessage () {
		return headerMessage.isDisplayed();
	}
	public void clickTitle () {
		this.mrRadio.click();
	}
	
	public void enterPassword (String password) {
		this.password.sendKeys(password);
	}
	
	public void enterDay(String userDay) {
		super.selectValue(this.day, userDay, "days");
	}
	
	public void enterMonth(String userMonth) {
		super.selectValue(this.month, userMonth, "months");
	}
	
	public void enterYear(String userYear) {
		super.selectValue(this.year, userYear, "years");
	}
	
	public void clickSignUpNews() {
		this.clickNewsPaperYES.click();;
	}
	
	public void clickSpecialOffers() {
		this.clickReceiveSpecialOffers.click();
	}
	
	public void enterFirstName (String firstName) {
		this.firstName.sendKeys(firstName);
	}
	
	public void enterLastName (String lastName) {
		this.lastName.sendKeys(lastName);
	}
	
	public void enterCompany(String companyName) {
		this.company.sendKeys(companyName);
	}
	
	public void enterAddress1(String address1) {
		this.address1.sendKeys(address1);
	}
	
	public void enterAddress2(String address2) {
		this.address2.sendKeys(address2);
	}
	
	public void enterCountry (String userCountry) {
		super.selectValue(country, userCountry, "country");
	}
	
	public void enterState (String userState) {
		this.state.sendKeys(userState);
	}
	
	public void enterCity (String city) {
		this.city.sendKeys(city);
	}
	
	public void enterZipCode (String zipCode) {
		this.zipCode.sendKeys(zipCode);
	}
	
	public void enterPhoneNumber (String phoneNumber) {
		this.phoneNumber.sendKeys(phoneNumber);
	}
	
	public void clickCreateAccount () {
		this.createAccountButton.click();
	}
}
