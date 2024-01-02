package com.TestCases;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.BaseTest.TestBase;
import com.Pages.ContactUSPage;
import com.Pages.MainPage;
import com.Utils.TestUtil;

public class TestCases extends TestBase {
	
	MainPage mainPage;
	ContactUSPage contactUSPage;
	static Logger log = Logger.getLogger(TestCases.class);
	
	public TestCases() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {

		initialization();
	}

	@Test(priority = 1)
	public void verifyMenuLableAccesebility() {
		List<WebElement> menuList = driver.findElements(By.xpath("//nav[@id='main-navigation-new']/ul/li"));
		for (WebElement webelement : menuList) {
			assertTrue(webelement.isDisplayed(), webelement.getText() + " webElement is not accessible.");
			log.info("item is accessible: " + webelement.getText());
		}
	}
	
	@Test(priority = 2)
	public void verifyRequestDemoButton() {
		
		List<String> items =  new ArrayList<String>();
		items.add("Our Story");
		items.add("Our Solution");
		items.add("Why Tendable?");
		
		log.info("Iterating through pages");
		
		for (String item : items) {
			clickOnMenu(item);
			mainPage.assertRequestDemoButtonPresence();
			driver.navigate().back();
		}

	}
	
	@Test(priority = 3)
	public void testContactUsFormError() throws InterruptedException {

		log.info("Click on Contact Us btn");
		mainPage.clickOnContactUs();

		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout

		log.info("Click on Marketing Btn");
		contactUSPage.clickonMarketing();

		log.info("Updating the form without Message Field");
		contactUSPage.fillFormWithoutMessage("ABCD", "POPO", "9876543210", "abc@xyz.com", "CNO");

		log.info("verify the error message");
		contactUSPage.verifyErrorMessage();
	}
	
	
	public void clickOnMenu(String item) {
		List<WebElement> menu = driver.findElements(By.xpath("//nav[@id='main-navigation-new']/ul/li"));
		for (WebElement menuItem : menu) {
			if (menuItem.getText().equals(item)) {
				menuItem.click();
			}
		}
		throw new NoSuchElementException("Menu item not found: " + item);
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
