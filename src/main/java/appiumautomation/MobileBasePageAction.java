package appiumautomation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import webautomationselenium.LoginClienteAction;

public class MobileBasePageAction extends MobileBasePage {
	
	protected static AppiumDriver<MobileElement> driver;
    public MobileBasePageAction(AppiumDriver<MobileElement> driver) {
    	super(driver);
    	MobileBasePageAction.driver = driver;
    }
    
    public MobileBasePageAction searchText() {
    	setText(LoginClienteAction.loadDataProperty("searchText").toString());
    	googleSearch.sendKeys(Keys.ENTER);
    	return this;
    }
    
    public String getSearchTextValue() {
    	return googleSearch.getAttribute("value");
    }
	
}
