package JsonUtility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import GenericUtility.ExcellUtility;
import GenericUtility.SeleniumUtility;

public class HandlingDropdownZtoA {
	public static void main(String[] args) throws Throwable {
		FileReader reader= new FileReader("./src\\test\\resources\\CommonData.json");
		JSONParser parser= new JSONParser();
		Object javaobj = parser.parse(reader);
		JSONObject jsonobj= (JSONObject)javaobj;
		String BROWSER = jsonobj.get("browser").toString();
		String URL = jsonobj.get("url").toString();
		String USERNAME = jsonobj.get("username").toString();
		String PASSWORD = jsonobj.get("password").toString();
		
		//LOunch the Browser Using Selenium utility
		SeleniumUtility sutil= new SeleniumUtility();
		WebDriver driver = sutil.launchBrowser(BROWSER);
		
		//Open the URL
		driver.get(URL);
		
		//Login
		sutil.enterText(driver.findElement(By.id("user-name")), USERNAME);
		sutil.enterText(driver.findElement(By.id("password")), PASSWORD);
		sutil.actionClick(driver.findElement(By.id("login-button")));
		
		//Dropdown Handle
		WebElement dropdown = driver.findElement(By.className("product_sort_container"));
		sutil.actionClick(dropdown);
		
		//Read Z to A propduct From ExcellUtilty
		ExcellUtility eutil= new ExcellUtility();
		String ProductName = eutil.readDataFromExcell("Products", 7, 3);
		
		//Add the Product
		
		WebElement ZtoA_Product = driver.findElement(By.xpath("//div[text()='"+ProductName+"']"));
		sutil.actionClick(ZtoA_Product);
		
		WebElement addbtn = driver.findElement(By.id("add-to-cart"));
		sutil.actionClick(addbtn);
		
		WebElement CartLink = driver.findElement(By.className("shopping_cart_link"));
		sutil.actionClick(CartLink);
		
		//Validation
		String CartItem = driver.findElement(By.className("inventory_item_name")).getText();
		if(CartItem.equals(ProductName))
		{
			System.out.println("Validation Pass:"+ProductName+" Added Successfully");
		}
		else
		{
			System.out.println("Validation Fail:Product MissMatch");
		}
		
		//Logout
		WebElement Menu = driver.findElement(By.id("react-burger-menu-btn"));
		sutil.actionClick(Menu);
		
		WebElement Logout = sutil.waitForElementClickable(By.id("logout_sidebar_link"), 10);
		sutil.actionClick(Logout);
		
		//close browser
		sutil.closeBrowser();
	}

}
