package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class PageBase {

	protected WebDriver driver ; 
	public JavascriptExecutor jse ; 
	public Select select ; 
	public Actions action ; 


	public PageBase(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	protected static void click_button(WebElement button)
	{
		button.click();
	}

	protected String getText(WebElement element) { return element.getText(); }

	public String getAttribute(WebElement element) { return element.getAttribute("value"); }

	
	//Method for set text
	protected static void SetText(WebElement textElement, String value)
	{
		textElement.sendKeys(value);
	}

	//Method for clear Text
	public void clearText(WebElement element) 
	{
		element.clear();
	}

	
	//Method for scrolling down
	public void scrollToBottom() 

	{
		jse.executeScript("scrollBy(0,2500)"); 
	}



}
