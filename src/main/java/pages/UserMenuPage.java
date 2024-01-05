package pages;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.FileUtils;

/**
 * 
 */
public class UserMenuPage extends BasePage{

	public UserMenuPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "userNavLabel")
	public WebElement userMenu;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;

	@FindBy(xpath = "//a[@title='My Profile']")
	public WebElement MyProfile;

	@FindBy(id = "userNav-menuItems/a[2]")
	public WebElement MySettings;

	@FindBy(id = "userNav-menuItems/a[3]")
	public WebElement DevelopersConsole;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement SwitchtoLightningExperience;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement Logout;

	// My profile
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editContactButton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement EditProfilePopupwindow;

	@FindBy(id = "aboutTab")
	public WebElement Abouttab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement Abouttablastname;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(xpath = "//*[@id='tailBreadcrumbNode']")
	public WebElement userProfilePageNameDisplay;

	// Postlink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	// filelink

	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	public WebElement filelink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentpost;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement Uploadfile;

	@FindBy(css = "#chatterFile")
	public WebElement Fileopen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publish;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;

	@FindBy(id = "uploadLink")
	public WebElement updateButton;
	// Photo link

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photolink;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;

	@FindBy(id = "publishersharebutton")
	public WebElement photosharebutton;

	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoUploadIframe;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveButton;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement photoSaveButton2;
	// My Settings
	// personallink

	@FindBy(xpath = "//*[@id=\'PersonalInfo_font\']")
	public WebElement personallink;

	@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
	public WebElement loginHistorylink;

	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement logindisplay;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	// Display&layoutlink

	@FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	public WebElement DisplayLayoutlink;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizedTab;

	@FindBy(xpath = "//*[@id=\"p4\"]/option[9]")
	public WebElement customApp;

	@FindBy(xpath = "//*[@id=\"duel_select_0\"]/option[73]")
	public WebElement Availabletab;

	@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	public WebElement Add;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save;

	@FindBy(id = "tabBar")
	public WebElement tabList;

	// Emaillink

	@FindBy(xpath = "//*[@id=\"EmailSetup_font\"]")
	public WebElement Emaillink;

	@FindBy(id = "EmailSettings_font")
	public WebElement MyEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement Emailname;

	@FindBy(xpath = "//*[@id=\"sender_email\"]")
	public WebElement Emailaddress;

	@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7]/td[2]/div")
	public WebElement BCCradiobutton;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement Saveonemail;

	// Calendar and Remainders
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement CalendarAndReminders;

	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	public WebElement ActivityRemainder;

	@FindBy(id = "testbtn")
	public WebElement OpenaTestRemainder;

	@FindBy(xpath = "//*[@id=\"summary\"]")
	public WebElement SampleEventPopup;

	@FindBy(css = "#displayBadge")
	public WebElement moderatorButton;

	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//div[@class='cxfeeditem feeditem'][1]//p")
	public WebElement firstPostText;

	@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;

	@FindBy(name = "j_id0:waitingForm")
	public WebElement spinnerIcon;

	@FindBy(id = "cropWaitingPage:croppingForm")
	public WebElement spinnerWhileCropping;

	@FindBy(id = "progressIcon")
	public WebElement fileUploadSpinner;

	/**
	 * @return true if all options are verified else false
	 * @throws IOException
	 */
	public boolean verifyUserMenuItems() throws IOException {
		boolean isAllOptionsVerified = true;
		String[] expectedUserMenuItems = FileUtils.readUserMenuTestData("usermenu.items").split(",");
		for (int i = 0; i < expectedUserMenuItems.length; i++) {
			String actualOption = userMenuOptions.get(i).getText();
			if (actualOption.equals(expectedUserMenuItems[i])) {
				System.out.println("UserMenuPage : verifyUserMenuItems : Expected option: " + expectedUserMenuItems[i]
						+ " Actual option: " + actualOption);
			} else {
				System.out.println("UserMenuPage : verifyUserMenuItems : Expected option: " + expectedUserMenuItems[i]
						+ " Actual option: " + actualOption);
				isAllOptionsVerified = false;
			}
		}
		return isAllOptionsVerified;
	}

	public boolean selectUserMenuOption(WebDriver driver, String option) {
		boolean isOptionSelected = false;
//		if(userMenu.isDisplayed()) {
//			userMenu.click();
//		} 
		WebElement userMenuOption = driver.findElement(By.xpath("//*[text()='" + option + "']"));
		if (CommonUtils.waitForElement(driver, userMenuOption)) {
			userMenuOption.click();
			isOptionSelected = true;
		}
		return isOptionSelected;
	}

	public boolean isMyProfilePageDisplayed() {
		return profilePage.isDisplayed();
	}

	public void selectUserMenu() {
		if (userMenu.isDisplayed()) {
			userMenu.click();
		} else {

		}
	}

	public void selectEditContact(WebDriver driver) {
		if (CommonUtils.waitForElement(driver, editContactButton)) {
			editContactButton.click();
		}
	}

	public boolean verifyEditContactIframe(WebDriver driver) {
		boolean isIframeloaded = false;
		if (CommonUtils.waitForElement(driver, iframeAboutTab)) {
			driver.switchTo().frame(iframeAboutTab);

			if (Abouttab.isDisplayed() && contactTab.isDisplayed()) {
				isIframeloaded = true;
			}
		}
		return isIframeloaded;
	}

	public boolean verifyLastNameChangeInAboutTab(WebDriver driver, String lastName) {
		boolean isLastNameChanged = false;
		if (Abouttab.isDisplayed()) {
			Abouttab.click();
			Abouttablastname.clear();
			Abouttablastname.sendKeys(lastName);
			saveAllButton.click();
			driver.switchTo().parentFrame();
			if (userProfilePageNameDisplay.isDisplayed()) {
				String actualName = userProfilePageNameDisplay.getText();
				if (actualName.contains(lastName)) {
					isLastNameChanged = true;
				} else {

				}
			}
		}
		return isLastNameChanged;
	}

	public boolean verifyCreatePost(WebDriver driver, String message) {
		boolean isPostCreated = false;
		if (postLink.isDisplayed()) {
			postLink.click();
			driver.switchTo().frame(0);
			postTextArea.sendKeys(message);
			driver.switchTo().defaultContent();
			if (shareButton.isDisplayed()) {
				shareButton.click();
				isPostCreated = true;
			}
		}
		return isPostCreated;
	}

	public boolean verifyFileUpload(WebDriver driver, String filePath) {
		boolean isFileUploadSuccess = false;
		if (filelink.isDisplayed()) {
			filelink.click();
			if (CommonUtils.waitForElement(driver, Uploadfile)) {
				Uploadfile.click();
			}
			if (CommonUtils.waitForElement(driver, Fileopen)) {
				Fileopen.sendKeys(filePath);
				shareButton.click();
				if (CommonUtils.waitForElementToDisappear(driver, cancelUpload)) {
					if (verifyFilePostElement.isDisplayed()) {
						isFileUploadSuccess = true;
					}
				}
			}
		}
		return isFileUploadSuccess;
	}

	public void clickOnUpdatePhototButton(WebDriver driver) {
		CommonUtils.mouseHover(driver, moderatorButton);
		if (updateButton.isDisplayed()) {
			updateButton.click();
		}
	}

	public boolean verifyPhotoUpload(WebDriver driver, String photoFilePath) {
		boolean isPhotoUploaded = false;
		this.clickOnUpdatePhototButton(driver);
		driver.switchTo().frame(photoUploadIframe);
		if (CommonUtils.waitForElement(driver, uploadphoto)) {
			uploadphoto.sendKeys(photoFilePath);
			photoSaveButton.click();
		}
		if (CommonUtils.waitForElementToDisappear(driver, spinnerIcon)
				&& CommonUtils.waitForElement(driver, photoSaveButton2)) {
			photoSaveButton2.click();
			if (CommonUtils.waitForElementToDisappear(driver, spinnerWhileCropping)) {
				isPhotoUploaded = true;
			}
		}
		driver.switchTo().parentFrame();
		return isPhotoUploaded;
	}
}
