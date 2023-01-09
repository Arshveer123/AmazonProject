package com.amazon.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazom.base.TestBase;
import com.amazom.pages.Homepage;
import com.amazom.pages.LoginPage;
import com.amazom.pages.PlaceOrderPage;
import com.amazom.pages.SearchingPage;
import com.amazom.pages.ShoppingCart;
import com.amazom.pages.proctocheckout;
import com.amazom.pages.productInfoPage;
import com.amazon.util.Utilities;

public class ShoppingCartTest extends TestBase {
	Utilities utilities;
	LoginPage loginpage;
	Homepage homePage;
	proctocheckout proctocheck;
	SearchingPage searchingpage;
	productInfoPage productinfo;
	ShoppingCart shoppingCart;
	PlaceOrderPage placeOrder;

@BeforeMethod
public void setUp() {
	intialization();
	utilities = new Utilities();
	loginpage = new LoginPage();
	loginpage.enterEmail(prop.getProperty("username"));
	homePage = loginpage.enterPassword(prop.getProperty("password"));
	proctocheck= new proctocheckout();
	searchingpage=new SearchingPage();
	productinfo=new productInfoPage();
	shoppingCart= new ShoppingCart();
	placeOrder=new PlaceOrderPage();
}

@AfterMethod
public void tearDown() {
	driver.close();
}




@Test
public void verifyingProductInfo() {
	String prodText=searchingpage.searchDescriptionTxt(prop.getProperty("description"));

	searchingpage.clickOnProductToBuy();
	productinfo.addToCartBtn();
	proctocheck.goToCartClick();
	String prodNameinCart=shoppingCart.getProductName();
	System.out.println(prodText);
	System.out.println(prodNameinCart);
	Assert.assertTrue(prodText.contains(prodNameinCart.split("14")[0]));
	

}

@Test
public void verifyingTotalPriceInCart() {
	searchingpage.searchDescriptionTxt(prop.getProperty("description"));
	searchingpage.clickOnProductToBuy();
	productinfo.addToCartBtn();
	proctocheck.goToCartClick();
	shoppingCart.selectingQuantity();
	Assert.assertTrue(shoppingCart.verifyingPrice());
}

@Test
public void endToEndFlow() {
	
	searchingpage.searchDescriptionTxt(prop.getProperty("description"));
	searchingpage.clickOnProductToBuy();
	productinfo.addToCartBtn();
	proctocheck.proctocheck();
	placeOrder.clickOnPlaceOrder();
	boolean flag=placeOrder.confirmationMessage();
	Assert.assertTrue(flag);
	
	
	
	
}































}
