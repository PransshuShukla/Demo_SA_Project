package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BaseTest.TestBase;

public class ContactUSPage extends TestBase {
	
	@FindBy(xpath = "//body/div[@class='w-full max-w-10xl mx-auto']/div[@class='flex']/div[@class='w-full px-2.5 md:px-5 xl:px-10']/div[@class='-mx-2.5 md:-mx-5 xl:-mx-10']/div[@class='flex flex-wrap w-full mb-20 xl:mb-28']/div[@class='flex flex-wrap items-center w-full mx-2.5 md:mx-5 xl:mx-8 px-2.5 md:px-5 xl:px-10']/div[1]")
	WebElement marketingLink;
	
	@FindBy(id = "form-input-fullName")
	WebElement name;
	
	@FindBy(id = "form-input-organisationName")
	WebElement orgName;
	
	@FindBy(id = "form-input-cellPhone")
	WebElement cell;
	
	@FindBy(id = "form-input-email")
	WebElement email;
	
	@FindBy(id = "form-input-jobRole")
	WebElement jobRoleDropDown;
	
	@FindBy(xpath = "//form[@id='contactMarketingPipedrive-163701']//input[@id='form-input-consentAgreed-0']")
	WebElement iAgreeCheckbox;
	
	@FindBy(xpath = "//button[@data-loading-text='Loading...'][normalize-space()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//p[contains(text(),'Sorry, there was an error submitting the form. Ple')]")
	WebElement errorMsg;
	
	
	public ContactUSPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickonMarketing()
	{
		marketingLink.click();
	}
	
	public void fillFormWithoutMessage(String fname, String org,String phone,String mail, String dropdownText) 
	{
		name.sendKeys(fname);
		orgName.sendKeys(org);
		cell.sendKeys(phone);
		email.sendKeys(mail);
		
		Select select=new Select(jobRoleDropDown);
		select.selectByVisibleText(dropdownText);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		iAgreeCheckbox.click();
		
		submitBtn.click();	
	}
	
	public void verifyErrorMessage()
	{
		
		Assert.assertNotNull(errorMsg, "Error message not displayed.");
	}
}
