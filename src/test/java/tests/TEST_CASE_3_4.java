package tests;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.MusalaCareers_page;
import pages.Musala_Home_page;

public class TEST_CASE_3_4 extends TestBase {


	Musala_Home_page HomePag;
	MusalaCareers_page careerPag;

	JavascriptExecutor jse;
	CSVReader reader;

	String[] csvCell ; 
	String Test;
	
	String Title="https://www.musala.com/careers/join-us/"; 

	@Test
	public void TC3() throws CsvValidationException, IOException, InterruptedException
	{

		String Header1= "General description";
		String Header2= "Requirements";
		String Header3= "Responsibilities";
		String Header4= "What we offer";
		String DocName= "DocUpload.docx";
		String DocPath =System.getProperty("user.dir")+"/Uploads/"+DocName;


		HomePag    = new Musala_Home_page(driver);
		careerPag = new MusalaCareers_page(driver);

		//Steps
		HomePag.ClickCareerLInk();
		careerPag.OpenPostions();
		Assert.assertEquals(driver.getCurrentUrl(), Title);
		careerPag.Selectvacancy("Anywhere");
		if(careerPag.QA_AUTOMATION_postion.isDisplayed())
		{

			careerPag.selectPostion();
		}
		Assert.assertTrue(careerPag.general_DescriptionTXT.getText().contains(Header1));
		Assert.assertTrue(careerPag.RequirementsTXT.getText().contains(Header2));
		Assert.assertTrue(careerPag.ResponsibilitiesTXT.getText().contains(Header3));
		Assert.assertTrue(careerPag.WhatWeOfferTXT.getText().contains(Header4));

		//Apply in the job vacancy
		careerPag.Apply();
		// get path of CSV file 
		String CSV_file = System.getProperty("user.dir")+"\\src\\test\\java\\data\\TestData - ApplyForm.csv";
		reader = new CSVReader(new FileReader(CSV_file)); 
		String[] csvCell ; 

		// while loop will be executed till the last value in CSV file . 
		while((csvCell = reader.readNext()) != null) 
		{

			jse = (JavascriptExecutor) driver;

			String Name1 = csvCell[0]; 
			String E_mail = csvCell[1]; 
			String Mobilenum = csvCell[2]; 
			careerPag.fillPostionINFO(Name1, E_mail, Mobilenum,DocPath);
		}
	}


	@Test
	public void TC4()
	{
		HomePag    = new Musala_Home_page(driver);
		careerPag = new MusalaCareers_page(driver);

		//Steps
		HomePag.ClickCareerLInk();
		careerPag.OpenPostions();
		Assert.assertEquals(driver.getCurrentUrl(), Title);
		careerPag.Selectvacancy("Sofia");
		//get all vacancies displayed on page
		List<WebElement> vacancies=driver.findElements(By.tagName("a"));
		
		System.out.println(vacancies.size());
		for (WebElement vacancy : vacancies) {
			System.out.println("More info: "+vacancy.getAttribute("href"));
			System.out.println(vacancy.getAttribute("p"));
			System.out.println(vacancy.getAttribute("h2"));
		}
		
	}


}
