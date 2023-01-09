package com.amazom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazom.base.TestBase;

public class productInfoPage extends TestBase {

	@FindBy(xpath = "//select[@id='quantity' and @name='quantity' and @data-a-native-class='improvedMOQQuantitySelectCss']")
	WebElement quantitySelect;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addToCart;

	public productInfoPage() {
		PageFactory.initElements(driver, this);
	}
	public void addToCartBtn() {
		addToCart.click();
	}
}
