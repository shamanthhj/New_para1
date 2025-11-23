package com.framework.tests;

//import org.testng.Assert;	
import org.testng.annotations.Test;

import com.framework.base.BaseClass;
import com.framework.pages.LoginPage;
import com.framework.pages.TransferFundsPage;
import com.framework.utilities.ExcelUtility;

public class TransferFundsTest extends BaseClass{

	@Test(groups = {"regression"})
	public void testTransferFundsFunctionality() {
		String username = ExcelUtility.getCellData("Sheet1", 1, 0);
		String password = ExcelUtility.getCellData("Sheet1", 1, 1);
		
		LoginPage login= new LoginPage();
		login.loginAs(username, password);
		
		TransferFundsPage tfPage = new TransferFundsPage();
        tfPage.transferFunds("13566", "13566", "500");

       // Assert.assertTrue(tfPage.isTransferSuccessful(), "Transfer failed!");
	}
}
