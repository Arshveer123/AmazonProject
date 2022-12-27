package com.amazom.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazom.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(css = "#ap_email")
	WebElement emailId;

	@FindBy(css = "#continue")
	WebElement continueButton;

	@FindBy(css = "#ap_password")
	WebElement password;

	@FindBy(css = "#signInSubmit")
	WebElement signinButton;

	@FindBy(css = ".a-list-item")
	WebElement wrongUsername;

	@FindBy(css = ".a-list-item")
	WebElement wrongPassword;

	@FindBy(xpath = "(//div[@class='a-alert-content'])[2]")
	WebElement emptyPassword;

	@FindBy(css = "div#auth-email-missing-alert")
	WebElement emptyId;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String username) {
		emailId.sendKeys(username);
		continueButton.click();
	}

	public Homepage enterPassword(String passwd) {
		password.sendKeys(passwd);
		signinButton.click();
		return new Homepage();

	}
	public String emptyFieldsText() {
		return emptyPassword.getText();
	}
	
	public String inccorrectUser() {
		return wrongUsername.getText();
	}
	public String inccorrectPass() {
		return wrongPassword.getText();

}
}
