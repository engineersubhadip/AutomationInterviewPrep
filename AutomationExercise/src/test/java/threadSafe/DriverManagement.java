package threadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManagement {
	
	private static DriverManagement instance;
	private static Lock lock = new ReentrantLock();
	private ThreadLocal<WebDriver> tLocal = new ThreadLocal<>();
	
	private DriverManagement() {};
	
	public static DriverManagement getInstance() {
		if (instance == null) { // true
			lock.lock();
			if (instance == null) {
				instance = new DriverManagement();
			}
			lock.unlock();
		}
		return instance;
	}
	
	public void setDriver(String browserName) { // this method will be invoked by a thread via the shared object
		if (browserName.toLowerCase().contains("chrome")) {
			tLocal.set(new ChromeDriver());
		} else if (browserName.toLowerCase().contains("edge")) {
			tLocal.set(new EdgeDriver());
		} else if (browserName.toLowerCase().contains("firefox")) {
			tLocal.set(new FirefoxDriver());
		} else {
			return;
		}
	}
	
	public WebDriver getDriver () { // this method will be invoked by a thread via the shared object
		if (tLocal.get() != null) {
			return tLocal.get();
		}
		return null;
	}
	
	public void quitBrowser() { // this method will be invoked by a thread via the shared object
		if (tLocal.get() != null) {
			tLocal.get().quit();
			tLocal.remove();
		}
	}
}
