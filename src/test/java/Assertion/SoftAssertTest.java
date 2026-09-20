package Assertion;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SoftAssertTest {
	@Test
	public void DemosoftAssert()
	{
		String ExpeTitle = "Faceboo"; //incorrect Expected
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		@Nullable
		String ActualTitle = driver.getTitle();
		SoftAssert soft= new SoftAssert(); //if code failed still..run the next step
		soft.assertEquals(ExpeTitle, ActualTitle);
		System.out.println("Step1");
		System.out.println("Step2");
		soft.assertAll();
		
	}

}
