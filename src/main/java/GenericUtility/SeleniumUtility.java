package GenericUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility {
	public WebDriver driver;
	
	// Launch browser based on Properties file value
	public WebDriver launchBrowser (String BROWSER)
	{
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Brwser name in the PropertiesFIle");
			return null;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
		
	}
	
	public void closeBrowser()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
	// Dropdown select by Visible Text
	public void selectByVisibleText(WebElement element , String text )
	{
		Select s= new Select(element);
		s.selectByVisibleText(text);
				
	}
	// Dropdown select by Index
	public void SelectByIndex(WebElement element , int index)
	{
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	// Dropdown select by value
	 public void SelectByValue(WebElement element , String value)
	 {
		 Select s= new Select(element);
		 s.selectByValue(value);
	 }
	 
	// Actions → click
	 public void actionClick(WebElement element)
	 {
		 Actions a= new Actions(driver);
		 a.moveToElement(element).click().perform();
	 }
	 
	 //Actions → mouseHover
	 public void mouseHover(WebElement element)
	 {
		 Actions a= new Actions(driver);
		 a.moveToElement(element).perform();
	 }
	 
	 public WebElement waiteForElementVisible(By Locator ,int timeout)
	 {
		 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		 return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	 }
	 
	 public WebElement waitForElementClickable(By Locator,int timeout)
	 {
		 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		 return wait.until(ExpectedConditions.elementToBeClickable(Locator));

	 }
	 public void enterText(WebElement element,String text)
	 {
		 element.clear();
		 element.sendKeys(text); 
	 }
	 public String getPageTitl()
	 {
		 return driver.getTitle();
	 }
	 
	 public String getcurrentUrl()
	 {
		 return driver.getCurrentUrl();
	 }
	 
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
