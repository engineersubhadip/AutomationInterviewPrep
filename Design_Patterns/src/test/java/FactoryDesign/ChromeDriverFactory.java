package FactoryDesign;

import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory implements WebDriverFactory {
	@Override
	public ChromeDriver createWebDriver() {
		return new ChromeDriver();
	}
}
