package com.framework.pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.framework.base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage ()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	private WebElement usernameField;
	//By usernameField = By.name("username");
	@FindBy(xpath="//input[@name = 'password']")
	private WebElement passwordField;
	@FindBy(xpath="//input[@class = 'button' and @value='Log In']")
	private WebElement loginButton;
	@FindBy(xpath = "//*[contains(text(),'Accounts Overview')]")
	private List<WebElement> account_overview;
	
	
	public void loginAs(String username, String password)
	{
		wait.until(ExpectedConditions.visibilityOf(usernameField));
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	
	public boolean isLoginSuccessful() {
		boolean title = driver.getTitle().contains("ParaBank");
	    boolean accountOverviewVisible = account_overview.size() > 0;

	    return title && accountOverviewVisible;
	}
}
