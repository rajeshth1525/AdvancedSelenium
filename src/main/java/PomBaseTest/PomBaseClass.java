package PomBaseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class PomBaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	@BeforeClass
	public void lounchBrowser()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/");
		sdriver=driver;
		Reporter.log("Browser Lounched", true);	
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("Browser Close", true);
	}

}
