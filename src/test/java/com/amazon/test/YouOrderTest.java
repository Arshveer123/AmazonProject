package com.amazon.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazom.base.TestBase;
import com.amazom.pages.Homepage;
import com.amazom.pages.LoginPage;
import com.amazom.pages.YourOrderPage;
import com.amazon.util.Utilities;

public class YouOrderTest extends TestBase {

	Utilities utilities;
	LoginPage loginpage;
	Homepage homePage;
	YourOrderPage yourOrderPage;

	public YouOrderTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		utilities = new Utilities();
		loginpage = new LoginPage();
		loginpage.enterEmail(prop.getProperty("username"));
		homePage = loginpage.enterPassword(prop.getProperty("password"));
		homePage.moveToAccountsLink();
		yourOrderPage = homePage.yourOrder();

	}

	@AfterMethod()
	public void tearDown() {
		driver.close();

	}

	// order number of orders placed in last 3 months should be displayed
	@Test
	public void orderDateTest() {
		String actualDate = yourOrderPage.orderDateTest();
		String expDate = "December 24, 2022";
		Assert.assertEquals(actualDate, expDate);
	}

	// last 3 month orders dropdown should be displayed
	@Test
	public void orderPlacedMonthTest() {
		boolean flag = yourOrderPage.last3monthOrder();
		Assert.assertTrue(flag);
	}

	// checking if the product ordered before is displaying or not
	@Test
	public void BuyagainProductDisplayedTest() {
		boolean flag = yourOrderPage.BuyagainProductDisplayed();
		Assert.assertTrue(flag);
	}

	// checking if the message displays in case there is no product to ship

	@Test
	public void notShippedLinkTest() {
		String text = yourOrderPage.notShippedLink();
		Assert.assertTrue(text.contains("Looking for an order? All of your orders have shipped. "));
	}

	// checking if the order which got cancelled is displaying or not

	@Test
	public void cancelOrderNoTest() {
		 boolean flag= yourOrderPage.cancelOrderNo();
		 Assert.assertTrue(flag);
	}
	
	@Test
	public void cancelOrderTextTest() {
		String text= yourOrderPage.cancelOrderText();
		Assert.assertEquals(text, "1 cancelled order placed in the last 6 months");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}