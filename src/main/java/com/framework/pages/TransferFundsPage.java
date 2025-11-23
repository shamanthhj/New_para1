package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.framework.base.BaseClass;

public class TransferFundsPage extends BaseClass {
	
	@FindBy(linkText = "Transfer Funds")
	WebElement trnsferFounds;
	
	@FindBy(id = "fromAccountId")
	WebElement fromAccountDropdown;
	
	@FindBy(id = "toAccountId")
	WebElement toAccountDropdown;
	
	@FindBy(id = "amount")
	WebElement amountInput;
	
	@FindBy(xpath = "//input[@value='Transfer']")
	WebElement transferButton;
	
	@FindBy(xpath = "//h1[normalize-space()='Transfer Complete!']")
	WebElement confirmationMessage;
	
	public TransferFundsPage() {
	    PageFactory.initElements(driver, this);
	}
	public void transferFunds(String fromAcc, String toAcc, String amount) {
		trnsferFounds.click();
	    new Select(fromAccountDropdown).selectByValue(fromAcc);
	    new Select(toAccountDropdown).selectByValue(toAcc);
	    amountInput.sendKeys(amount);
	    transferButton.click();
	}
	
	public boolean isTransferSuccessful() {
		WebElement confirmationElement = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//h1[normalize-space()='Transfer Complete!']")
		        )
		    );
		    return confirmationElement.isDisplayed();
    }
}
