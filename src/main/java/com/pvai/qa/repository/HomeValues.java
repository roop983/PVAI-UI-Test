package com.pvai.qa.repository;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pvai.qa.base.TestBase;


public class HomeValues extends TestBase{
	
	@FindBy(xpath="//div/input[@id='rewLocation']//preceding-sibling::h3")
	WebElement connectEstateAgents;
	
	@FindBy(xpath="//div/input[@id='rewLocation'][@placeholder='Zip Code']")
	WebElement inputZipCode;
	
	@FindBy(xpath="//div[input[@id='rewLocation']]/button[@class='goBtn rewGetQuoteGo']")
	WebElement goButton;
	
	@FindBy(xpath="//div[@class='proCard Step']/h3")
	WebElement typeRealEstateInfo;
	
	
	@FindBy(xpath="//ul[@id='rewCategoryOptionBinder']/li/input")
	List<WebElement> list;
	
	@FindBy(xpath="//ul[@id='rewCategoryOptionBinder']/descendant::label[text()='Home Values']//preceding-sibling::input")
	WebElement homeValuesRadio;
	
	@FindBy(xpath="//div[@class='proCard Step']/button[text()='Continue']")
	WebElement continueBtnAfterEstInfo;
	
	
	
	String keyname;
	Double latValue;
	Double longValue;
	
	
	public HomeValues() {
		this.driver = driver;
		//this.wait = wait;
		PageFactory.initElements(driver, this);
		wait = new FluentWait<WebDriver>(driver)
				// Check for condition in every 2 seconds
				.pollingEvery(Duration.ofSeconds(2))
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(30))
				.ignoring(NoSuchElementException.class);
		
	}	
	
	public HomeValues(String keyname, Double latValue, Double longValue) {
		this.keyname=keyname;
		this.latValue=latValue;
		this.longValue=longValue;
		
	}	
	
	public String getKeyName() {
		return keyname;
	}
	
	public Double getLatitude() {
		return latValue;
	}
	
	public Double getLongitude() {
		return longValue;
	}
	
	public String toString() {
		return keyname+" "+latValue+" "+longValue;
	}
	
	
	public void searchPlace(String searchValue) {
		driver.get(prop.getProperty("url"));
		wait.until(ExpectedConditions.elementToBeClickable(toSearchBoxInput));
		toSearchBoxInput.sendKeys(searchValue);
		searchButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(directions));
	}
	
	
	public List<HomeValues> extractCoordinatesList(String keyname){
		List<HomeValues> list =new ArrayList<HomeValues> ();
		String getCoordinatesURL = driver.getCurrentUrl();
		
		double latValue = Double.parseDouble(getCoordinatesURL.substring(getCoordinatesURL.indexOf('@')+1, getCoordinatesURL.lastIndexOf('/')).split(",")[0]);
		double longValue = Double.parseDouble(getCoordinatesURL.substring(getCoordinatesURL.indexOf('@')+1, getCoordinatesURL.lastIndexOf('/')).split(",")[1]);
		System.out.println(latValue);
		System.out.println(longValue);
		HomeValues l1=new HomeValues(keyname,latValue,longValue);
		list.add(l1);
		return list;
	}
	
	public Map<String, Double> extractCoordinates(String keyname){
		Map<String, Double> map = new HashMap<String, Double>();
		String getCoordinatesURL = driver.getCurrentUrl();
		double latValue = Double.parseDouble(getCoordinatesURL.substring(getCoordinatesURL.indexOf('@')+1, getCoordinatesURL.lastIndexOf('/')).split(",")[0]);
		double longValue = Double.parseDouble(getCoordinatesURL.substring(getCoordinatesURL.indexOf('@')+1, getCoordinatesURL.lastIndexOf('/')).split(",")[1]);
		map.put("latitude", latValue);
		map.put("longitude", longValue);
		return map;
	}
	
//	public Double getCoordinatesValue(Map<String, Double> m, String keyname){
//		Double coordinateValue = 0.0;
//		for (Map.Entry<String, Double> mEntry :  m.entrySet()) {
//			if (mEntry.getKey().contains(keyname)) {
//				coordinateValue = mEntry.getValue();
//			}
//		}
//		return coordinateValue;
//	}


	
}
