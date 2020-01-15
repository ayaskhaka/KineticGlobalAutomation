package appiumautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileBasePage {

	AppiumDriver<MobileElement> driver;


	public MobileBasePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}
	
	@FindBy(name = "q")
	@CacheLookup
	public WebElement googleSearch; 
	
	public MobileBasePage setText(String text) {
		googleSearch.sendKeys(text);
		return this;
	}
	
}
