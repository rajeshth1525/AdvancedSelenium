package BatchSuiteTest;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import SuiteBaseTest.BaseClass;

public class LockedUserLoginTest extends BaseClass {
	@Override
	public void loginApp()
	{
		//SKipp this method in base class due to  we need locked user name
	}
	
	
	@Test(groups = "smoke")
	public void LockedUserLogin()
	{
		
		//login with locked user by manually
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
		
		//Validation
		String errormsg = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
		if(errormsg.contains("Epic sadface: Sorry, this user has been locked out."))
		{
			Reporter.log("Logged in With Locked User", true);
		}
		else 
		{
			Reporter.log("Logged in with Diffrent User", true);
		}
		
	}

}
