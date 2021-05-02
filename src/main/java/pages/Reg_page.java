package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Reg_page extends PageBase {

	public Reg_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(name = "firstname")
	WebElement Firstname_txtbox;

	@FindBy(name = "lastname")
	WebElement LastName_txtbox;

	@FindBy(name = "phone")
	WebElement MobNum_txtbox;

	@FindBy(name = "email")
	WebElement EmailAdd_txtbox;

	@FindBy(name = "password")
	WebElement Pass_txtbox;

	@FindBy(name = "confirmpassword")
	WebElement ConfirmPass_txtbox;

	@FindBy(css = ".signupbtn")
	WebElement Signup_btn;

	@FindBy(css=".alert > p")
	public WebElement validationMSG;

	public void EnterRegisteration_INFO(String Fname,String Lname,String MobNum
			,String Mail,String Pass,String ConfPass)
	{

		SetText(Firstname_txtbox,Fname);
		SetText(LastName_txtbox,Lname);
		SetText(MobNum_txtbox,MobNum);
		SetText(EmailAdd_txtbox,Mail);
		SetText(Pass_txtbox,Pass);
		SetText(ConfirmPass_txtbox,ConfPass);

	}

	public void ClearRegisteration_INFO()
	{

		clearText(Firstname_txtbox);
		clearText(LastName_txtbox);
		clearText(MobNum_txtbox);
		clearText(EmailAdd_txtbox);
		clearText(Pass_txtbox);
		clearText(ConfirmPass_txtbox);

	}

	public void ClickSignup()
	{

		click_button(Signup_btn);
	}

	public boolean isValid(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	public static boolean checkAlphabet(String name) {
		char[] ch = name.toCharArray();
		for (char c : ch) {
			if(!Character.isLetter(c)) {
				return false;
			}
		}
		return true;
	}


}
