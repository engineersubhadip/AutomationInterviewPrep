package ThreadLocal_ForParallelTesting;

import org.openqa.selenium.WebDriver;

public class DriverManagement {
	
	private static ThreadLocal<WebDriver> tLocalDriver = new ThreadLocal<>();
	
	public static void setDriver (WebDriver driver) { // whichever thread is invoking this method, make the mapping corresponding to that thread
		tLocalDriver.set(driver);
	}
	
	public static WebDriver getDriver () { // whichever thread is invoking this method, get the driver corresponding to that thread
		return tLocalDriver.get();
	}
	
	public static void quitBrowser () { // whichever thread is invoking this method, get the driver and quit it and also remove the mapping
		tLocalDriver.get().quit();
		tLocalDriver.remove();
	}
}
