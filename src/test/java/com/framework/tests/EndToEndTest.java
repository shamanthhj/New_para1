package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseClass;
import com.framework.pages.LoginPage;
import com.framework.pages.LogoutPage;
import com.framework.pages.OpenNewAccountPage;
import com.framework.pages.TransferFundsPage;
import com.framework.utilities.ExcelUtility;

public class EndToEndTest extends BaseClass {
	@Test
	public void endToEndFlow()
	{
		String username = ExcelUtility.getCellData("Sheet1", 1, 0);
		String password = ExcelUtility.getCellData("Sheet1", 1, 1);
		
		LoginPage login = new LoginPage();
		login.loginAs(username, password);
		
		OpenNewAccountPage accountPage = new OpenNewAccountPage();
		accountPage.openNewAccount("CHECKING", "13566");
		
		TransferFundsPage tfPage = new TransferFundsPage();
        tfPage.transferFunds("13566", "13566", "500");
        
        LogoutPage logout = new LogoutPage();
		logout.clickLogout();
		
		Assert.assertTrue(logout.isLoginPanelDisplayed(), "Logout failed - Login page not displayed!");
	}
}
