package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Propertiesfile_HandlingDropdownZtoA {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\CommonData.properties");
		Properties prop =new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("Edge"))
		{
			driver= new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		//login
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		//DropDown Handle
		WebElement DropDown = driver.findElement(By.className("product_sort_container"));
		Select s= new Select(DropDown);
		s.selectByVisibleText("Name (Z to A)");
				
		//Add First Product after Z to A Selection
		driver.findElement(By.className("inventory_item_name")).click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
				
		String Cartitem = driver.findElement(By.className("inventory_item_name")).getText();
		if(Cartitem.equals("Test.allTheThings() T-Shirt (Red)"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
				
		driver.quit();
	}

}
