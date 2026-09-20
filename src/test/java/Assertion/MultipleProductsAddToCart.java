package Assertion;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import GenericUtility.ExcellUtility;
import GenericUtility.PropertiesUtility;
import GenericUtility.SeleniumUtility;

public class MultipleProductsAddToCart {
	public static void main(String[] args) throws Throwable 
	{
		//Read the Data from Properties file
		PropertiesUtility putil= new PropertiesUtility();
		String BROWSER = putil.ToreadDatafromPropertiesFile("browser");
		String URL = putil.ToreadDatafromPropertiesFile("url");
		String USERNAME = putil.ToreadDatafromPropertiesFile("username");
		String PASSWORD = putil.ToreadDatafromPropertiesFile("password");
		
		//TO Lounch the Browser fro Selenium Utility
		SeleniumUtility sutil= new SeleniumUtility();
		WebDriver driver = sutil.launchBrowser(BROWSER);
		driver.get(URL);
		
		sutil.enterText(driver.findElement(By.id("user-name")), USERNAME);
		sutil.enterText(driver.findElement(By.id("password")), PASSWORD);
		sutil.actionClick(driver.findElement(By.id("login-button")));
		
		//Read the Data From ExcellUtility
		ExcellUtility eutil= new ExcellUtility();
		String product1 = eutil.readDataFromExcell("Products", 1, 2);
		String product2 = eutil.readDataFromExcell("Products", 4, 3);
		String product3 = eutil.readDataFromExcell("Products", 7, 3);
		
		                //Add MultipleProduct
		//Add Product1
		sutil.actionClick(driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")));
		//Add Product2
		sutil.actionClick(driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")));
		//Add Product3
		sutil.actionClick(driver.findElement(By.id("add-to-cart-sauce-labs-onesie")));
	
		//click on Cartlink
		sutil.actionClick(driver.findElement(By.id("shopping_cart_container")));
		//Varify product is added or not using Remove Button
		WebElement Jacket = driver.findElement(By.id("remove-sauce-labs-fleece-jacket"));
		WebElement T_shirt = driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)"));
		WebElement Onesie = driver.findElement(By.id("remove-sauce-labs-onesie"));
		System.out.println("Remove button is showing of all 3 product");
	
		
		
		//Validation
		int Count = driver.findElements(By.className("inventory_item_name")).size();
		SoftAssert soft= new SoftAssert();
		soft.assertEquals(Count, 3);
		soft.assertTrue(Jacket.isDisplayed(), "Jacket is missmatch");
		soft.assertTrue(T_shirt.isDisplayed(), "T_shirt is missmatch");
		soft.assertTrue(Onesie.isDisplayed(), "Onesie is missmatch");
		soft.assertAll();
		System.out.println("CartCount is 3");
		
		
		//Logout
		sutil.actionClick(driver.findElement(By.id("react-burger-menu-btn")));
		WebElement logout = sutil.waitForElementClickable(By.id("logout_sidebar_link"), 10);
		sutil.actionClick(logout);;
		
		//closebrowser
		sutil.closeBrowser();
	}

}
