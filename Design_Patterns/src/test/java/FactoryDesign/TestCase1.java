package FactoryDesign;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestCase1 {
	
	@Test
	public void testCase1() {
		SetDriver driver = new SetDriver();
		WebDriverFactory driverFactory = driver.setWebDriverFactory("Chrome");
		WebDriver newDriver =  driverFactory.createWebDriver();
		newDriver.get("https://www.google.com/");
	}
}
