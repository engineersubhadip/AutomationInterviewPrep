package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForTitleToAppear (String expTitle) {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(expTitle));
	}
	
	public void waitForElementToAppear (By Locator) {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}
}
