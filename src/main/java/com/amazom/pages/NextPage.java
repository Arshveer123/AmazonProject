package com.amazom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazom.base.TestBase;

public class NextPage extends TestBase{
	
	@FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
	WebElement secondpageText;
	
	public NextPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProdCountDisplayed() {
		return secondpageText.isDisplayed();
	}
}
