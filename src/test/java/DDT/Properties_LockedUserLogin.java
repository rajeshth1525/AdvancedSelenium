package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Properties_LockedUserLogin {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("src\\test\\resources\\CommonData.properties");
		Properties p= new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String LOCKED_USERNAME = p.getProperty("locked_username");
		String PASSWORD=p.getProperty("password");
		
		WebDriver driver= null;
		if(BROWSER.equalsIgnoreCase("Edge"))
		{
			driver= new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		//Login with Locked User
		driver.findElement(By.id("user-name")).sendKeys(LOCKED_USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		//Validation
		String errormsg = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
		if(errormsg.contains("Epic sadface: Sorry, this user has been locked out."))
		{
			System.out.println("Pass");
		}
		else 
		{
			System.out.println("Fail");
		}
		driver.quit();
	}
	

}
