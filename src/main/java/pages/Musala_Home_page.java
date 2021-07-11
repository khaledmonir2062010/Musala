package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Musala_Home_page extends PageBase{

	public Musala_Home_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Elements for Contact us
	@FindBy (css=".contact-label")
	WebElement Contactus_btn;

	@FindBy(name = "your-name")
	WebElement name;

	@FindBy(name="your-email")
	WebElement Email;

	@FindBy(name="mobile-number")
	WebElement MobileNum;

	@FindBy(name="your-subject")
	WebElement subjectbox;

	@FindBy(name="your-message")
	WebElement Messagebox;

	@FindBy(css=".wpcf7-submit")
	public WebElement Sendbtn;

	@FindBy(css=".your-email > .wpcf7-not-valid-tip")
	public WebElement emailVali_msg;

	@FindBy(css=".wpcf7-response-output")
	public WebElement Sendvali_msg;


	//Fill Form for Contact us
	public void fill_contactus(String nam, String mail, String mobnum, String Subject, String msg)
	{
		click_button(Contactus_btn);
		clearText(name);
		SetText(name, nam);
		clearText(Email);
		SetText(Email, mail);
		clearText(MobileNum);
		SetText(MobileNum, mobnum);
		clearText(subjectbox);
		SetText(subjectbox, Subject);
		clearText(Messagebox);
		SetText(Messagebox, msg);
	}
	
	public void Submit() {
		click_button(Sendbtn);
	}

	////********----------------------------------------------------------------********///////

	//Company Link
	@FindBy (xpath = "(//a[contains(@href, 'https://www.musala.com/company/')])[5]")
	WebElement Company_link;

	//Careers Link
	@FindBy (xpath  = "(//a[contains(@href, 'https://www.musala.com/careers/')])[6]")
	WebElement Careers_link;

	public void ClickCompanyLINK() {
		// TODO Auto-generated method stub
		click_button(Company_link);
	}
	
	public void ClickCareerLInk() {
		click_button(Careers_link);
	}



}
