package baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	public WebDriver driver;
	public Properties properties;
	
	@BeforeClass
	public void setUp() throws IOException {
		
		properties = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		properties.load(file);
		
		String browserURl = properties.getProperty("browserURL");
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(browserURl);	
	}
	
	@AfterClass
	public void tearDown () {
		driver.quit();
	}
}
