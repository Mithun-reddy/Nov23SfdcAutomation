package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Constants.FileConstants;

/**
 * The purpose of this class is to have common methods across the different test classes
 */
public class BaseTest {
	public static ExtentReports extent;
	public static ExtentTest test;
	static Logger logger = LogManager.getLogger();	
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> threadExtentTest = new ThreadLocal<ExtentTest>();
	
	
	@BeforeSuite
	public void configuration() {
		extent = new ExtentReports();
		logger.info("BaseTest : configuration : Report configuration started");
		ExtentSparkReporter report = new ExtentSparkReporter(FileConstants.REPORT_FOLDER_PATH);
		extent.attachReporter(report);
		logger.info("BaseTest : configuration : Report configuration Finished");
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
		logger.info("BaseTest : tearDown : After suite finished");
	}
	
	public static void setDriver(String bName, boolean isHeadless) {
		WebDriver driver = BaseTest.getBrowserType(bName, isHeadless);
		threadLocalDriver.set(driver);
	}
	
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	@AfterMethod
	public static void removeDriver() {
		BaseTest.getDriver().close();
		threadLocalDriver.remove();
		BaseTest.threadExtentTest.remove();
	}
	
	/** This method configures and returns browser object
	 * @param browserName eg: chrome, firefox
	 * @return Webdriver object
	 */
	public static WebDriver getBrowserType(String browserName, boolean isHeadless) {
		
		WebDriver driver;
		String browser = browserName.toLowerCase();
		switch (browser) {
		case "chrome":
			if(isHeadless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless", "--window-size=1920,1080");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}
			logger.info("BaseTest : getBrowserType : Chrome browser configured");
			break;
		case "safari":
			driver = new SafariDriver();
			logger.info("BaseTest : getBrowserType : safari browser configured");
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			logger.info("BaseTest : getBrowserType : firefox browser configured");
			break;

		case "IE":
			driver = new InternetExplorerDriver();
			logger.info("BaseTest : getBrowserType : IE browser configured");
			break;
			
		default:
			driver = null;
			logger.info("BaseTest : getBrowserType : Invalid browser name");
			break;
		}
		return driver;
	}
	

}
