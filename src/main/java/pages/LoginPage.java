package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonActions;
import utils.CommonUtils;
import utils.FileUtils;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;

	@FindBy(name = "Login")
	public WebElement loginButton;

	@FindBy(xpath = "//*[@id='rememberUn']")
	public WebElement rememberMe;

	@FindBy(id = "error")
	public WebElement errorMessage;

	@FindBy(partialLinkText = "Forgot")
	public WebElement forgotPassword;

	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;

	@FindBy(id = "un")
	public WebElement forgotUsername;

	public void enterUsername(String emailID) {
		logger.info("LoginPage : enterUsername : Started");
		if (username.isDisplayed()) {
			username.sendKeys(emailID);
		} else {
			logger.error("LoginPage : enterUsername : username not displayed");
		}
	}

	public void enterPassword(String pass) {
		if (password.isDisplayed()) {
			password.sendKeys(pass);
		} else {
			logger.error("LoginPage : enterPassword : Password not displayed");
		}
	}

	public void clickLoginButton() {
		if (loginButton.isDisplayed()) {
			loginButton.click();
		} else {
			System.out.print("login element not found");
		}
	}

	public void selectRememberMeCheckbox() {
		if (!rememberMe.isSelected()) {
			rememberMe.click();
		}
	}

	public String isLoginPageOpened(WebDriver driver) {
		return driver.getTitle();
	}

	public String getLoginErrorText() {
		if (errorMessage.isDisplayed()) {
			return errorMessage.getText();
		} else {
			return null;
		}
	}

	public String getUsername() {
		return username.getText();
	}

	public String getPassword() {
		return password.getText();
	}
	
	public void loginToApp(WebDriver driver) throws IOException {
		driver.get(FileUtils.readLoginTestData("prod.app.url"));
		driver.manage().window().maximize();
		if(CommonUtils.waitForElement(driver, username)) {
			username.sendKeys(FileUtils.readLoginTestData("prod.username"));
			password.sendKeys(FileUtils.readLoginTestData("prod.password"));
			loginButton.click();
		} else {
			
		}
	}

}
