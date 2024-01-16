package Constants;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyInput;

import utils.CommonUtils;

public class FileConstants {
	
	public static final String LOGIN_TESTDATA_FILE_PATH = System.getProperty("user.dir")+"/src/main/resources/loginTestData.properties";
	public static final String USERMENU_TESTDATA_FILE_PATH = System.getProperty("user.dir")+"/src/main/resources/userMenuTestData.properties";
	public static final String TEST_FILE_PATH = "/Users/user/Desktop/Cypress training draft.xlsx";
	public static final String PHOTO_FILE_PATH = "/Users/user/Desktop/Image.PNG";
//	/Nov23_sfdc_automation/src/test/resources/Screenshots
	public static final String SCREENSHOTS_FOLDER_PATH = System.getProperty("user.dir")+"/src/test/resources/Screenshots/"+CommonUtils.getDateAndTimeStamp()+".PNG";
	public static final String REPORT_FOLDER_PATH = System.getProperty("user.dir")+"/src/test/resources/SFDC_"+CommonUtils.getDateAndTimeStamp()+".html";
	public static final String API_TEST_DATA_FILE = System.getProperty("user.dir")+"/src/main/java/ApiTestData/testData.json";
	
}
