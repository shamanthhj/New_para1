package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.framework.base.BaseClass;

public class OpenNewAccountPage extends BaseClass {
	
	@FindBy(partialLinkText  ="Open New Account")
	WebElement openNewAccountLink;
	
	@FindBy(id="type")
	WebElement accountTypeDropdown;
	
	@FindBy(id="fromAccountId")
	WebElement fromAccountDropdown;
	
	@FindBy(xpath = "//input[@value='Open New Account']")
    WebElement openAccountButton;
	
	@FindBy(id = "newAccountId")
    WebElement newAccountIdLink;
	
	public OpenNewAccountPage() {
        PageFactory.initElements(driver, this);
    }
	
	public void openNewAccount(String accountType, String fromAccount)
	{
		openNewAccountLink.click();
		new Select(accountTypeDropdown).selectByVisibleText(accountType);
		new Select(fromAccountDropdown).selectByValue(fromAccount);
		openAccountButton.click();
	}
	
	 public boolean isAccountOpened() {
	        try {
	        	wait.until(ExpectedConditions.visibilityOf(newAccountIdLink));
	        	System.out.println("New Account Created: " + newAccountIdLink.getText());
	        	return newAccountIdLink.isDisplayed();
	        }catch (Exception e) {
	        	System.out.println("Failed to open account: " + e.getMessage());
	            return false;
	        }
	 }
}
