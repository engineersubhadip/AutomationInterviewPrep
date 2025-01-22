package SingletonDesign;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManagement {

	private static DriverManagement instance;
	private static Lock lock = new ReentrantLock();
	private ThreadLocal<WebDriver> tLocal = new ThreadLocal<>();

	private DriverManagement() {
	};

	public static DriverManagement getInstance() { // Multiple threads will invoke this method, but only one object will be created.
		if (instance == null) {
			lock.lock();
			if (instance == null) {
				instance = new DriverManagement();
			}
			lock.unlock();
		}
		return instance;
	}

	public void setDriver(String browserName) { // whichever thread is invoking this, corresponding to that thread the driver will be mapped.
												// whichever thread is invoking this, will invoke this method from the shared object.
		if (browserName.toLowerCase().contains("chrome")) {
			tLocal.set(new ChromeDriver());
		} else if (browserName.toLowerCase().contains("edge")) {
			tLocal.set(new EdgeDriver());
		} else {
			return;
		}
	}

	public WebDriver getDriver() { // whichever thread is executing this code, corresponding to that thread, we
									// will return the driver.
									// whichever thread is invoking this, will invoke this method from the shared object.
		return tLocal.get();
	}

	public void quitBrowser() { // whichever thread is executing this code, corresponding to that thread we will
								// get the driver and close it and ultimately remove the mapping
								// whichever thread is invoking this, will invoke this method from the shared object.
		tLocal.get().quit();
		tLocal.remove();
	}
}
