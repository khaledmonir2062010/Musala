package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

import java.util.concurrent.TimeUnit;

public class TestBase {
	
	
	String ChromePath=System.getProperty("user.dir")+"/Drivers/chromedriver";
	String FirefoxPath=System.getProperty("user.dir")+"/Drivers/geckodriver";
	String os=System.getProperty("os.name").toLowerCase();
	
	public static WebDriver driver;
	@BeforeSuite(groups = "regression")
	@Parameters({"browser"})
	public void StartDriver(@Optional("chrome") String browserName)
	{

        if (browserName.equalsIgnoreCase("chrome")) {
        	System.setProperty("webdriver.chrome.driver", ChromePath);
            driver = new ChromeDriver();
        }
        
     

        else if(browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", FirefoxPath);
            driver = new FirefoxDriver();
        }

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String dashboardURL = "https://www.phptravels.net/register/en";
		driver.navigate().to(dashboardURL);
		driver.manage().window().maximize();
	}
	
	@AfterSuite(groups = "regression")
	public void CloseDriver()
	{
		//driver.quit();
	}
	
	public void ScreenshotonFailure(ITestResult results)
	{
		
		if (results.getStatus()==ITestResult.FAILURE)
		{
			
			System.out.println("Failed");
			System.out.println("Taking Screenshot.............");
			Helper.captureScreenshots(driver, results.getName());

		}



	}
}