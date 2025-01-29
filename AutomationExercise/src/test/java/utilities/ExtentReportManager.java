package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import threadSafe.DriverManagement;

public class ExtentReportManager implements ITestListener {
	
	private ExtentSparkReporter sparkReporter;
	private ExtentReports extent;
	private ThreadLocal<ExtentTest> tLocal = new ThreadLocal<>();
	private Lock lock = new ReentrantLock();
	private boolean reportUpdate = false;
	private List<String> browserName = new ArrayList<>();
	private boolean browserUpdate = false;
	
	public void onStart(ITestContext context) {
		if (reportUpdate == false) {
			lock.lock();
			if (reportUpdate == false) {
				SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
				Date dt = new Date();
				String fileName = df.format(dt);
				
				sparkReporter = new ExtentSparkReporter(new File("K:\\AutomationInterviewGuide\\AutomationExercise\\reports\\"+fileName+".html"));
				sparkReporter.config().setDocumentTitle("Automation Report");
				sparkReporter.config().setReportName("Ecommerce Report");
				sparkReporter.config().setTheme(Theme.DARK);
				
				extent = new ExtentReports();
				extent.attachReporter(sparkReporter);
				extent.setSystemInfo("Application", "Myntra");
				extent.setSystemInfo("Environment", "QA");
				extent.setSystemInfo("Tester Name", "Subhadip");
				
				reportUpdate = true;
			}
			lock.unlock();
		}
		browserName.add(context.getCurrentXmlTest().getParameter("browser"));
	}

	public void onTestStart(ITestResult result) {
		tLocal.set(extent.createTest(result.getTestClass().getName()));
	}

	public void onTestSuccess(ITestResult result) {
		tLocal.get().log(Status.PASS, result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		tLocal.get().log(Status.FAIL, result.getMethod().getMethodName());
		tLocal.get().log(Status.INFO, result.getThrowable());
		try {
			String screenshotPath = captureScreenshot();
			tLocal.get().addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String captureScreenshot() throws IOException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date dt = new Date();
		String fileName = df.format(dt);
		File src = ((TakesScreenshot)DriverManagement.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
		String filePath = "K:\\AutomationInterviewGuide\\AutomationExercise\\screenshots\\"+fileName+".png";
		
		FileUtils.copyFile(src, new File(filePath));
		
		return filePath;
	}
	
	public void onTestSkipped(ITestResult result) {
		tLocal.get().log(Status.SKIP, result.getMethod().getMethodName());
		tLocal.get().log(Status.INFO, result.getThrowable());
	}

	public void onFinish(ITestContext context) {
		if (browserUpdate == false) {
			lock.lock();
			if (browserUpdate == false) {
				extent.setSystemInfo("Browser",browserName.toString());		
				browserUpdate = true;
			}
			lock.unlock();
		}
		extent.flush();
		tLocal.remove();
	}
}
