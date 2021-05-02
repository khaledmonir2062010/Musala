package tests;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.Home_page;
import pages.Reg_page;

public class Register_tests extends TestBase{


	Reg_page RegObj;
	Home_page HomeObj;

	CSVReader reader;

	String[] csvCell ; 
	String Test;

	

	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() throws CsvValidationException, IOException {



		String CSV_file = System.getProperty("user.dir")+"/src/test/java/data/TestData - Successfull_reg.csv";
		reader = new CSVReader(new FileReader(CSV_file)); 

		String[] csvCell ; 

		// while loop will be executed till the last value in CSV file . 
		while((csvCell = reader.readNext()) != null) 
		{
			String firstname = csvCell[0]; 
			String lastName = csvCell[1]; 
			String Mobilenum = csvCell[2]; 
			String Emailadd = csvCell[3];
			String password = csvCell[4]; 
			String Confpassword = csvCell[5];

			RegObj = new Reg_page(driver);
			RegObj.EnterRegisteration_INFO(firstname, lastName, Mobilenum,
					Emailadd, password, Confpassword);
			driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
			RegObj.ClickSignup();
			
			//Steps in the HomePage
			WebDriverWait wait=new WebDriverWait(driver, 20);
			//wait.until(HomeObj.AccountDropMenu.isDisplayed());
			wait.until(ExpectedConditions.titleContains("My Account"));
			HomeObj=new Home_page(driver);
			if(HomeObj.AccountDropMenu.isDisplayed()) {
				
				HomeObj.Logout();
			}

		}
	}

	
	@Test(priority = 2)
	public void UserCanRegister() throws CsvValidationException, IOException
	{	

		String CSV_file = System.getProperty("user.dir")+"/src/test/java/data/TestData - Sheet1.csv";
		reader = new CSVReader(new FileReader(CSV_file)); 

		String[] csvCell ; 

		// while loop will be executed till the last value in CSV file . 
		while((csvCell = reader.readNext()) != null) 
		{
			boolean check ;
			String firstname = csvCell[0]; 
			String lastName = csvCell[1]; 
			String Mobilenum = csvCell[2]; 
			String Emailadd = csvCell[3];
			String password = csvCell[4]; 
			String Confpassword = csvCell[5];

			RegObj = new Reg_page(driver);
			RegObj.EnterRegisteration_INFO(firstname, lastName, Mobilenum,
					Emailadd, password, Confpassword);
			driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

			check=RegObj.isValid(Emailadd);
			if (check==false) {

				Test="The Email field must contain a valid email address.";
			}else if (password!=Confpassword) {


				Test="Password not matching with confirm password.";

			}else if(Reg_page.checkAlphabet(Mobilenum)){

				Test="Mobile Number Field should accept numeric only.";
				System.out.println("failednum");

			}
			RegObj.ClickSignup();
			driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
			String Actual=RegObj.validationMSG.getText();
			Assert.assertEquals(Actual, Test);
			driver.navigate().refresh();
			System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.phptravels.net/register/en");

		}

	}

}
