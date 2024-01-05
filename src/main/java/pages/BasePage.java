package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	static Logger logger = LogManager.getLogger();
	
	protected BasePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void enterText(WebElement element, String text) {
		if(element.isDisplayed()){
			element.sendKeys(text);
		}
	}

}
