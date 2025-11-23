package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseClass;
import com.framework.pages.LoginPage;
import com.framework.pages.OpenNewAccountPage;
import com.framework.utilities.ExcelUtility;

public class OpenNewAccountTest extends BaseClass {
	
	@Test(groups = {"regression"})
	public void testOpenNewAccount() {
		String username = ExcelUtility.getCellData("Sheet1", 1, 0);
		String password = ExcelUtility.getCellData("Sheet1", 1, 1);
		
		LoginPage login= new LoginPage();
		login.loginAs(username, password);
		
		OpenNewAccountPage accountPage = new OpenNewAccountPage();
		accountPage.openNewAccount("CHECKING", "13566");
		Assert.assertTrue(accountPage.isAccountOpened(), "Account creation failed!");
	}

}
