package com.amazom.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazom.base.TestBase;

public class proctocheckout extends TestBase {

	@FindBy(xpath = "(//input[@data-feature-id='proceed-to-checkout-action'])[1]")
	WebElement procToCheck;
	
	@FindBy(xpath="//a[@data-csa-c-content-id= 'sw-gtc_CONTENT']")
	WebElement goToCart;

	public proctocheckout() {
		PageFactory.initElements(driver, this);

	}

	public void proctocheck() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// wait.until(ExpectedConditions.stalenessOf(addtoCartBtn));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@data-feature-id='proceed-to-checkout-action'])[1]")));
		procToCheck.click();
	}
	
	public void goToCartClick(){
		goToCart.click();
	}

}
