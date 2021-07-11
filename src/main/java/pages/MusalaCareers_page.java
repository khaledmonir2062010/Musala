package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MusalaCareers_page extends PageBase {

	public MusalaCareers_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".contact-label > span")
	WebElement OpenPostions_btn;
	
	@FindBy (id = "get_location")
	WebElement Location_DropDown;
	
	@FindBy(xpath = "//div[@id='content']/section/div[2]/article[8]/div/a/div/div[2]/img")
	public WebElement QA_AUTOMATION_postion;
	
	@FindBy(xpath ="//h2[contains(.,'General description')]")
	public WebElement general_DescriptionTXT;
	
	@FindBy(xpath = "//h2[contains(.,'Requirements')]")
	public WebElement RequirementsTXT;
	
	@FindBy(xpath = "//h2[contains(.,'Responsibilities')]")
	public WebElement ResponsibilitiesTXT;
	
	@FindBy(xpath = "//h2[contains(.,'What we offer')]")
	public WebElement WhatWeOfferTXT;
	
	///////////////////**********************------------------------------------------********************////////////
	///////////////////**********************-------------------Apply Now----------------------********************////////////
	@FindBy(css = ".btn-join-us" )
	WebElement Applynow;
	
	@FindBy(id = "cf-1")
	WebElement name_field;
	
	@FindBy(id = "cf-2")
	WebElement email_field;
	
	@FindBy(id = "cf-3")
	WebElement MobileNum_field;
	
	@FindBy(id = "uploadtextfield")
	WebElement Upload;
	
	@FindBy(css = ".btn-cf-submit")
	WebElement send_btn;
	
	
	public void OpenPostions()
	{
		
		click_button(OpenPostions_btn);
	}
	
	public void Selectvacancy(String LoactionName)
	{
		
		Select selectoptions=new Select(Location_DropDown);
		selectoptions.selectByVisibleText(LoactionName);
			
	}
	
	public void selectPostion()
	{
	
		//JavascriptExecutor jse=(JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].click()",QA_AUTOMATION_postion);
		
		click_button(QA_AUTOMATION_postion);
	}
	
	public void Apply() {
		
		
		click_button(Applynow);
	}
	
	public void fillPostionINFO(String Name, String mail, String MobNum,String UploadFile)
	{
		clearText(name_field);
		SetText(name_field, Name);
		clearText(email_field);
		SetText(email_field, mail);
		clearText(MobileNum_field);
		SetText(MobileNum_field,MobNum);
		SetText(Upload, UploadFile);
		//click_button(send_btn);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(send_btn)).click();
		
	}

}
