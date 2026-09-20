package ListenerUtilityImplementation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ListenerBaseTest.BaseClass;

@Listeners(ListenerUtility.ListenerImplementation.class)

public class LockedUserLogin extends BaseClass{
	@Test
	public void LockedUserLoginTest()
	{
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//Validation
		String errormsg = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
		Assert.assertTrue(errormsg.contains("invalid credential"), "Not getting correct msg");
	}
	@Test(enabled = false)
	public void skipptest()
	{
		System.out.println("intentionally we Skipp using enabled = false");
	}

}
