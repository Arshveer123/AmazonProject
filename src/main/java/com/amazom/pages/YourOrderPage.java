package com.amazom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazom.base.TestBase;

public class YourOrderPage extends TestBase {

	@FindBy(xpath = "//span[text()='December 24, 2022']")
	WebElement orderDate;

	@FindBy(xpath = "//li[@role='tab']//a[contains(text(),'Buy Again')]")
	WebElement buyAgainLink;

	@FindBy(xpath = " //a[contains(text(),'Not Yet Shipped')]")
	WebElement notShippedLink;

	@FindBy(xpath = " //a[contains(text(),'Cancelled Orders')]")
	WebElement cancelledOrderLink;

	@FindBy(xpath = "(//span[contains(text(),'NESTLÉ Materna Prenatal Multiv')])[2]")
	WebElement buyAgainProduct;

	@FindBy(xpath = "//div[contains(text(),'Looking for an order? ')]")
	WebElement notShippedProduct;

	@FindBy(xpath = "//div[@class='a-row a-size-mini yohtmlc-order-id']//bdi[contains(text(),'70')]")
	WebElement cancelOrderNo;

	@FindBy(xpath = "//label[@for='orderFilter']")
	WebElement cancelledOrderText;

	@FindBy(css = ".a-dropdown-prompt")
	WebElement orderPlacedMonth;

	public YourOrderPage() {
		PageFactory.initElements(driver, this);
	}

	public String orderDateTest() {
		return orderDate.getText();
	}

	public boolean last3monthOrder() {
		return orderPlacedMonth.isDisplayed();
	}

	public boolean BuyagainProductDisplayed() {
		buyAgainLink.click();
		return buyAgainProduct.isDisplayed();
	}

	public String notShippedLink() {
		notShippedLink.click();
		return notShippedProduct.getText();
	}

	public boolean cancelOrderNo() {
		cancelledOrderLink.click();
		return cancelOrderNo.isDisplayed();
	}

	public String cancelOrderText() {
		cancelledOrderLink.click();
		return cancelledOrderText.getText();

	}

}
