package FactoryDesign;

public class SetDriver {
	WebDriverFactory setWebDriverFactory(String platform) {
		if (platform.equalsIgnoreCase("Chrome")) {
			return new ChromeDriverFactory();
		} else if (platform.equalsIgnoreCase("Edge")) {
			return new EdgeDriverFactory();
		} else {
			throw new RuntimeException("Platform not supported");
		}
	}
}
