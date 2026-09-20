package JsonUtility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import GenericUtility.ExcellUtility;
import GenericUtility.SeleniumUtility;

public class HandlingDropDownLowProd {
	public static void main(String[] args) throws Throwable {
		//Read data from json file
		FileReader reader= new FileReader("./src\\test\\resources\\CommonData.json");
		JSONParser parser= new JSONParser();
		Object javaobj = parser.parse(reader);
		JSONObject jsonobj=(JSONObject)javaobj;
		String BROWSER = jsonobj.get("browser").toString();
		String URL = jsonobj.get("url").toString();
		String USERNAME = jsonobj.get("username").toString();
		String PASSWORD = jsonobj.get("password").toString();
		
		//Lounch the Browser using selenium Utility
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
			System.out.println("Validation Pass:"+LowProduct+" added successfully");
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
