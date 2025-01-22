package SingletonDesign;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	private DriverManagement driverManager;
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void setUp (String browser, String url) {
		driverManager = DriverManagement.getInstance();
		driverManager.setDriver(browser);
		driver = driverManager.getDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
	}
	
	@AfterClass
	public void tearDown () {
		driverManager.quitBrowser();
	}
}
