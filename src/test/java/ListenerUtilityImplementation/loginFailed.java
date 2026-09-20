package ListenerUtilityImplementation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import ListenerBaseTest.BaseClass;

@Listeners(ListenerUtility.ListenerImplementation.class)
public class loginFailed extends BaseClass {
	@Test
	public void loginfailedtest()
	{
		driver.findElement(By.id("user-name")).sendKeys("WrongUN");
		driver.findElement(By.id("password")).sendKeys("WrongPW");
		driver.findElement(By.id("login-button")).click();
		
		String errormsg = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
		//intentionally we are failing using diffrent error msg(Invalid Credential)
		Assert.assertTrue(errormsg.contains("Invalid Credential"), "Login did not failed ass expected");
	}
	
	@Test(enabled = false)
	public void skippedTest()
	{
		System.out.println("This test is skipped intentionally due to(enabled = false)");
	}
	

}
