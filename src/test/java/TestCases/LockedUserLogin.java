package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LockedUserLogin {
	public static void main(String[] args) {
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/");
		
		//Login with Locked User
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
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
