package tests;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.Musala_Home_page;

public class TEST_CASE_1 extends TestBase{
	
	Musala_Home_page HomePag;
	JavascriptExecutor jse;
	
	CSVReader reader;

	String[] csvCell ; 
	String Test;
	
	@Test
	public void FillContactus_INFO() throws CsvValidationException, IOException, InterruptedException
	{
		
		// get path of CSV file 
		String CSV_file = System.getProperty("user.dir")+"\\src\\test\\java\\data\\TestData - Sheet1.csv";
		reader = new CSVReader(new FileReader(CSV_file)); 
		String[] csvCell ; 
		
		// while loop will be executed till the last value in CSV file . 
		while((csvCell = reader.readNext()) != null) 
		{
			
			jse = (JavascriptExecutor) driver;
			
			String Name1 = csvCell[0]; 
			String E_mail = csvCell[1]; 
			String Mobilenum = csvCell[2]; 
			String subj = csvCell[3];
			String messageboxx = csvCell[4]; 
			
			
			HomePag = new Musala_Home_page(driver);
			jse.executeScript("window.scrollTo(0,894)");
			jse.executeScript("window.scrollTo(0,1860.6666259765625)");
			jse.executeScript("window.scrollTo(0,2047.3333740234375)");
			HomePag.fill_contactus(Name1,E_mail,Mobilenum,subj,messageboxx);
			if (HomePag.Sendbtn.isDisplayed())
			{
				HomePag.Submit();
			}
			Assert.assertTrue(HomePag.emailVali_msg.getText().contains("The e-mail address entered is invalid."));
		}
		
	}

}
