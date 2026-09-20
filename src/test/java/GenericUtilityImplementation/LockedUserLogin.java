package GenericUtilityImplementation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import GenericUtility.JavaUtility;
import GenericUtility.PropertiesUtility;
import GenericUtility.SeleniumUtility;

public class LockedUserLogin {
	public static void main(String[] args) throws Throwable {
		//Read The Data From PropertiesUtility
		PropertiesUtility putil= new PropertiesUtility();
		String BROWSER = putil.ToreadDatafromPropertiesFile("browser");
		String URL = putil.ToreadDatafromPropertiesFile("url");
		String LOCKED_USERNAME=putil.ToreadDatafromPropertiesFile("locked_username");
		String PASSWORD = putil.ToreadDatafromPropertiesFile("password");
		
		//Lounch The Browser Usimg Selenium Utility
		SeleniumUtility sutil= new SeleniumUtility();
		WebDriver driver = sutil.launchBrowser(BROWSER);
		
		//Open the URL
		driver.get(URL);
		
		//Login with Locked USer 
		
		sutil.enterText(driver.findElement(By.id("user-name")), LOCKED_USERNAME);
		sutil.enterText(driver.findElement(By.id("password")), PASSWORD);
		sutil.actionClick(driver.findElement(By.id("login-button")));
		
		//Validation Error Msg
		String errormsg = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
		
		if(errormsg.contains("Epic sadface: Sorry, this user has been locked out."))
		{
			System.out.println("Validation Pass: Locked User login Failed as Expected");
		}
		
		else
		{
			System.out.println("Validation Fail:Unexpected Behaviour");
		}
		
		JavaUtility jutil= new JavaUtility();
		System.out.println("SystemDate:"+jutil.getSystemDate());
		System.out.println("FormatedDate:"+jutil.getFormatDate());
		System.out.println("UniQue Run Id:"+jutil.getrandomNumber());
		
		//close the Browser
		sutil.closeBrowser();
		
		 
		
	}

}
