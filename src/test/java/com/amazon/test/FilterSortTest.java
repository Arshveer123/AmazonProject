package com.amazon.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazom.base.TestBase;
import com.amazom.pages.FilterSort;
import com.amazom.pages.Homepage;
import com.amazom.pages.LoginPage;
import com.amazon.util.Utilities;

public class FilterSortTest extends TestBase {
	Utilities utilities;
	LoginPage loginpage;
	Homepage homePage;
	FilterSort filterSort;

	@BeforeMethod
	public void setUp() {
		intialization();
		utilities = new Utilities();
		loginpage = new LoginPage();
		loginpage.enterEmail(prop.getProperty("username"));
		homePage = loginpage.enterPassword(prop.getProperty("password"));
		filterSort = new FilterSort();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();

	}

	@Test
	public void sortingByNewArrival() {
		filterSort.sortingNewArrival(prop.getProperty("product"));
	}

	@Test
	public void sortingByCustomerReview() {
		Assert.assertTrue(filterSort.sortingByCustomerReview(prop.getProperty("product")));
	}

	@Test
	public void sortingByPrice() {
		Assert.assertTrue(filterSort.sortByPriceHighToLow(prop.getProperty("product")));

	}
	
	@Test
	public void sortingByPriceLowToHigh() {
		Assert.assertTrue(filterSort.sortByPriceLowToHigh(prop.getProperty("product")));
	}
	
	@Test
	public void sortingByFeature() {
		Assert.assertTrue(filterSort.sortByFeatures(prop.getProperty("product")));
	}

	@Test
	public void filterByNewArrival() {
		
		Assert.assertTrue(filterSort.filterByNewArrival(prop.getProperty("productsFilter")));
	
	}

	@Test
	public void filterByPrice() {
		Assert.assertTrue(filterSort.filterByPrice(prop.getProperty("productsFilter")));
	}
	
	@Test
	public void filterByNewArrivalfromLast90Days() {
		
		Assert.assertTrue(filterSort.filteringFromLast90Days(prop.getProperty("productsFilter")));
	}
	
	@Test
	public void filterByCustomerRating() {
		Assert.assertTrue(filterSort.filterByCustomerRating(prop.getProperty("productsFilter")));
	}

	@Test
	public void filterByBrandName() {
		Assert.assertTrue(filterSort.filterByCustomerRating(prop.getProperty("productsFilter")));
	}














}
