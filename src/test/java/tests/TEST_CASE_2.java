package tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MusalaCompany_page;
import pages.Musala_Home_page;

public class TEST_CASE_2 extends TestBase{

	Musala_Home_page HomePag;
	MusalaCompany_page CompanyPag;
	JavascriptExecutor jse;



	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void Tc2()
	{
		String Title="https://www.musala.com/company/"; 

		HomePag    = new Musala_Home_page(driver);
		CompanyPag =new MusalaCompany_page(driver);
		
		
		
		//Steps
		HomePag.ClickCompanyLINK();
		Assert.assertEquals(driver.getCurrentUrl(),Title);
		Assert.assertTrue(CompanyPag.LeadershipText.getText().contains("Leadership"));
		
		
		String currentWINDOWID=driver.getWindowHandle();
		CompanyPag.OpenFacebook();
		for (String windowID: driver.getWindowHandles())
		{
			String title=driver.switchTo().window(windowID).getTitle();
			if (title.equals(driver.getTitle().contains("Musala Soft - ")))
			{
				assertEquals(driver.getTitle().contains("Musala Soft - "), driver.getTitle());
				
				List<WebElement> element = driver.findElements(By.cssSelector(".\\_6tay"));
				assert(element.size() > 0);
						
				driver.close();
				break;
			}
			driver.switchTo().window(currentWINDOWID);
		}
	}
	

}
