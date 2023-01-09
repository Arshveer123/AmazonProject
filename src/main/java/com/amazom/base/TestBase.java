package com.amazom.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.util.WebEventListener1;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("deprecation")
public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	@SuppressWarnings("deprecation")
	public static EventFiringWebDriver edriver;
	public static WebEventListener1 eventListener;
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
	@SuppressWarnings("deprecation")
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
		
		edriver=new EventFiringWebDriver(driver);
		eventListener = new WebEventListener1();
		edriver.register(eventListener);
		driver = edriver;
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		

	}
}
