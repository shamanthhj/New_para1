package com.framework.tests;

import org.testng.Assert;	
import org.testng.annotations.Test;

import com.framework.base.BaseClass;
import com.framework.pages.LoginPage;
import com.framework.utilities.ExcelUtility;

public class LoginTest extends BaseClass{
	
	
	@Test(priority = 1, groups = {"smoke"})
	public void validLoginTest()
	{
		String username = ExcelUtility.getCellData("Sheet1", 1, 0);
		String password = ExcelUtility.getCellData("Sheet1", 1, 1);
		
		LoginPage login = new LoginPage();
		login.loginAs(username, password);
		
		Assert.assertTrue(login.isLoginSuccessful(), "Login failed - Title mismatch");
	}
	
	@Test(priority = 2, groups = {"smoke"})
	public void invalidLoginTest()
	{
		String username = ExcelUtility.getCellData("Sheet1", 2, 0);
		String password = ExcelUtility.getCellData("Sheet1", 2, 1);
		
		LoginPage login = new LoginPage();
		login.loginAs(username, password);
		
		Assert.assertTrue(login.isLoginSuccessful(), "Login failed - Title mismatch");
	}

}
