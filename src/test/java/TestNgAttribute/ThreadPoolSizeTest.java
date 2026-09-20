package TestNgAttribute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ThreadPoolSizeTest {
	@Test(invocationCount = 4 ,threadPoolSize = 2)
	public void login() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		Reporter.log("Login done by Thread:  " +Thread.currentThread().getId(), true);
		Thread.sleep(20);
		driver.quit();
	}

}
