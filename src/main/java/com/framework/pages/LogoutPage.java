package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.base.BaseClass;

public class LogoutPage extends BaseClass {
	
	@FindBy(linkText = "Log Out")
	WebElement logoutLink;
	
	@FindBy(xpath = "//h2[contains(text(),'Customer Login')]")
	WebElement loginPanel;
	
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogout() {
		logoutLink.click();
	}
	
	public boolean isLoginPanelDisplayed() {
		return loginPanel.isDisplayed();
	}
}
