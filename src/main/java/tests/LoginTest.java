package tests;

import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import listeners.SFDCListeners;
import pages.LoginPage;
import utils.DataProviders;
import utils.FileUtils;

@Listeners(SFDCListeners.class)
public class LoginTest extends BaseTest {
	
	@Test (enabled = true, groups = {"smoke", "regression"})
	public void method1() throws IOException, InterruptedException {
		
		WebDriver driver = BaseTest.getBrowserType("chrome", false);
		LoginPage lp = new LoginPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get(FileUtils.readLoginTestData("prod.app.url"));
		js.executeScript("arguments[0].value='123456789';",lp.username);
//		lp.username.sendKeys(FileUtils.readLoginTestData("prod.username"));
		lp.password.sendKeys(FileUtils.readLoginTestData("prod.password"));
//		lp.loginButton.click();
		js.executeScript("arguments[0].click();",lp.loginButton);
		System.out.println(js.executeScript("return document.domain;").toString());
		System.out.println(js.executeScript("return document.title;").toString());
//		js.executeScript("window.scrollBy(0, 600)");
		
		Thread.sleep(10000);
		System.out.println("method1");
	}
	
	
//	@Test(dataProvider = "loginTestData", dataProviderClass = DataProviders.class)
	public void login(String username, String pass) throws IOException {
//		WebDriver driver = BaseTest.getBrowserType("chrome");
//		LoginPage lp = new LoginPage(driver);
//		driver.get(FileUtils.readLoginTestData("prod.app.url"));
//		lp.enterUsername(FileUtils.readLoginTestData("prod.invalid.username"));
//		lp.enterPassword(FileUtils.readLoginTestData("prod.invalid.password"));
//		lp.clickLoginButton();
		System.out.println(username+" "+pass);
	}
	
//	@Test()
	public void validateLoginError_TC04B() throws IOException {
//		WebDriver driver = BaseTest.getBrowserType("chrome");
//		LoginPage lp = new LoginPage(driver);
//		SoftAssert sa = new SoftAssert();
//		driver.get(FileUtils.readLoginTestData("prod.app.url"));
//		sa.assertEquals(lp.isLoginPageOpened(driver), FileUtils.readLoginTestData("loginPage.title"));
//		lp.enterUsername(FileUtils.readLoginTestData("invalid.username"));
//		lp.enterPassword(FileUtils.readLoginTestData("invalid.password"));
////		Assert.assertEquals(lp.getUsername(), FileUtils.readLoginTestData("invalid.username"));
////		Assert.assertNotNull(lp.getPassword());s
//		lp.clickLoginButton();
//		sa.assertEquals(lp.getLoginErrorText(), FileUtils.readLoginTestData("invalid.login.errorText"));
//		sa.assertAll();
//		driver.quit();
	}
	
	
	
	
}
