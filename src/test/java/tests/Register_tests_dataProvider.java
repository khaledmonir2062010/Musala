package tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import pages.Reg_page;

public class Register_tests_dataProvider extends TestBase{
	
	
	Reg_page RegObj;

	
	@DataProvider(name="testData")
	public static Object[][] userData()
	{
		return new Object[][] {
			{"AutomationFirstName" , "AutomationLastName","+201006547638","AutoTest@gmail.com","Test@1234","Test@1234"},
			{"AutomationFirstName" , "AutomationLastName","+201006547638","AutoTest@gmail.com","Test@1234","Test@1234"}};
	}
	@Test(dataProvider = "testData")
	public void UserCanRegister(String f_name,String l_name,String mob_num, String mail_Add,String pass,String Conpass) throws CsvValidationException, IOException
	{	
		
		RegObj=new Reg_page(driver);
		RegObj.EnterRegisteration_INFO(f_name, l_name, mob_num, mail_Add, pass, Conpass);
		
		
		
	}

}
