package JsonUtility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import GenericUtility.ExcellUtility;
import GenericUtility.SeleniumUtility;

public class MultipleProductsAddToCart {
	public static void main(String[] args) throws Throwable {
		FileReader reader= new FileReader("./src\\test\\resources\\CommonData.json");
		JSONParser parser= new JSONParser();
		Object javaobj = parser.parse(reader);
		JSONObject jsonobj=(JSONObject)javaobj;
		String BROWSER = jsonobj.get("browser").toString();
		String URL = jsonobj.get("url").toString();
		String USERNAME = jsonobj.get("username").toString();
		String PASSWORD = jsonobj.get("password").toString();
		
		//Lounch the Browser Using SeleniumUtility
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
		
		
		//Validation
		int Count = driver.findElements(By.className("inventory_item_name")).size();
		if(Count==3)
		{
			System.out.println("Validation Pass: 3 item added successfully");
		}
		else
		{
			System.out.println("Validation Fail:Expected 3 but found"+Count);
		}
		
		//Logout
		sutil.actionClick(driver.findElement(By.id("react-burger-menu-btn")));
		WebElement logout = sutil.waitForElementClickable(By.id("logout_sidebar_link"), 10);
		sutil.actionClick(logout);;
		
		//closebrowser
		sutil.closeBrowser();
		
	}

}
