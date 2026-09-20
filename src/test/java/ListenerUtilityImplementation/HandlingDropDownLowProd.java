package ListenerUtilityImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ListenerBaseTest.BaseClass2;

@Listeners(ListenerUtility.ListenerImplementation2.class)
public class HandlingDropDownLowProd  extends BaseClass2{
	@Test
	public void HandlingDropDownLowProdTest()
	{
		//dropdown handle
		WebElement DropDown = driver.findElement(By.className("product_sort_container"));
		Select s =new Select(DropDown);
		s.selectByIndex(2);
		
		//Add First product After Low price Selection
		driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		
		//Validation
		String cartitem = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).getText();
		//intentianlly we are failing this
		Assert.assertEquals(cartitem, "wrong Onesie");
		
		
	}
	
	@Test(enabled = false)
	public void skippedTest()
	{
		System.out.println("This test is skipped");
	}

}
