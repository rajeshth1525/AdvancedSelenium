package BaseTest;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
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
	public void lounchApp() throws Throwable      //>>>Lounch Browse and And Url
	{
		String BROWSER = putil.ToreadDatafromPropertiesFile("browser");
		String URL = putil.ToreadDatafromPropertiesFile("url");
		
		//Browser Selection Logic Via Selenium utility
		driver=sutil.launchBrowser(BROWSER);
		driver.get(URL);
		Reporter.log("Browser Laounch + Url Done", true);
			
	}
	
	@BeforeMethod
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
	
	@AfterMethod
	public void logout()   //Logout the Application
	{
		sutil.actionClick(driver.findElement(By.id("react-burger-menu-btn")));
		sutil.waiteForElementVisible(By.id("logout_sidebar_link"), 10);
		Reporter.log("Logout SuccessFully", true);
	}
	
	@AfterClass
	public void closeBrowser() //>>>CLose The Browser
	{
		sutil.closeBrowser();
		Reporter.log("Browser Close", true);
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
