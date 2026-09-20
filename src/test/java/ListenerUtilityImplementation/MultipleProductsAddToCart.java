package ListenerUtilityImplementation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ListenerBaseTest.BaseClass2;

@Listeners(ListenerUtility.ListenerImplementation2.class)

public class MultipleProductsAddToCart extends BaseClass2{
	@Test
	public void MultipleProductsAddToCartTest()
	{
		//Add 3 product
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//validation
		int CartItem = driver.findElements(By.className("inventory_item_name")).size();
		Assert.assertEquals(CartItem, 5);
		
	}
	@Test(enabled = false)
	public void skipptest()
	{
		System.out.println("intentionally we failing using enabled = false");
	}

}
