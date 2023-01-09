package com.amazon.util;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazom.base.TestBase;

public class Utilities extends TestBase {
	static URL url1;
	//HttpURLConnection huc=null;

	public String getTitle() {
		return driver.getTitle();

	}

	public void waitfor(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static JavascriptExecutor sendKeysByJS(WebDriver driver, WebElement ele, String value) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].setAttribute('value','" + value + "');", ele);
		return js;

	}

	public static void navigateToUrl(String url) {
		driver.navigate().to(url);

	}

	public static void explicitlyWaitForVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void selectByvalue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public static File takeScreenShot(String filePath) {
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File file = screenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filePath);

		try {
			FileUtils.copyFile(file, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destFile;

	}

	public static  void checkingBrokenLinks(String url) {
	
		try {
			url1 = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
		HttpURLConnection huc=	(HttpURLConnection)url1.openConnection();
		huc.setConnectTimeout(5000);
		huc.connect();
		if(huc.getResponseCode()>=400) {
			System.out.println(url+"---------------------This is broken link-------"+huc.getResponseMessage());
		} else {
			System.out.println(url+"---------------------This is not broken link------------"+huc.getResponseMessage());
		}
		
		
		
		
		
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//huc.setConnectTimeout(20);
		//huc.connect();

	}

}