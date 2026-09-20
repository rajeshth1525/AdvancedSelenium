package ExtentReportTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ListenerBaseTest.BaseClass2;

@Listeners(ListenerUtility.ExtentReportListener.class)

public class AddProdToCart extends BaseClass2 {
	@Test
	public void AddProdToCartTest()
	{
		
		//Add Product
		driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//Validation
		
		String CartItem = driver.findElement(By.className("inventory_item_name")).getText();
		//Intentionally fail this for taking Screenshot
		Assert.assertEquals(CartItem, "Wrong Product ");
	}
	
	@Test
	public void skippedTest()
	{
		throw new SkipException("This test is skipped intentianalyy");
	}



}
