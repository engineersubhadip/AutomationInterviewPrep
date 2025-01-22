package ThreadLocal_ForParallelTesting;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver; // by making this non static we are ensuring each thread gets its own driver
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browser) {
		if (browser.toLowerCase().contains("chrome")) {
			DriverManagement.setDriver(new ChromeDriver());
			driver = DriverManagement.getDriver();
		} else if (browser.toLowerCase().contains("edge")) {
			DriverManagement.setDriver(new EdgeDriver());
			driver = DriverManagement.getDriver();
		} else {
			return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
	}
	
	@AfterClass
	public void tearDown () {
		DriverManagement.quitBrowser();
	}
}
