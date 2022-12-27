package com.amazon.util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazom.base.TestBase;

public class Utilities extends TestBase {
	
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
		
	}
public void waitfor(WebDriver driver, WebElement ele) {
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(ele));
}
}
