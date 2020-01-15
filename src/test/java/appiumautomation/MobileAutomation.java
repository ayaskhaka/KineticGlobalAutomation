package appiumautomation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import webautomationselenium.LoginClienteAction;

public class MobileAutomation {
	
	static AppiumDriver<MobileElement> driver;
	private MobileBasePageAction mbpa;
	public MobileAutomation(AppiumDriver<MobileElement> driver) {
		mbpa =  new MobileBasePageAction(MobileAutomation.driver);
	}
	
    @BeforeClass
    public void setup() throws MalformedURLException {
    	
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	
    	capabilities.setCapability(MobileCapabilityType.PLATFORM, LoginClienteAction.loadDataProperty("platformname").toString());
    	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, LoginClienteAction.loadDataProperty("platformversion").toString());
    	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, LoginClienteAction.loadDataProperty("devicename").toString());
    	capabilities.setCapability(MobileCapabilityType.UDID, LoginClienteAction.loadDataProperty("udid").toString());
    	capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, LoginClienteAction.loadDataProperty("newcommandtimeout").toString());
    	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, LoginClienteAction.loadDataProperty("browsername").toString());
    	
    	driver = new  AppiumDriver<MobileElement>(new URL(LoginClienteAction.loadDataProperty("appiumurl").toString()), capabilities); 
    	driver.get(LoginClienteAction.loadDataProperty("googleURL").toString());
    	mbpa.setText(LoginClienteAction.loadDataProperty("searchText").toString());
    	
    }
    
    @Test
    public void verifySearchTextValue() {
    	Assert.assertEquals(mbpa.getSearchTextValue(), LoginClienteAction.loadDataProperty("searchText").toString());
    }
    
    
    @AfterTest
    public void tearDown() {
    	driver.close();
    	driver.quit();
    }
	
	
}
