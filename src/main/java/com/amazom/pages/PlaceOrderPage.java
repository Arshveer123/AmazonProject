package com.amazom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazom.base.TestBase;

public class PlaceOrderPage extends TestBase{

	@FindBy(xpath="//input[@aria-labelledby='bottomSubmitOrderButtonId-announce']")
	WebElement placeYourOrder;
	
	@FindBy(xpath="//h4[text()='Order placed, thanks.']")
	WebElement confirmationMsg;
	
	public PlaceOrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPlaceOrder() {
		placeYourOrder.click();
	}
	
	public boolean confirmationMessage() {
	return	confirmationMsg.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
