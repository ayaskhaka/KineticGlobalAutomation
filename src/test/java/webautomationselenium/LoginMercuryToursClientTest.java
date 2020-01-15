package webautomationselenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webautomationselenium.LoginClienteAction;


public class LoginMercuryToursClientTest {
	
	private LoginClienteAction catpa;
	WebDriver driver;

	public LoginMercuryToursClientTest() {
		this.driver = new ChromeDriver();
		catpa = new LoginClienteAction(this.driver);	
	}

	@BeforeGroups(groups = "Landing Page")
	@Parameters({"chromeDriver","chromePath","url"})
	public void beforeAwufulValentineTest(String driver, String driverPath, String url) throws IOException, InterruptedException { 
		LoginClienteAction.startBrowser(driver, driverPath, url);
	}
	
	@Test(groups = "Landing Page",priority = 1)
	public void testMercuryToursTitle() {
		
		Assert.assertEquals(this.driver.getTitle(), LoginClienteAction.loadDataProperty("forgeHomePageTitle").toString());
	}
	
	@AfterGroups(groups = "Landing Page")
	public void beforeRegistrationPage() throws InterruptedException {
		catpa.mercuryClientLogin();
	}
	
	@Test(groups = "login", dependsOnGroups = "Landing Page", priority = 2)
	public void verifyUsernameHasBeenEntered() {
		
		Assert.assertEquals(catpa.getUsernameText(), LoginClienteAction.loadDataProperty("username").toString());
	}
	
	@Test(groups = "login",dependsOnGroups = "Landing Page", priority = 3)
	public void verifyPasswordHasBeenEntered() {
		
		Assert.assertEquals(catpa.getPasswordText(), LoginClienteAction.loadDataProperty("password").toString());
	}
	
	@AfterGroups(groups = "login")
	public void signIn() {
		catpa.clickOnSignInButton();
	}
	
	@Test(groups = "Find Flight Landing Page",priority = 4)
	public void testFindFlightPageTitle() {
		
		Assert.assertEquals(this.driver.getTitle(), LoginClienteAction.loadDataProperty("findFlightTitle").toString());
	}
	
	@AfterGroups(groups = "Find Flight Landing Page")
	public void closePage() throws InterruptedException {
		Thread.sleep(4000);
		this.driver.close();
	}
	
}
