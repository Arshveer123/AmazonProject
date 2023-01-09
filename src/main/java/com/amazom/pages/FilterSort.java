package com.amazom.pages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazom.base.TestBase;
import com.amazon.util.Utilities;

public class FilterSort extends TestBase {
	Utilities utilities = new Utilities();

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBar;

	@FindBy(id = "nav-search-submit-button")
	WebElement searchBtn;

	@FindBy(xpath = "//select[@id='s-result-sort-select']")
	WebElement selectDropDown;

	@FindBy(xpath = "//span[text()='Featured' and @class='a-dropdown-prompt']")
	WebElement featured;

	@FindBy(xpath = "//span[@class='a-price-whole']")
	List<WebElement> priceList;

	@FindBy(xpath = "//span//span[@class='a-size-base']")
	List<WebElement> customerRating;

	@FindBy(xpath = "//span[text()='New Arrivals']")
	WebElement newArrivalFilter;

	@FindBy(xpath = "(//span[text()='Last 90 days'])[2]")
	WebElement last90Days;

	@FindBy(xpath = "//span[text()='Under $25']")
	WebElement priceFilter;

	@FindBy(xpath = "//i[@class='a-icon a-icon-star-medium a-star-medium-4']")
	WebElement customerRatingSelection;

	@FindBy(xpath = "//span//span[@class='a-size-base']")
	List<WebElement> ratingOnProduct;

	@FindBy(xpath = "//div[@id='brandsRefinements']//li[@aria-label='Amazon Essentials']")
	WebElement brandsFilter;

	@FindBy(xpath = "//span[@class='a-size-base-plus a-color-base']")
	List<WebElement> brandName;

	public FilterSort() {
		PageFactory.initElements(driver, this);
	}

	public void sortingNewArrival(String product) {
		searchBar.clear();
		searchBar.sendKeys(product);
		searchBtn.click();
		Utilities.selectByvalue(selectDropDown, "Newest arrivals");

	}

	public boolean sortingByCustomerReview(String product) {
		searchBar.clear();
		searchBar.sendKeys(product);
		searchBtn.click();
		Utilities.selectByvalue(selectDropDown, "Avg. customer review");

		ArrayList<String> list = new ArrayList<>();
		for (WebElement e : customerRating) {
			String rating = e.getText();
			list.add(rating);
		}
		List<String> l = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(l);
		boolean flag = list.equals(l);
		return flag;
	}

	public boolean sortByPriceHighToLow(String product) {
		searchBar.clear();
		searchBar.sendKeys(product);
		searchBtn.click();
		Utilities.selectByvalue(selectDropDown, "Price: High to low");

		ArrayList<String> list = new ArrayList<>();
		for (WebElement e : priceList) {
			String rating = e.getText();
			list.add(rating);
		}
		List<String> l = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(l);
		boolean flag = list.equals(l);
		return flag;

	}

	public boolean sortByPriceLowToHigh(String product) {
		searchBar.clear();
		searchBar.sendKeys(product);
		searchBtn.click();
		Utilities.selectByvalue(selectDropDown, "Price: Low to high");

		ArrayList<String> list = new ArrayList<>();
		for (WebElement e : priceList) {
			String rating = e.getText();
			list.add(rating);
		}
		List<String> l = list.stream().sorted().collect(Collectors.toList());
		System.out.println(list);
		System.out.println(l);
		boolean flag = list.equals(l);
		return flag;

	}

	public boolean sortByFeatures(String product) {
		searchBar.clear();
		searchBar.sendKeys(product);
		searchBtn.click();
		Utilities.selectByvalue(selectDropDown, "Featured");
		return featured.isDisplayed();

	}

	public boolean filterByNewArrival(String product) {
		searchBar.clear();
		searchBar.sendKeys(product);
		searchBtn.click();
		return newArrivalFilter.isDisplayed();
	}

	public boolean filteringFromLast90Days(String product) {
		searchBar.clear();
		searchBar.sendKeys(product);
		searchBtn.click();
		return last90Days.isDisplayed();

	}

	public boolean filterByPrice(String product) {
		searchBar.clear();
		searchBar.sendKeys(product);
		searchBtn.click();
		priceFilter.click();
		boolean flag = false;
		ArrayList<String> list = new ArrayList<>();
		for (WebElement e : priceList) {
			String rating = e.getText();
			list.add(rating);
		}
		List<String> l = list.stream().filter(x -> (Double.parseDouble(x) <= 25)).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(l);
		if (l.size() == list.size()) {
			flag = true;
		}
		return flag;
	}

	public boolean filterByCustomerRating(String product) {
		searchBar.clear();
		searchBar.sendKeys(product);
		searchBtn.click();
		customerRatingSelection.click();
		boolean flag = false;
		ArrayList<String> list = new ArrayList<>();
		for (WebElement e : ratingOnProduct) {
			String rating = e.getText();
			list.add(rating);
		}
		
		List<String> l = list.stream().filter(x -> ((Double.parseDouble(x)) >=4 && (Double.parseDouble(x)) <= 5 )).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(l);
		if (l.size() == list.size()) {
			flag = true;
		}
		return flag;
		
		}
	
	public boolean filterByBrandName(String product) {
		searchBar.clear();
		searchBar.sendKeys(product);
		searchBtn.click();
		brandsFilter.click();
		boolean flag=false;
		ArrayList<String> list = new ArrayList<>();
		for (WebElement e : brandName) {
			String brandName = e.getText();
			list.add(brandName);
		}
	if(	list.stream().distinct().collect(Collectors.toList()).size()==1) {
		flag=true;
		
	}
	return flag;
	}





























}
