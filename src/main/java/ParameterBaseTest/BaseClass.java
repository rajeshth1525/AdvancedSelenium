package ParameterBaseTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import GenericUtility.PropertiesUtility;
import GenericUtility.SeleniumUtility;

public class BaseClass {
	public WebDriver driver=null;
	public PropertiesUtility putil=new PropertiesUtility();
	public SeleniumUtility sutil= new SeleniumUtility();
	
	@BeforeSuite
	public void beforesuite()
	{
		Reporter.log("DB Open", true);
	}
	
	@BeforeTest
	public void beforeTest()
	{
		Reporter.log("Precondition Start", true);
	}
	
	@BeforeClass
	@Parameters({"BROWSER","URL"}) //Takeing Browser and Url From Parameter XMl
	public void lounchApp(String browser , String url)      //>>>Lounch Browse and And Url
	{
		if(browser.equalsIgnoreCase("chrome")) {
	        driver = new ChromeDriver();
	    } else if(browser.equalsIgnoreCase("edge")) {
	        driver = new EdgeDriver();
	    } else if(browser.equalsIgnoreCase("firefox")) {
	        driver = new FirefoxDriver();
	    }
	    driver.get(url);
		Reporter.log("Browser Laounch + Url Done", true);
			
	}
	
	@BeforeMethod
	@Parameters({"USERNAME","PASSWORD"}) //Takeing UserName and Pwd From Parameter XMl
	public void loginApp(String user , String pass )      //>>>>Login to the App
	{
		driver.findElement(By.id("user-name")).sendKeys(user);   // Username enter
	    driver.findElement(By.id("password")).sendKeys(pass);    // Password enter
	    driver.findElement(By.id("login-button")).click();  
		
		Reporter.log("Login Successfully", true);
		
	}
	
	@AfterMethod
	public void logout() throws InterruptedException   //Logout the Application
	{
		// Step 1: Click menu
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
        menu.click();

        // Step 2: Wait until logout link clickable
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        logout.click();

        Reporter.log("Logout Successfully", true);
			
	}
	
	@AfterClass
	public void closeBrowser() //>>>CLose The Browser
	{
		if(driver!=null)
		{
			driver.quit();
			Reporter.log("Browser Close", true);
		}
	}
	
	@AfterTest
	public void afterTest()
	{
		Reporter.log("Post Condition done ", true);
		
	}
	
	@AfterSuite
	public void  aftersuite()
	{
		Reporter.log("DB close", true);
	}

}
