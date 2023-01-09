package com.amazom.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazom.base.TestBase;
import com.amazon.util.Utilities;

public class YourPayment extends TestBase {

	JavascriptExecutor js;

	@FindBy(xpath = "(//a[@class='a-link-normal apx-wallet-add-link'])[1]")
	WebElement addPayment;

	@FindBy(css = "span.a-button-inner>input.a-button-input")
	WebElement addCreditOrDebit;

	@FindBy(xpath = "//input[@name='addCreditCardNumber']")
	WebElement cardNumber;

	@FindBy(css = "[name='ppw-accountHolderName']")
	WebElement nameOnCard;

	@FindBy(css = "[name='addCreditCardVerificationNumber']")
	WebElement cvv;

	@FindBy(xpath = "(//span[@class='a-button-text a-declarative' and @role='button'])[1]")
	WebElement monthSelect;

	@FindBy(xpath = "(//span[@class='a-button-text a-declarative' and @role='button'])[2]")
	WebElement yearSelect;

	@FindBy(xpath = "(//a[@class='a-dropdown-link'] )[9]")
	WebElement selectMonth;

	@FindBy(css = "(//a[@class='a-dropdown-link'] )[15]")
	WebElement selectYear;

	@FindBy(xpath = "//span[@class='a-button a-button-primary pmts-button-input']")
	WebElement addCard;

	@FindBy(css = "[name='ppw-widgetEvent:SelectAddressEvent']")
	WebElement useThisAddress;

	@FindBy(xpath = "//input[@name='ppw-widgetEvent:SavePaymentMethodDetailsEvent']")
	WebElement saveButton;

	@FindBy(xpath = "//span[contains(text(),'method')]")
	WebElement confirmationMessage;

	public YourPayment() {
		PageFactory.initElements(driver, this);
	}

	public void addingPaymentCard(String cardNum, String cardHolderName, String cvvNum) {

		addPayment.click();
		addCreditOrDebit.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parent=it.next();
		String child= it.next();
		System.out.println(parent+"  "+child);
		driver.switchTo().window(child);
		
		js = (JavascriptExecutor) driver;

		Utilities.sendKeysByJS(driver, cardNumber, cardNum);
		Utilities.sendKeysByJS(driver, nameOnCard, cardHolderName);
		Utilities.sendKeysByJS(driver, cvv, cvvNum);

		monthSelect.click();
		selectMonth.click();
		yearSelect.click();
		selectYear.click();

		addCard.click();

	}

	public boolean confirmationMessage() {
		useThisAddress.click();
		saveButton.click();
		driver.switchTo().defaultContent();
		return confirmationMessage.isDisplayed();
	}

}
