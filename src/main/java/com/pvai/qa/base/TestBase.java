package com.pvai.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pvai.qa.util.TestUtil;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static FluentWait<WebDriver> wait;
	
	
	public TestBase() {
		
		//Initializing property file
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/pvai/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	@SuppressWarnings("deprecation")
	public  static void initialization() {
		
		String browser=prop.getProperty("browser");
		
		//Creating instance of Chrome driver
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
			driver=new ChromeDriver();
		}	
		
		//Maximizing window
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));

	}
}
