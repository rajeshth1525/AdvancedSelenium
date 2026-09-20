package BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HandlingDropDownLowProdTest extends BaseClass
{
	@Test
	public void HandlingDropDownLowProd()
	{
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
			Reporter.log("Lowest Product added Successfully", true);
		}
		else
		{
			Reporter.log("Lowest Product not Added", true);
		}
	}

}
