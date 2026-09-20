package ListenerBaseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	@BeforeSuite
	public void beforsuite()
	{
		Reporter.log("Establish DB Connection", true);
	}
	
	@BeforeTest
	public void beforetest()
	{
		Reporter.log("Precondition Start", true);
	}
	
	//Browser Launched and Url
	@BeforeClass
	public void beforeclass()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/");
		sdriver=driver;   //To get the driver instance to the listener
		Reporter.log("Browser Launched",true);	
		
	}
	
	//UserName Password
	@BeforeMethod
	public void beforemethod()
	{
		//we can keep login part (UN,PW) here
		Reporter.log("Login step dummy", true);
		
	}
	
	//logout
	@AfterMethod
	public void aftermethod()
	{
		Reporter.log("Logout step", true);
		//we can keep logout part here

	}
	//Browser close
	@AfterClass
	public void  afterclass()
	{
		driver.quit();
		Reporter.log("Browser close ", true);
	}
	
	@AfterSuite
	public void aftersuite()
	{
		Reporter.log("Precondition Stop", true);
	}
	
	
	
	
	
	

}
