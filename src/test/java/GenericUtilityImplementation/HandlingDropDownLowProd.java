package GenericUtilityImplementation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import GenericUtility.ExcellUtility;
import GenericUtility.PropertiesUtility;
import GenericUtility.SeleniumUtility;

public class HandlingDropDownLowProd 
{
	public static void main(String[] args) throws Throwable {
		//Read The Data From PropertieUtility
		PropertiesUtility putil=new PropertiesUtility();
		String BROWSER = putil.ToreadDatafromPropertiesFile("browser");
		String URL = putil.ToreadDatafromPropertiesFile("url");
		String USERNAME = putil.ToreadDatafromPropertiesFile("username");
		String PASSWORD = putil.ToreadDatafromPropertiesFile("password");
		
		//Lounch the Browse Using SeleniumUtilty
		SeleniumUtility sutil= new SeleniumUtility();
		WebDriver driver = sutil.launchBrowser(BROWSER);
		
		//Open the URL
		driver.get(URL);
		
		//Login
		sutil.enterText(driver.findElement(By.id("user-name")), USERNAME);
		sutil.enterText(driver.findElement(By.id("password")), PASSWORD);
		sutil.actionClick(driver.findElement(By.id("login-button")));
		
		//Handle DropDown
		WebElement dropDown = driver.findElement(By.className("product_sort_container"));
		sutil.selectByVisibleText(dropDown, "Price (low to high)");
		
		//Read the Lowest Product from ExcelUtility
		ExcellUtility eutil= new ExcellUtility();
		String LowProduct = eutil.readDataFromExcell("Products", 4, 3);
		
		//Add first Low product
		WebElement AddLowProduct = driver.findElement(By.xpath("//div[text()='"+LowProduct+"']"));
		sutil.actionClick(AddLowProduct);
	
		WebElement AddBtn = driver.findElement(By.id("add-to-cart"));
		sutil.actionClick(AddBtn);
		
		WebElement cartIcon = driver.findElement(By.id("shopping_cart_container"));
		sutil.actionClick(cartIcon);
		
		//Validation
		String CartItem = driver.findElement(By.className("inventory_item_name")).getText();
		if(CartItem.contains(LowProduct))
		{
			System.out.println("Validatin Pass:"+LowProduct+" added successfully");
		}
		
		else
		{
			System.out.println("Validation Fail:Product Mismatch");
		}
		//Logout
		WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
		sutil.actionClick(menu);
		
		WebElement Logout = sutil.waitForElementClickable(By.id("logout_sidebar_link"), 10);
		sutil.actionClick(Logout);
		
		//close the browser
		sutil.closeBrowser();
		
		
		
		
		
	}

}
