package Smoke_RegressionTest;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import SuiteBaseTest.BaseClass;

public class MultipleProductsAddToCartTest extends BaseClass{
	
	@Test
	public void MultipleProductsAddToCart()
	{
		//Add Multiple Product to Cart
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//validation
		int CartItem = driver.findElements(By.className("inventory_item_name")).size();
		if(CartItem==3)
		{
			Reporter.log("3 product Added to the Cart", true);
		}
		else
		{
			Reporter.log("Prodct count MIsmatch", true);
		}
	}

}
