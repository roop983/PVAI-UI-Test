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
	
	HomeValues homeValue;
	TestUtil testUtil;
	
	public HomeValuesTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		homeValue=new HomeValues();
		testUtil = new TestUtil();
	}
	
	
	
	
	@Test(priority=1)  // Add User Test
	public void homeRealEstateTest() {
		try {
			homeValue.enterZipCode(prop.getProperty("zipcode"));
			int countrealEstateInfoTypes = homeValue.validateRealEstateTypes();
			Assert.assertEquals(countrealEstateInfoTypes, testUtil.realEstateExpectedInfoList.length);
			homeValue.selectEstateInfoType();
		
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
