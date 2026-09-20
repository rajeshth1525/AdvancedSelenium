package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdownZtoA {
	public static void main(String[] args)
	{
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/");
		
		//login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
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
