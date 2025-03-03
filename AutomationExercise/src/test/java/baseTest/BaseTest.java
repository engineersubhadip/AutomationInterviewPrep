package baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import threadSafe.DriverManagement;
import threadSafe.PropertyManagement;

public class BaseTest {
	protected WebDriver driver;
	protected Properties properties;
	private DriverManagement driverManagement;
	private PropertyManagement propertyManagement;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browserName) throws IOException {
		
		// Loading the Properties File :-
		propertyManagement = PropertyManagement.getInstance();
		String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		propertyManagement.setProperty(filePath);
		properties = propertyManagement.getProperty();
		
		//Loading the Driver :-
		driverManagement = DriverManagement.getInstance();
		driverManagement.setDriver(browserName);
		
		driver = driverManagement.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().setSize(new Dimension(1440, 900));
		driver.manage().window().maximize();
		driver.get(properties.getProperty("browserURL"));
	}

	@AfterClass
	public void tearDown() {
		driverManagement.quitBrowser();
		propertyManagement.quitProperty();
	}

	public String generateRandomString() {
		String result = "";
		for (int i = 0; i < 10; i++) {
			int currASCII = 97 + (int) (Math.random() * (122 - 97 + 1));
			char currChar = (char) currASCII;
			result += currChar;
		}
		return result;
	}

	public String generateRandomNumber() {
		String result = "";
		for (int i = 0; i < 10; i++) {
			int currASCII = 48 + (int) (Math.random() * (57 - 48 + 1));
			char currChar = (char) currASCII;
			result += currChar;
		}
		return result;
	}

	public String generateRandomDay() {
		int res = 1 + (int) (Math.random() * 32);
		String ans = res + "";
		return ans;
	}

}
