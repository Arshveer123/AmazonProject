package com.amazon.test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazom.base.TestBase;
import com.amazom.pages.GuestUser;
import com.amazom.pages.proctocheckout;
import com.amazon.util.Utilities;

public class GuestUserTest extends TestBase {
	GuestUser guestUser;
	proctocheckout proctochec;
	
	public GuestUserTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		Utilities.navigateToUrl(prop.getProperty("url1"));
		guestUser=new GuestUser();
		proctochec=new proctocheckout();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}
	//checking if the user is able to buy product as guest user
	@Test
	public void guestUserTest() throws InterruptedException {
		
		guestUser.buyingProductAsGuestUser(prop.getProperty("productName"));
		
		
		guestUser.addingProductToCart();
		
		proctochec.proctocheck();
		
  
		boolean flag=guestUser.isSigninLogoDisplayed();
		System.out.println(flag);
		Assert.assertTrue(!flag);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
