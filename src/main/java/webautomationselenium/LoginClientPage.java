package webautomationselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClientPage {
	WebDriver driver;
	
	
	public LoginClientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		
	}
	
	@FindBy(name = "userName")
	@CacheLookup
	protected WebElement username;
	
	@FindBy(name = "password")
	@CacheLookup
	protected WebElement password;
	
	@FindBy(name = "login")
	@CacheLookup
	protected WebElement signInButton;
	
	protected LoginClientPage setText(WebElement element,String text) {
		element.sendKeys(text);
		return this;
	}
	
	protected LoginClientPage clickButton(WebElement element) {
		element.click();
		return this;
	}
	
	
	
	
	
	
}
