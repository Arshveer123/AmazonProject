package com.amazon.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazom.base.TestBase;
import com.amazom.pages.Homepage;
import com.amazom.pages.LoginPage;
import com.amazon.util.Utilities;

public class BrokenLinks extends TestBase {
	LoginPage loginpage;
	Homepage homePage;
	
	public BrokenLinks() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		loginpage=new LoginPage();
		loginpage.enterEmail(prop.getProperty("username"));
		homePage = loginpage.enterPassword(prop.getProperty("password"));
		
	}
	
	
	@Test
	public void checkingBrokenLinks() {
		
	List<WebElement> links=	driver.findElements(By.tagName("a"));
	ArrayList<String> hrefAttribute=new ArrayList<String>();
	for(WebElement ele:links) {
		String href= ele.getAttribute("href");
		hrefAttribute.add(href);
	}
	hrefAttribute.parallelStream().forEach(x->Utilities.checkingBrokenLinks(x));
	
		
		}
		
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	

