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
import com.pvai.qa.util.TestUtil;


public class HomeValues extends TestBase{
	
	//Enter Zip code
	
	@FindBy(xpath="//div/input[@id='rewLocation']//preceding-sibling::h3")
	WebElement connectEstateAgents;
	
	@FindBy(xpath="//div/input[@id='rewLocation'][@placeholder='Zip Code']")
	WebElement inputZipCode;
	
	@FindBy(xpath="//div[input[@id='rewLocation']]/button[@class='goBtn rewGetQuoteGo']")
	WebElement goButton;
	
	//Real Estate Info Types Form
	
	@FindBy(xpath="//div[@class='proCard Step']/h3")
	WebElement typeRealEstateInfo;
	
	@FindBy(xpath="//ul[@id='rewCategoryOptionBinder']/li/label")
	List<WebElement> realEstateInfoTypeslist;
	
	@FindBy(xpath="//ul[@id='rewCategoryOptionBinder']/descendant::label[text()='Home Values']//preceding-sibling::input")
	WebElement homeValuesRadio;
	
	@FindBy(xpath="//div[@class='proCard Step']/button[text()='Continue']")
	WebElement continueBtnAfterEstInfo;
	
	//Search Home Values Form
	
	@FindBy(xpath="//div[@class='userInfo Step']/h5")
	WebElement searchHomeValuesText;
	
	@FindBy(xpath="//select[@class='homeVal allSelect']")
	WebElement homeValuationReasonDropDwn;
	
	@FindBy(xpath="//div[@id='rewServiceProjectQuestions']/input[@placeholder='Address']")
	WebElement streetAddressProperty;
	
	@FindBy(xpath="//div[@id='rewServiceProjectQuestions']/div/span[@class='locationText rewLocationCopy2']")
	WebElement cityState;
	
	@FindBy(xpath="//div[@id='rewServiceProjectQuestions']/div/span[@class='changeLocation editLoc']")
	WebElement changeLocationText;
	
	@FindBy(xpath="//select[@class='bedrooms allSelect'][@name='Bedrooms']")
	WebElement bedroomsSelect;
	
	@FindBy(xpath="//select[@class='bathrooms allSelect'][@name='Bathrooms']")
	WebElement bathroomsSelect;
	
	@FindBy(xpath="//select[@name='PropertyType']")
	WebElement propertyTypeSelect;
	
	@FindBy(xpath="//select[@name='TimeFrame']")
	WebElement sellPropertyTimeSelect;
	
	@FindBy(xpath="//select[@name='PriceRange']")
	WebElement minimumPriceRangeSelect;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='PhoneNumber'][@placeholder='Phone']")
	WebElement phoneNumber;
	
	@FindBy(xpath="//input[@name='OffersCheckBox']")
	WebElement offersChkbox;
	
	@FindBy(xpath="//input[@name='RequestMortgageInfo']")
	WebElement refinanceOffersChkbox;
	
	@FindBy(xpath="//button[@class='goBtn rewGetQuoteContact'][text()='Continue']")
	WebElement continueSearchHomeValuesBtn;
	
	@FindBy(xpath="//div[@class='thankCard Step']/header/h3")
	WebElement confirmationText;
	
	@FindBy(xpath="//div[@class='thankCard Step']/section/p")
	WebElement thankYouMsgText;
	
	//validate
	@FindBy(xpath="//button[@class='goBtn rewGetQuoteDone'][text()='Continue Reading']")
	WebElement continueReadingBtn;
	
	
	
	
	
	
	
	
	
	
	
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
	
	
	public void enterZipCode(String searchValue) {
		inputZipCode.sendKeys(searchValue);
		goButton.click();
	}
	
	public int validateRealEstateTypes() {
		wait.until(ExpectedConditions.elementToBeClickable(homeValuesRadio));
		int countrealEstateInfoTypes = 0;
		for(WebElement el:realEstateInfoTypeslist) {
			for (String s: TestUtil.realEstateExpectedInfoList) {
				if (s.equals(el.getText())) {
					countrealEstateInfoTypes++;
				}
			}
		}
		return countrealEstateInfoTypes;
	}
	
	public void selectEstateInfoType() {
		homeValuesRadio.click();
		continueBtnAfterEstInfo.click();
	}
	
	
	
}
