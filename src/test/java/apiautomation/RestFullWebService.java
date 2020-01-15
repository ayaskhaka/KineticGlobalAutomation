package apiautomation;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import apiautomation.APIAutomationAction;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response.*;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import webautomationselenium.LoginClienteAction;

public class RestFullWebService {

	private APIAutomationAction aaa;

	public RestFullWebService() {
		aaa = new APIAutomationAction();
	}
	@BeforeGroups(groups = "Status code")
	public void beforeVerifyingStatusCode() {
		aaa.getWeatherDetails();
	}

	@Test(groups = "Status code", priority = 1)
	public void VerifyingStatusCode()
	{   

		Assert.assertEquals(aaa.getStatusCode(), Integer.parseInt(LoginClienteAction.loadDataProperty("getStatusCode").toString()));
	}
	
	@Test(groups = "Status code", priority = 2)
	public void VerifyingContentType()
	{   

		Assert.assertEquals(aaa.GetContentType(), LoginClienteAction.loadDataProperty("contentType").toString());
	}
	
	@Test(groups = "Status code", priority = 3)
	public void VerifyingServer()
	{   
		System.out.println("Server = " + aaa.GetServerType());
		Assert.assertEquals(aaa.GetServerType(), LoginClienteAction.loadDataProperty("serverType").toString());
	}
	
	@BeforeGroups(groups = "Save Details")
	public void saveDetails() {
		aaa.POSTRecord();
	}
	
	@Test(groups = "Save Details", priority = 4)
	public void VerifyingVerifyBadRequest()
	{   

		Assert.assertEquals(aaa.getPostStatusCode(), Integer.parseInt(LoginClienteAction.loadDataProperty("badStatusCode").toString()));
	}
	
	
}
