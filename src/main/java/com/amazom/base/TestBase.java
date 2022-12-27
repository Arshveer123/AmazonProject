package com.amazom.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	FileInputStream fis;

	public TestBase() {
		prop= new Properties();
		try {
		 fis= new FileInputStream("C:\\Users\\HH\\eclipse-workspace\\AmazonProject\\src\\main\\java\\com\\amazon\\env\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	public static void intialization() {

		String browser = prop.getProperty("browser");
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Please enter valid browser name");
			break;
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		

	}
}
