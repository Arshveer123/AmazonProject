
package com.amazom.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazom.base.TestBase;

public class AccountPage extends TestBase {
	

	@FindBy(xpath = "//h2[contains(text(),'Your Addresses')]")
	WebElement youAddress;

	@FindBy(css = "[alt='Login & security']")
	WebElement loginSecurity;

	@FindBy(css = "[alt='Your Payments']")
	WebElement yourPayment;

	public AccountPage() {
		PageFactory.initElements(driver, this);
	}

	public AddressPage clickOnYourAddress1() {
		youAddress.click();
		return new AddressPage();
	}

	public LoginandSecurity loginAndSecurity() {
		loginSecurity.click();
		return new LoginandSecurity();
	}

	public YourPayment yourPayment() {
		yourPayment.click();
		return new YourPayment();
	}
}
