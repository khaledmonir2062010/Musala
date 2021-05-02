package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.LoadProperties;
import java.net.MalformedURLException;
import java.net.URL;

public class Testbase_browserStack {
	
	
	//BROWSERSTACK CONFIGURATION
		public static final String USERNAME = LoadProperties.Browserstacks_data.getProperty("username");
		public static final String ACCESS_KEY = LoadProperties.Browserstacks_data.getProperty("ACCESSKEY");
		public static final String BrowserStackURl="https://"+USERNAME+":"+ACCESS_KEY+LoadProperties.Browserstacks_data.getProperty("URL");

		public static String BaseURL = "https://demo.nopcommerce.com";


		protected ThreadLocal<RemoteWebDriver> driver = null;

		//public static String URL="https://"+USERNAME+":"+ACCESSKEY+"@hub.browserstack.com/wd/hub";
		@BeforeClass
		@Parameters(value= {"browser","browser_version","os","os_version","resolution"})
		public void openSTM(@Optional("firefox") String Browser, String Browser_Version, String OS, String OS_VERSION, String Resolution) throws MalformedURLException
		{

			driver = new ThreadLocal<RemoteWebDriver>();
			DesiredCapabilities cap=new DesiredCapabilities();
			//cap.setBrowserName(Browser);
			cap.setCapability("browser", Browser);
			cap.setCapability("browser_version", Browser_Version);
			cap.setCapability("os", OS);
			cap.setCapability("os_version", OS_VERSION);
			cap.setCapability("resolution", Resolution);
			cap.setCapability("browserstack.debug", true);
			cap.setCapability("browserstack.networkLogs", true);
			
			

			//Run on Cloud (Browser Stack)

			driver.set(new RemoteWebDriver(new URL(BrowserStackURl),cap));
			getDriver().navigate().to(BaseURL);
			getDriver().manage().window().maximize();


		}
		
		public WebDriver getDriver() {

			return driver.get();
		}

		@AfterClass
		public void stropDriver()
		{


			getDriver().quit();
			driver.remove();
		}


}
