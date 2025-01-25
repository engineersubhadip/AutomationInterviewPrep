package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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
	
}
