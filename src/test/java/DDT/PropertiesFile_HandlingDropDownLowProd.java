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

public class PropertiesFile_HandlingDropDownLowProd {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\CommonData.properties");
		Properties prop =new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
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
		
		//Dropdown Handle
		WebElement DropDown = driver.findElement(By.className("product_sort_container"));
		Select s =new Select(DropDown);
		s.selectByIndex(2);
				
		//Add First product After Low price Selection
		driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
				
		//Validation
		String cartitem = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).getText();
				
		if(cartitem.equals("Sauce Labs Onesie"))
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
