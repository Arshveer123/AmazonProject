package com.amazom.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazom.base.TestBase;
import com.amazon.util.Utilities;

public class addingCreditDebitCard extends TestBase{
	
	JavascriptExecutor js;
	@FindBy(xpath="//input[@name='addCreditCardNumber']")
	WebElement cardNumber;
	
	@FindBy(css="[name='ppw-accountHolderName']")
	WebElement nameOnCard;
	
	@FindBy(css="[name='addCreditCardVerificationNumber']")
	WebElement cvv;
	
	@FindBy(xpath="(//span[@class='a-button-text a-declarative' and @role='button'])[1]")
	WebElement monthSelect;
	
	@FindBy(xpath="(//span[@class='a-button-text a-declarative' and @role='button'])[2]")
	WebElement yearSelect;
	
	@FindBy(xpath="(//a[@class='a-dropdown-link'] )[9]")
	WebElement selectMonth;
	
	@FindBy(css="(//a[@class='a-dropdown-link'] )[15]")
	WebElement selectYear;
	
	@FindBy(xpath="//span[@class='a-button a-button-primary pmts-button-input']")
	WebElement addCard;
	
	@FindBy(css="[name='ppw-widgetEvent:SelectAddressEvent']")
	WebElement useThisAddress;
	
	@FindBy(xpath="//input[@name='ppw-widgetEvent:SavePaymentMethodDetailsEvent']")
	WebElement saveButton;
	
	public addingCreditDebitCard() {
		PageFactory.initElements(driver, this);
	}

	public void addingPaymentCarddetails(String cardNum,String cardHolderName, String cvvNum) {
	js= (JavascriptExecutor) driver;  
	
Utilities.sendKeysByJS(driver, cardNumber, cardNum);
Utilities.sendKeysByJS(driver,nameOnCard, cardHolderName);
Utilities.sendKeysByJS(driver, cvv, cvvNum);
	
	monthSelect.click();
	selectMonth.click();
	yearSelect.click();
	selectYear.click();

	addCard.click();
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
