package com.amazon.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazom.base.TestBase;
import com.amazom.pages.Homepage;
import com.amazom.pages.LoginPage;
import com.amazom.pages.NextPage;
import com.amazom.pages.SearchingPage;
import com.amazon.util.Utilities;

public class SearchTest extends TestBase {
	Utilities utilities;
	LoginPage loginpage;
	Homepage homePage;
	SearchingPage searchPage;
	 String cat;
	 NextPage nextPage;

	@BeforeMethod
	public void setUp() {
		intialization();
		utilities = new Utilities();
		loginpage = new LoginPage();
		loginpage.enterEmail(prop.getProperty("username"));
		homePage = loginpage.enterPassword(prop.getProperty("password"));
		searchPage = new SearchingPage();
		nextPage=new NextPage();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test
	public void searchByPartialText() {
		Assert.assertTrue(searchPage.searchByPartialText(prop.getProperty("partialItemText")));
	}

	@Test
	public void searchDescriptionText() {
		String prodName = prop.getProperty("description");
		Assert.assertEquals(prodName, searchPage.searchDescriptionTxt(prodName));
	}

	 @Test
	public void searchByKeyword() {
		Assert.assertTrue(searchPage.searchByKeyword(prop.getProperty("keyword")));
	}

	 @Test
	 public void searchByAsinTest() {
		String asin= prop.getProperty("asin");
		Assert.assertEquals(asin, searchPage.searchByAsin(asin));
		 
	 }
	 
	 @Test
	 public void searchByCatagory() {
		 cat=prop.getProperty("catagory");
		 String title=searchPage.searchByCatagory(cat);
		 Assert.assertTrue(title.contains(cat));
	 }

	 @Test
	 public void noOfProductsPerPage() {
		 Assert.assertTrue(searchPage.productSize(prop.getProperty("product")));
		 
	 }
	 
	 @Test
	 public void nextPageFunctionality() {
		 searchPage.nextPage(prop.getProperty("product"));
		Assert.assertTrue(nextPage.isProdCountDisplayed());
	 }

	 @Test
	 public void ifItemsAreUniqueOrNot() {
		 Assert.assertTrue(searchPage.ifItemsAreUnique(prop.getProperty("product")));
	 }




























}
