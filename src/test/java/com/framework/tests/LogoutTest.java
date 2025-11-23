package com.framework.tests;

import org.testng.Assert;	
import org.testng.annotations.Test;

import com.framework.base.BaseClass;
import com.framework.pages.LoginPage;
import com.framework.pages.LogoutPage;
import com.framework.utilities.ExcelUtility;

public class LogoutTest extends BaseClass {
	
	@Test(groups = {"smoke"})
	public void verifyLogout() {
		
		String username = ExcelUtility.getCellData("Sheet1", 1, 0);
		String password = ExcelUtility.getCellData("Sheet1", 1, 1);
		
		LoginPage login = new LoginPage();
		login.loginAs(username, password);
		
		LogoutPage logout = new LogoutPage();
		logout.clickLogout();
		
		Assert.assertTrue(logout.isLoginPanelDisplayed(), "Logout failed - Login page not displayed!");
	}
}
