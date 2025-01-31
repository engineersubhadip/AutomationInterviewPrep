package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public WebDriver driver;
	private JavascriptExecutor js;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)driver;
	}
	
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
	
	
	public boolean pageStatus(String title) {
		try {
			waitForTitleToAppear(title);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void waitForTitleToAppear(String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void waitForElementToAppear(By Locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}
	
	public void selectValue(WebElement target, String value, String parameter) {
		List<WebElement> list= driver.findElements(By.xpath("//select[@id='"+parameter+"'] //option"));
		Optional<WebElement> tarWebElement =  list.stream().filter(currEle -> {
			String currValue = currEle.getText();
			if (currValue.equals(value)) {
				return true;
			}
			return false;
		}).findAny();
		
		if (tarWebElement.isPresent()) {
			Select select = new Select(target);
			select.selectByVisibleText(value);
		}
	}
	

	public void scrollToFooter() {
		js.executeScript("footer.scrollIntoView()");
	}
	
	public boolean checkSubscriptionText() {
		return subscriptionText.isDisplayed();
	}
	
	public void enterSubscriptionEmail(String email) {
		this.subscribeEmail.sendKeys(email);
	}
	
	public void clickSubscribeButton() {
		this.subscribeButton.click();
	}
	
	public boolean checkSubscriptionAlertText(String userText) {
		try {
			waitForElementToAppear(subscriptionAlertLoc);
			String currText = subscriptionAlert.getText();
			if (currText.equalsIgnoreCase(userText)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
