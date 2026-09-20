package ListenerBaseTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass2 {
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
		driver= new EdgeDriver();
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
		//we are keeping login part (UN,PW) here
	
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();	
		Reporter.log("Login succesfully", true);
		
	}
	
	//logout
	@AfterMethod
	public void aftermethod()
	{
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		Reporter.log("Logout succesfully", true);
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
