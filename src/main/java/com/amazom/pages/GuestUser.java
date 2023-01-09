package com.amazom.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazom.base.TestBase;

public class GuestUser extends TestBase {

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchbar;

	@FindBy(id = "nav-search-submit-button")
	WebElement searchBtn;

	@FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
	List<WebElement> productsList;

	@FindBy(xpath = "(//input[@id='add-to-cart-button'])[1]")
	WebElement addtoCartBtn;

	
	@FindBy(xpath = "//h1[@class='a-spacing-small']")
	WebElement signInLogo;

	public GuestUser() {
		PageFactory.initElements(driver, this);
	}

	public void buyingProductAsGuestUser(String productname) {
		searchbar.click();
		searchbar.sendKeys(productname);
		searchBtn.click();

		for (WebElement e : productsList) {
			String text = e.getText();
			if (text.contains(
					"ASUS Chromebook C403 Rugged & Spill Resistant Laptop, 14.0\" Anti-Glare HD, 180 Degree, Intel Celeron N3350, 4GB RAM, 32GB eMMC, MIL-STD 810G Durability, Chrome OS, C403NA-C1-CA")) {
				e.click();
				break;
			}
		}
	}

	public proctocheckout addingProductToCart() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// wait.until(ExpectedConditions.stalenessOf(addtoCartBtn));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@id='add-to-cart-button'])[1]")));
		addtoCartBtn.click();
		return new proctocheckout();

	}


	

	public boolean isSigninLogoDisplayed() {
		return signInLogo.isDisplayed();
	}

}