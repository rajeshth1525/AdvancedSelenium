package Assertion;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HardAssert {
	@Test
	public void DemoHardassret()
	{
		String expected = "Facebook";
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual);// if failed stop the excecution
		System.out.println("Stepe1");
		
		
		
	}

}
