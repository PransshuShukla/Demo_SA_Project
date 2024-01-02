package com.Pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.BaseTest.TestBase;

public class MainPage extends TestBase {
	
	@FindBy(xpath = "//nav[@id='main-navigation-new']/ul/li")
	WebElement menuList;
	
	@FindBy(linkText = "Request a Demo")
	WebElement requestDemoButton;
	
	@FindBy(linkText = "Contact Us")
	WebElement contactUsBtn;
	
	public MainPage() {
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> menuItemLits()
	{
		List<WebElement> menuList = driver.findElements(By.xpath("//nav[@id='main-navigation-new']/ul/li"));
		return menuList;
		
	}
	
	public void assertRequestDemoButtonPresence() {
		Assert.assertTrue(requestDemoButton.isDisplayed() && requestDemoButton.isEnabled(),
				"Request a Demo button is not present or active.");
	}
	
	public void clickOnContactUs()
	{
		contactUsBtn.click();		
	}

}
