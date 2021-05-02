package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_page extends PageBase{

	public Home_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = ".dropdown-login > #dropdownCurrency")
	public WebElement AccountDropMenu;
	
	@FindBy(linkText = "Logout")
	WebElement Logout_link;
	
	public void Logout()
	{
		click_button(AccountDropMenu);
		click_button(Logout_link);
	}
}
