package com.amazon.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test(enabled=false)
	public void verifyUserLabel() {
		boolean flag = homePage.usernameCheck();
		Assert.assertTrue(flag);
	}

	@Test(enabled=false)
	public void yourAccountTest() {
		homePage.moveToAccountsLink();
		homePage.yourAccount();
		String title = utilities.getTitle();
		Assert.assertEquals(title, "Your Account");
	}

	@Test(enabled=false)
	public void yourOrderTest() {
		homePage.moveToAccountsLink();
		homePage.yourOrder();
		String title = utilities.getTitle();
		Assert.assertEquals(title, "Your Orders");
	}

	@Test(enabled=false)
	public void yourRecommendationTest() {
		homePage.moveToAccountsLink();
		homePage.yourRec();
		String text=homePage.recommendatioText();
		Assert.assertEquals(text, "Recommended For You");
	}
	
	@Test(enabled=false)
	public void membershiplinkTest() {
		homePage.moveToAccountsLink();
		homePage.membershiplink();
		String title= utilities.getTitle();
		Assert.assertEquals(title,"Your Memberships & Subscriptions");
	}
	
	@Test(enabled=false)
	public void switchAccTest() {
		homePage.moveToAccountsLink();
		String text=homePage.switchAcclink();
		Assert.assertEquals(text, "Add account");
	}
	
	@Test(enabled=false)
	public void signOutTest() {
		homePage.moveToAccountsLink();
		homePage.signOut();
		String title= utilities.getTitle();	
		Assert.assertEquals(title, "Amazon Sign In");
		}
	
	@Test(enabled=false)
	public void findGiftTest() {
		homePage.moveToAccountsLink();
		homePage.findGiftLink();
		String title= utilities.getTitle();
		Assert.assertEquals(title,"Gifts for Everyone | Amazon.ca Gift Finder");
		
	}
	
	@Test
	public void babyRegisteryTest() {
		homePage.moveToAccountsLink();
		homePage.babyReg();
		String title= utilities.getTitle();
		Assert.assertEquals(title, "Amazon.ca: Baby Registry");
	}
	
	@Test
	public void regBusinessTest() {
		homePage.moveToAccountsLink();
		homePage.registerBussLink();
		String title= "Amazon Business";
		Assert.assertEquals(title, "Amazon Business");
	}
	
	@Test
	public void exploreShowroomTest() {
		homePage.moveToAccountsLink();
		homePage.exploreShowroom();
		String actTitle= utilities.getTitle();
		String exptitle= "Welcome to Amazon's Showroom";
		Assert.assertEquals(actTitle, exptitle);		
	}
}
