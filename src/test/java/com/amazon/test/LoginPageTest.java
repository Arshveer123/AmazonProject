package com.amazon.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazom.base.TestBase;
import com.amazom.pages.LoginPage;
import com.amazon.util.Utilities;

public class LoginPageTest extends TestBase {
	

	LoginPage loginPage;
	Utilities utilities;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage = new LoginPage();
		utilities = new Utilities();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test
	public void CorrectUsernameAndPass() {
		loginPage.enterEmail(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));

	}

	@Test
	public void emptyUsername() {
		loginPage.enterEmail("");
		String actualmsg = loginPage.emptyFieldsText();
		Assert.assertTrue(actualmsg.contains("Enter your e-mail address"));

	}

	@Test
	public void emptyPassword() {
		loginPage.enterEmail(prop.getProperty("username"));
		loginPage.enterPassword("");
		String actualmsg = loginPage.emptyFieldsText();
		Assert.assertTrue(actualmsg.contains("Enter your password"));

	}

	@Test
	public void incorrectUsername() {
		loginPage.enterEmail(prop.getProperty("WrongUser"));
		String actualmsg = loginPage.inccorrectUser();
		Assert.assertTrue(actualmsg.contains("We cannot find an account with that e-mail"));

	}

	@Test
	public void incorrectPassword() {
		loginPage.enterEmail(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("Wrongpassword"));
		String actual = loginPage.inccorrectPass();
		System.out.println(actual);
		Assert.assertTrue(actual.length()>0);
	}
}
