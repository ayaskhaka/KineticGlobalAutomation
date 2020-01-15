package webautomationselenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class LoginClienteAction extends LoginClientPage {
	
	private static WebDriver driver;
	
	public LoginClienteAction(WebDriver driver) {
		super(driver);
		LoginClienteAction.driver = driver;
	}
	
	public LoginClienteAction() {
		super(driver);
	
	}
	
	public static void startBrowser(String webriverChrome, String driverPath, String url) throws IOException, InterruptedException {

		System.setProperty(webriverChrome, driverPath);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	public static Object loadDataProperty(String data) {

		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("C:\\Users\\Ayandak\\eclipse-workspace\\ex_workspace\\GlobalKineticAutomation\\resources\\config.properties");
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} 
		finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return prop.getProperty(data);

	}
	
	public LoginClienteAction mercuryClientLogin() throws InterruptedException {
		setText(username, LoginClienteAction.loadDataProperty("username").toString());
		setText(password, LoginClienteAction.loadDataProperty("password").toString());
		return this;
	}
	
	public String getUsernameText() {
		return username.getAttribute("value");
		
	}
	
	public String getPasswordText() {
		return password.getAttribute("value");
		
	}
	
	public LoginClienteAction clickOnSignInButton() {
		
		clickButton(signInButton);
		return this;
	}	
}
