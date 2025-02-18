package FactoryDesign;

import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverFactory implements WebDriverFactory {
	@Override
	public EdgeDriver createWebDriver() {
		return new EdgeDriver();
	}

}
