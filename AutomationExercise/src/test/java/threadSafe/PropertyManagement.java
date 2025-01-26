package threadSafe;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PropertyManagement {
	
	private static PropertyManagement instance;
	private static Lock lock = new ReentrantLock();
	private ThreadLocal<Properties> tLocal = new ThreadLocal<>();
	
	private PropertyManagement() {};
	
	public static PropertyManagement getInstance () {
		if (instance == null) {
			lock.lock();
			if (instance == null) {
				instance = new PropertyManagement();
			}
			lock.unlock();
		}
		return instance;
	}
	
	public void setProperty (String filePath) throws IOException { // this method will be invoked by a thread, via the shared object
		if (tLocal.get() == null) {
			Properties properties = new Properties();
			tLocal.set(properties);
		}
		try (FileInputStream file = new FileInputStream(filePath)) {
			tLocal.get().load(file);
		}
	}
	
	public Properties getProperty() {
		if (tLocal.get() != null) {
			return tLocal.get();
		}
		return null;
	}
	
	public void quitProperty () {
		if (tLocal.get() != null) {
			tLocal.remove();
		}
	}
}
