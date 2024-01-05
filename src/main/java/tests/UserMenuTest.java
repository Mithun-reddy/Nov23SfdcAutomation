package tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Constants.FileConstants;
import Constants.WaitConstants;
import listeners.SFDCListeners;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.CommonUtils;
import utils.FileUtils;

@Listeners(SFDCListeners.class)
public class UserMenuTest extends BaseTest{
	private WebDriver driver;
	
	@BeforeMethod(onlyForGroups = "umt")
	@Parameters({"browserName","isHeadless"})
	public void preCondition(@Optional("chrome") String bname, @Optional("false") boolean isHeadless) throws IOException {
		BaseTest.setDriver(bname, isHeadless);
		driver = BaseTest.getDriver();
		logger.info("BaseTest : preCondition : ");
	}
	
	@Test(groups = "umt")
	public void selectMyProfile_TC06(Method name) throws IOException, InterruptedException {
//		System.out.println(name.getName());
		
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		driver.manage().timeouts().pageLoadTimeout(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);
		logger.info("BaseTest : selectMyProfile_TC06 : ");
		ump.selectUserMenu();
		test.info("Usermenu selected");
		Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify usermenu options");
		test.info("verifyUserMenuItems successful");
		Assert.assertTrue(ump.selectUserMenuOption(driver, "My Profile"),"");
		test.info("selectUserMenuOption successful");
		CommonUtils.waitForElement(driver, ump.profilePage);
		test.info("waitForElement profilePage");
		Assert.assertTrue(ump.isMyProfilePageDisplayed(), "Failed to load my profile page");
		test.info("isMyProfilePageDisplayed successfull");
		ump.selectEditContact(driver);
		Assert.assertTrue(ump.verifyEditContactIframe(driver), "Failed to verify profile iframe");
		Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver, FileUtils.readUserMenuTestData("user.newLastName")));
		Assert.assertTrue(ump.verifyCreatePost(driver, FileUtils.readUserMenuTestData("post.message")));
		test.info("post is created successfully");
		Assert.assertTrue(ump.verifyFileUpload(driver, FileConstants.TEST_FILE_PATH));
		test.info("file is uploaded successfully");
		Assert.assertTrue(ump.verifyPhotoUpload(driver, FileConstants.PHOTO_FILE_PATH));
		test.info("verifyPhotoUpload successfully");
	}
	
	@Test()
	public void selectMySettings_TC07() throws IOException, InterruptedException {
		System.out.println("Test method");
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		driver.manage().timeouts().pageLoadTimeout(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);
		ump.selectUserMenu();
		test.info("selectUserMenu successfully");
		Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify usermenu options");
		Assert.assertTrue(ump.selectUserMenuOption(driver, "My Settings"),"");
		Assert.assertTrue(false, "");
	}
	
	@Test()
	public void selectMyProfile_TC08(Method name) throws IOException, InterruptedException {
//		System.out.println(name.getName());
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		driver.manage().timeouts().pageLoadTimeout(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);
		logger.info("BaseTest : selectMyProfile_TC06 : ");
		ump.selectUserMenu();
		test.info("Usermenu selected");
	}
	
	}
