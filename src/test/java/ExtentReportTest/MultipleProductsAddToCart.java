package ExtentReportTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ListenerBaseTest.BaseClass2;

@Listeners(ListenerUtility.ExtentReportListener.class)

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
		System.out.println("Test Faile..cartitem count is mismatcg");
		
	}
	@Test
	public void skipptest()
	{
		throw new SkipException("This Test is skipp");
		
	}



}
