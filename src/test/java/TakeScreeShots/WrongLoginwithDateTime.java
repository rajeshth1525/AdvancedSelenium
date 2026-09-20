package TakeScreeShots;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class WrongLoginwithDateTime {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/");
		
		try {
			// Wrong credentials
			driver.findElement(By.id("user-name")).sendKeys("WrongUN");
			driver.findElement(By.id("password")).sendKeys("WrongPW");
			driver.findElement(By.id("login-button")).click();
			// Error message capture
			String errormsg = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
			System.out.println("Login failed with error:"+errormsg);
			// Create Date object
			Date d= new Date();
			// Format date-time for file name
			SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd_HHmmss");
			String newdate = sdf.format(d);
			// Screenshot capture
			TakesScreenshot ts= (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest= new File("./ScreenShots/WrongLogin_"+newdate+".png");
			FileHandler.copy(src, dest);
			System.out.println("Screenshot Save at:"+dest.getAbsolutePath());
			
			
		} catch (IOException io) {
			System.out.println("Failed to save screenshot :"+io.getMessage());
			
		}
		finally {
			driver.quit();
			System.out.println("Browser close successfully");
		}
	}

}
