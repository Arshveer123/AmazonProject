package com.amazom.pages;


import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazom.base.TestBase;

public class SearchingPage extends TestBase {

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBar;

	@FindBy(css = "[class='s-suggestion-container']")
	List<WebElement> searchSuggestions;

	@FindBy(id = "nav-search-submit-button")
	WebElement searchBtn;

	@FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
	WebElement prodText;

	@FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
	List<WebElement> prodList;

	@FindBy(xpath = "//th[contains(text(),'ASIN')]//following-sibling::td")
	WebElement asinText;

	@FindBy(xpath = "//select[@aria-describedby='searchDropdownDescription']")
	WebElement catgorySelect;

	@FindBy(css = "[aria-label='Go to next page, page 2']")
	WebElement nextPage;

	@FindBy(xpath = "//span[contains(text(),'25-4')]")
	WebElement secondpageText;

	public SearchingPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean searchByPartialText(String prodName) {
		searchBar.clear();
		searchBar.sendKeys(prodName);
		int i = 0;
		boolean flag;
		for (WebElement e : searchSuggestions) {
			String txt = e.getText();
			if (txt.contains(prodName)) {
				i++;
			}

		}
		if (i == 10) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}

	public String searchDescriptionTxt(String productDes) {
		searchBar.clear();
		searchBar.sendKeys(productDes);
		searchBtn.click();
		return prodText.getText();

	}
	
	public void clickOnProductToBuy() {
		prodText.click();
	}

	public boolean searchByKeyword(String keyword) {
		searchBar.clear();
		searchBar.sendKeys(keyword);
		searchBtn.click();
		boolean flag = false;
		int i = 0;

		for (WebElement ele : prodList) {
			String txt = ele.getText();
			System.out.println(txt);
			if (txt.contains(keyword))
				i++;

		}
		System.out.println(i);
		if (i >= 30) {
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

	public String searchByAsin(String ASIN) {
		searchBar.clear();
		searchBar.sendKeys(ASIN);
		searchBtn.click();
		prodText.click();
		return asinText.getText();
	}

	public String searchByCatagory(String catText) {
		searchBar.clear();
		Select select = new Select(catgorySelect);
		select.selectByVisibleText(catText);
		searchBtn.click();
		String s = driver.getTitle();
		return s;

	}

	public boolean productSize(String prodName) {
		searchBar.clear();
		searchBar.sendKeys(prodName);
		searchBtn.click();
		int i = prodList.size();
		System.out.println(i);
		boolean flag;
		if (i <= 60) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;

	}

	public void nextPage(String prodName) {
		searchBar.clear();
		searchBar.sendKeys(prodName);
		searchBtn.click();
		nextPage.click();

	}

	public boolean ifItemsAreUnique(String prodName) {
		searchBar.clear();
		searchBar.sendKeys(prodName);
		searchBtn.click();
		boolean flag;

		
		List<Object> prodText = prodList.stream().map(x -> x.getText()).distinct().collect(Collectors.toList());
		System.out.println(prodText.size());
		System.out.println(prodList.size());
		
		
		if (prodText.size() == prodList.size()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

}
