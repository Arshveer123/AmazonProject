package com.amazom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazom.base.TestBase;

public class Homepage extends TestBase {

	@FindBy(css = "#nav-link-accountList-nav-line-1")
	WebElement usernameLabel;

	@FindBy(xpath = "//a[@data-nav-role='signin' ]//span[@class='nav-icon nav-arrow']")
	WebElement dropdownicon;

	@FindBy(xpath = "//span[text()='Your Account']")
	WebElement yourAccountLink;

	@FindBy(xpath = "//span[text()='Your Orders']")
	WebElement yourOrderLink;

	@FindBy(xpath = "//span[text()='Your Recommendations']")
	WebElement yourRecommenLink;

	@FindBy(xpath = "//span[text()='Memberships & Subscriptions']")
	WebElement MembershipsLink;

	@FindBy(xpath = "//span[text()='Switch Accounts']")
	WebElement switchAccountlink;
	
	@FindBy(xpath="//div[text()='Add account']")
	WebElement switchAccText;

	@FindBy(xpath = "//span[text()='Sign Out']")
	WebElement signOutlink;

	@FindBy(xpath = "//span[text()='Find a Gift']")
	WebElement findGiftlink;

	@FindBy(xpath = "//span[text()='Baby Registry']")
	WebElement babyRegistrylink;

	@FindBy(xpath = "//span[text()='Register for a Business Account']")
	WebElement RegisterBusinesslink;

	@FindBy(xpath = "//span[text()='Explore Showroom']")
	WebElement exploreShowroomlink;
	
	@FindBy(css="a[aria-label='Recommended For You']>span.nav-a-content")
	WebElement recommendationText;

	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	public void moveToAccountsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(dropdownicon).build().perform();

	}

	public boolean usernameCheck() {
		return usernameLabel.isDisplayed();
	}

	public AccountPage yourAccount() {
		yourAccountLink.click();
		return new AccountPage();

	}

	public YourOrderPage yourOrder() {
		yourOrderLink.click();
		return new YourOrderPage();

	}
	public String recommendatioText() {
		return recommendationText.getText();
		
	}
	

	public void yourRec() {
		yourRecommenLink.click();
		

	}

	public void membershiplink() {
		MembershipsLink.click();
	}

	public String switchAcclink() {
		switchAccountlink.click();
		 return switchAccText.getText();
	}
	

	public void signOut() {
		signOutlink.click();
	}

	public void findGiftLink() {
		findGiftlink.click();
	}

	public void babyReg() {
		babyRegistrylink.click();
	}

	public void registerBussLink() {
		RegisterBusinesslink.click();
	}

	public void exploreShowroom() {
		exploreShowroomlink.click();
	}
}
