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


public class MapSearchTest extends TestBase{
	
	HomeValues searchLocation;
	TestUtil testUtil;
	String sheetName = "CoordinateDetails";
	
	public MapSearchTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		searchLocation=new HomeValues();
		testUtil = new TestUtil();
	}
	
	@DataProvider
	public Object[][] getTestData() throws InvalidFormatException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
//	@Test(priority=1, dataProvider="getTestData")  // Add User Test
//	public void coordinatesTest(String keyname, String latitude, String longitude) throws InterruptedException {
//		searchLocation.searchPlace(keyname);
//		//Thread.sleep(15000);
//		System.out.println(keyname+" "+latitude+" "+longitude);
//		Map<String, Double> map = new HashMap<String, Double>();
//		String getCoordinatesURL = driver.getCurrentUrl();
//		System.out.println(getCoordinatesURL);
//		
//		//String getCoordinatesURL1 = "https://www.google.com/maps/dir//99+Ranch+Market,+34444+Fremont+Blvd,+Fremont,+CA+94555/@37.5753502,-122.0413917,17z/data=!4m8!4m7!1m0!1m5!1m1!1s0x808fbe2cdf5d8085:0x252ee7d71ed7bc79!2m2!1d-122.039203!2d37.575346";
//		
//		double latValue = Double.parseDouble(getCoordinatesURL.substring(getCoordinatesURL.indexOf('@')+1, getCoordinatesURL.lastIndexOf('/')).split(",")[0]);
//		double longValue = Double.parseDouble(getCoordinatesURL.substring(getCoordinatesURL.indexOf('@')+1, getCoordinatesURL.lastIndexOf('/')).split(",")[1]);
//		System.out.println(latValue);
//		System.out.println(longValue);
//		map.put("latitude", latValue);
//		map.put("longitude", longValue);
//		//Double latitudeValue = searchLocation.getCoordinatesValue(map, keyname);
//		double latitudeValue = map.get("latitude");
//		double longitudeValue = map.get("longitude");
//		Assert.assertEquals(latitudeValue, Double.parseDouble(latitude), "the latitude coordinates doesnt match");
//		Assert.assertEquals(longitudeValue, Double.parseDouble(longitude), "the longitude coordinates doesnt match");
//		
//		
//	}
	
	
	@Test(priority=1, dataProvider="getTestData")  // Add User Test
	public void coordinatesTest(String keyname, String latitude, String longitude) {
		try {
		searchLocation.searchPlace(keyname);
		Map<String, Double> map = searchLocation.extractCoordinates(keyname);
		double latitudeValue = map.get("latitude");
		double longitudeValue = map.get("longitude");
		Assert.assertEquals(latitudeValue, Double.parseDouble(latitude), "the latitude coordinates doesnt match");
		Assert.assertEquals(longitudeValue, Double.parseDouble(longitude), "the longitude coordinates doesnt match");
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		
	}
	
	
//	@Test(priority=1, dataProvider="getTestData")  // Add User Test
//	public void coordinatesTest(String keyname, String latitude, String longitude)  {
//		searchLocation.searchPlace(keyname);
//		List<SearchLocation> list = new ArrayList<SearchLocation>();
//		list = searchLocation.extractCoordinatesList(keyname);
//		System.out.println(keyname+" "+latitude+" "+longitude);
//		try{
//			Iterator<SearchLocation> it=list.iterator();
//			while (it.hasNext()) {
//				SearchLocation search=it.next();
//				
//				Assert.assertEquals(search.getLatitude(), Double.parseDouble(latitude), "the latitude coordinates doesnt match");
//				Assert.assertEquals(search.getLongitude(), Double.parseDouble(longitude), "the longitude coordinates doesnt match");
//			}
//		}
//		catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.getStackTrace());
//		}
//		
//	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}