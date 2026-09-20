package GenericUtilityImplementation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import GenericUtility.ExcellUtility;
import GenericUtility.PropertiesUtility;
import GenericUtility.SeleniumUtility;

public class AddProdToCart {
	public static void main(String[] args) throws Throwable {
		//Read The Data from PropertiesUtility
		PropertiesUtility plib= new PropertiesUtility();
		String BROWSER = plib.ToreadDatafromPropertiesFile("browser");
		String URL = plib.ToreadDatafromPropertiesFile("url");
		String USERNAME = plib.ToreadDatafromPropertiesFile("username");
		String PASSWORD = plib.ToreadDatafromPropertiesFile("password");
		
		//Lounch The Browser
		SeleniumUtility sutil= new SeleniumUtility();
		WebDriver driver = sutil.launchBrowser(BROWSER);
		
		//Open The URL
		driver.get(URL);
		
		//Login(using entertext + actionsclick)
		WebElement userfield = driver.findElement(By.id("user-name"));
		sutil.enterText(userfield, USERNAME);
		WebElement passfield = driver.findElement(By.id("password"));
		sutil.enterText(passfield, PASSWORD);
		WebElement loginbtn = driver.findElement(By.id("login-button"));
		sutil.actionClick(loginbtn);
		
		//Read The Data Using ExcelUtility
		ExcellUtility eutil= new ExcellUtility();
		String productName = eutil.readDataFromExcell("Products", 1, 2);
		
		//Add the Product
		driver.findElement(By.xpath("//div[text()='"+productName+"']")).click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//Validation
		String Cartitem = driver.findElement(By.className("inventory_item_name")).getText();
		if(Cartitem.equals(productName))
		{
			System.out.println("Validation Pass:"+productName+" added Succesfully");
		}
		else
		{
			System.out.println("Validation Fail:Product MissMatch");
		}
		
		//LogOut Using Selenium Utility
		WebElement Menu = driver.findElement(By.id("react-burger-menu-btn"));
		sutil.actionClick(Menu);
	
		WebElement logout = sutil.waitForElementClickable(By.id("logout_sidebar_link"), 10);
		sutil.actionClick(logout);
		
		sutil.closeBrowser();
		
		
		
		
		
		
		
		
	}

}
