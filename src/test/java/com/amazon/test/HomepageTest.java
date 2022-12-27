package com.amazon.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazom.base.TestBase;
import com.amazom.pages.Homepage;
import com.amazom.pages.LoginPage;
import com.amazon.util.Utilities;

public class HomepageTest extends TestBase {

	LoginPage loginpage;
	Homepage homePage;
	Utilities utilities;

	public HomepageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		utilities = new Utilities();
		loginpage = new LoginPage();
		loginpage.enterEmail(prop.getProperty("username"));
		homePage = loginpage.enterPassword(prop.getProperty("password"));

	}
@Test
	public void verifyUserLabel() {
		boolean flag = homePage.usernameCheck();
		Assert.assertTrue(flag);
	}
	@Test
	public void verifyYourAccount() {
		homePage.moveToAccountsLink();
		homePage.yourAccount();
	String title = 	utilities.getTitle(driver);
	Assert.assertEquals(title,"Your Account");
	}
}
