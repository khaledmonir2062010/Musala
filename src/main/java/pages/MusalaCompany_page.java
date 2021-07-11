package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MusalaCompany_page extends PageBase{

	public MusalaCompany_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".cm-content > h2")
	public WebElement LeadershipText;
	
	@FindBy(xpath = "//div[@id='u_0_d_rB']/div/div/div/a/div")
	public WebElement FBprofilepic;
	
	//Social Media elements
	//Facebook link
	@FindBy (css=".musala-icon-facebook")
	WebElement FacebookLINK;
	
	public void OpenFacebook()
	{
		click_button(FacebookLINK);
	}
	
	

}
