package TestNgAttribute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvocationCountTest2 {
	@Test(invocationCount = 3)
	public void login() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		Reporter.log("login done", true);
		Thread.sleep(20);
		driver.quit();
	}

}
