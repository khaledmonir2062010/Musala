package utilities;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	
	
	public static void captureScreenshots(WebDriver driver, String Screenshotname)
	{
		
		Path dest=Paths.get("/Screenshots",Screenshotname+".png");
		try {
			
			
			Files.createDirectories(dest.getParent());
			FileOutputStream out=new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			
		} catch (Exception e) {
			
			
			System.out.println("Exception while taking screenshot"+e.getMessage());
				}
	}

}
