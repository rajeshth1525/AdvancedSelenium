package SuiteBaseTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

import GenericUtility.PropertiesUtility;
import GenericUtility.SeleniumUtility;

public class BaseClass {
	public WebDriver driver=null;
	public PropertiesUtility putil=new PropertiesUtility();
	public SeleniumUtility sutil= new SeleniumUtility();
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void beforesuite()
	{
		Reporter.log("DB Open", true);
	}
	
	@BeforeTest(groups = {"smoke","regression"})
	public void beforeTest()
	{
		Reporter.log("Precondition Start", true);
	}
	
	@BeforeClass(groups = {"smoke","regression"})
	public void lounchApp() throws Throwable      //>>>Lounch Browse and And Url
	{
		String BROWSER = putil.ToreadDatafromPropertiesFile("browser");
		String URL = putil.ToreadDatafromPropertiesFile("url");
		
		//Browser Selection Logic Via Selenium utility
		driver=sutil.launchBrowser(BROWSER);
		driver.get(URL);
		Reporter.log("Browser Laounch + Url Done", true);
			
	}
	
	@BeforeMethod(groups = {"smoke","regression"})
	public void loginApp() throws Throwable     //>>>>Login to the App
	{
		//Read the Data From PropertiesUtility
		String USERNAME = putil.ToreadDatafromPropertiesFile("username");
		String PASSWORD = putil.ToreadDatafromPropertiesFile("password");
		
		sutil.enterText(driver.findElement(By.id("user-name")), USERNAME);
		sutil.enterText(driver.findElement(By.id("password")), PASSWORD);
		sutil.actionClick(driver.findElement(By.id("login-button")));
		
		Reporter.log("Login Successfully", true);
		
	}
	
	@AfterMethod(groups = {"smoke","regression"})
	public void logout()   //Logout the Application
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
	
	@AfterClass(groups = {"smoke","regression"})
	public void closeBrowser() //>>>CLose The Browser
	{
		if(driver!=null)
		{
			driver.quit();
			Reporter.log("Browser Close", true);
		}
	}
	
	@AfterTest(groups = {"smoke","regression"})
	public void afterTest()
	{
		Reporter.log("Post Condition done ", true);
		
	}
	
	@AfterSuite(groups = {"smoke","regression"})
	public void  aftersuite()
	{
		Reporter.log("DB close", true);
	}

}
