package com.pvai.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	

	public static long PAGE_LOAD_TIMEOUT = 25;
	public static long IMPLICIT_WAIT = 20;
	public static String[] realEstateExpectedInfoList = {"Listings of Homes for Sale", "Foreclosure Listings", "Home Values", "New Home Construction"};
	public static String[] homeValuationReasonList = 
		{
				"Please select",
				"Curious about the value of my home",
				"Curious about the value of a home in the area",
				"Selling a home",
				"Considering the sale of a home",
				"Buying a home",
				"Considering buying a home",
				"Refinancing a home",
				"Other Reason"
		};
	
}
