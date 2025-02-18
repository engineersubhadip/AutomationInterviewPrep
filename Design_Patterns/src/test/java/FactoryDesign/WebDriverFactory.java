package FactoryDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;

public interface WebDriverFactory {
	
	WebDriver createWebDriver();
}
