package com.amazom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazom.base.TestBase;
import com.amazon.util.Utilities;

public class ShoppingCart extends TestBase{
	
	@FindBy(xpath="//span[@class='a-truncate-cut']")
	WebElement prodName;
	
	@FindBy(css="[data-a-native-class='sc-update-quantity-select ']")
	WebElement quantityInCart;
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
	WebElement priceOfOneProduct;
	
	@FindBy(xpath="//span[@id='sc-subtotal-amount-activecart']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
	WebElement totalPrice;
	
	public ShoppingCart() {
		PageFactory.initElements(driver, this);
	}
	
	public String getProductName() {
		return prodName.getText();
	}
	
	public void selectingQuantity() {
		Utilities.selectByvalue(quantityInCart, "3");
	
	}
	
	public boolean verifyingPrice() {
		String price=priceOfOneProduct.getText();
		System.out.println(price);
		return totalPrice.isDisplayed();
	}
	



































}
