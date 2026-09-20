package BaseTest;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddProdToCartTest extends BaseClass
{
	@Test
	public void AddProdToCart()
	{
		//Add Product
		driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
				
		//Validation
				
		String CartItem = driver.findElement(By.className("inventory_item_name")).getText();
				
		if(CartItem.equals("Sauce Labs Fleece Jacket"))
		{
			Reporter.log("Product Added Successfully to Cart", true);
		}
		else
		{
			Reporter.log("Product Not added tocart", true);
		}
	}
	

}
