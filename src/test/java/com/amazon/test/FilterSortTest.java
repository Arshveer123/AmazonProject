package com.amazon.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

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
	Logger log;

	@BeforeMethod
	public void setUp() {
		intialization();
		utilities = new Utilities();
		loginpage = new LoginPage();
		loginpage.enterEmail(prop.getProperty("username"));
		homePage = loginpage.enterPassword(prop.getProperty("password"));
		filterSort = new FilterSort();
		log = Logger.getLogger(FilterSortTest.class);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();

	}

	@Test
	public void sortingByNewArrival() {
		filterSort.sortingNewArrival(prop.getProperty("product"));
		log.info("this method is to filter items based upon their data of arrival");
	}

	@Test
	public void sortingByCustomerReview() {
		Assert.assertTrue(filterSort.sortingByCustomerReview(prop.getProperty("product")));
		log.info("this filter is to sort items baased upon customer review");
	}

	@Test
	public void sortingByPrice() {
		Assert.assertTrue(filterSort.sortByPriceHighToLow(prop.getProperty("product")));
		log.info("this filter is to sort items based upon its price");

	}

	@Test
	public void sortingByPriceLowToHigh() {
		Assert.assertTrue(filterSort.sortByPriceLowToHigh(prop.getProperty("product")));
		log.info("this filter is to sort items based upon its price from low to high");
	}

	@Test
	public void sortingByFeature() {
		Assert.assertTrue(filterSort.sortByFeatures(prop.getProperty("product")));
		log.info("this filter is to sort items based upon its features");
	}

	@Test
	public void filterByNewArrival() {

		Assert.assertTrue(filterSort.filterByNewArrival(prop.getProperty("productsFilter")));

	}

	@Test
	public void filterByPrice() {
		Assert.assertTrue(filterSort.filterByPrice(prop.getProperty("productsFilter")));
		log.info("this filter is to sort items based upon its price under 25");
	}

	@Test
	public void filterByNewArrivalfromLast90Days() {

		Assert.assertTrue(filterSort.filteringFromLast90Days(prop.getProperty("productsFilter")));
		log.info("checking  if new arrival filter is displayed or not");
	}

	@Test
	public void filterByCustomerRating() {
		Assert.assertTrue(filterSort.filterByCustomerRating(prop.getProperty("productsFilter")));
		log.info("this filter is to sort items based upon customer rating");
	}

	@Test
	public void filterByBrandName() {
		Assert.assertTrue(filterSort.filterByCustomerRating(prop.getProperty("productsFilter")));
		log.info("this filter is to sort items based upon brand name");
	}

}
