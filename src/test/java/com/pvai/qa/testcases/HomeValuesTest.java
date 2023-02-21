package com.pvai.qa.testcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pvai.qa.base.TestBase;
import com.pvai.qa.repository.HomeValues;
import com.pvai.qa.util.TestUtil;


public class HomeValuesTest extends TestBase{
	
	//Declare objects of repository and test util classes to be used later in the current class
	HomeValues homeValue;
	TestUtil testUtil;
	
	public HomeValuesTest(){
		super();
	}
	
	//Invoke Parent class initialize method for driver setup and initialize objects of the required classes to access their methods
	@BeforeClass
	public void setUp() {
		initialization();
		homeValue=new HomeValues();
		testUtil = new TestUtil();
	}
	
	
	//Search with zip code and select Real Estate Type
	@Test(priority=1)  
	public void homeRealEstateTest() {
		try {
			homeValue.enterZipCode(prop.getProperty("zipcode"));
			
			//Count all the Real Estate Info Type and assert with expected count
			int countrealEstateInfoTypes = homeValue.validateRealEstateTypes();
			Assert.assertEquals(countrealEstateInfoTypes, testUtil.realEstateExpectedInfoList.length);
			
			//Select Real Estate Info Type
			homeValue.selectEstateInfoType();	
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		
	}
	
	@Test(priority=2)  
	public void searchHomeValuesFormTest() {
		try {
			//Verify for the Search Home Values Title
			String expectedAddress = prop.getProperty("address");
			String expectedCityState = expectedAddress.substring(expectedAddress.indexOf(',')+2, expectedAddress.lastIndexOf(','));
			String homeValuesFormTitle = homeValue.getHomeValuesFormTitle();
			Assert.assertEquals(homeValuesFormTitle, prop.getProperty("searchHomeValueFormTitle").concat(expectedCityState));
			
			//Enter Reason for Home Valuation and enter Street Address
			homeValue.enterHomeValuationReasonAndAddress();
			
			//Assert on the value displayed for City and State
			Assert.assertEquals(homeValue.getCityState(), expectedCityState);
			
			//Assert that Change Location is enabled
			Assert.assertTrue(homeValue.verifyChangeLocation(), "Change Location is not enabled");
			
			//Select Bedrooms, Bathrooms, Type of Property, Planning to Sell, Minumum home worth from dropdowns with this method
			homeValue.selectHomeValuesDrpDwn();
			
			//Enter details about person filling up form
			homeValue.enterSelfDetails();
			
			//Select checkboxes
			homeValue.checkOffersSelection();
			
			//Verify Continue Button is enabled and then click on it
			Assert.assertTrue(homeValue.verifyContinueSearchHomeValuesBtn(), "Continue Button is not enabled");
			homeValue.clickContinueSearchHomeValuesBtn();
			
			//Validate for the response after the form submission
			Assert.assertEquals(homeValue.getConfirmationText(), prop.getProperty("confirmationText"));
			Assert.assertEquals(homeValue.getThankYouMsgText(), prop.getProperty("thankYouMsgText"));
			
			//Check the continue button is enabled
			Assert.assertTrue(homeValue.verifyContinueReadingBtn(), "Continue Reading Button is not enabled");
			
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		
	}
	

	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
