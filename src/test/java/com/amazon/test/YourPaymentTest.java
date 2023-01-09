package com.amazon.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazom.base.TestBase;
import com.amazom.pages.AccountPage;
import com.amazom.pages.AddressPage;
import com.amazom.pages.Homepage;
import com.amazom.pages.LoginPage;
import com.amazom.pages.YourOrderPage;
import com.amazom.pages.YourPayment;
import com.amazom.pages.addingCreditDebitCard;
import com.amazon.util.Utilities;

public class YourPaymentTest extends TestBase {
	Utilities utilities;
	LoginPage loginpage;
	Homepage homePage;
	AddressPage addressPage;
	AccountPage accountPage;
	YourOrderPage yourOrder;
	YourPayment yourPayment;
	addingCreditDebitCard addingcreditdebit;

	@BeforeMethod
	public void setUp() {
		intialization();
		utilities = new Utilities();
		loginpage = new LoginPage();
		loginpage.enterEmail(prop.getProperty("username"));
		homePage = loginpage.enterPassword(prop.getProperty("password"));
		homePage.moveToAccountsLink();
		accountPage = homePage.yourAccount();
		yourPayment = accountPage.yourPayment();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void addCreditOrDebitCard() {
		yourPayment.addingPaymentCard(prop.getProperty("creditcardnum"),prop.getProperty("name"),prop.getProperty("cvv"));

		Assert.assertTrue(yourPayment.confirmationMessage());
	}

}
