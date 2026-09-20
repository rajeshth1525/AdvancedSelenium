package ListenerUtilityImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ListenerBaseTest.BaseClass2;

@Listeners(ListenerUtility.ListenerImplementation2.class)

public class HandlingDropdownZtoA extends BaseClass2{
	@Test
	public void HandlingDropdownZtoATest()
	{
		//Dropdown handle
		WebElement DropDown = driver.findElement(By.className("product_sort_container"));
		Select s= new Select(DropDown);
		s.selectByVisibleText("Name (Z to A)");
		
		//Add First Product after Z to A Selection
		driver.findElement(By.className("inventory_item_name")).click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		
		String Cartitem = driver.findElement(By.className("inventory_item_name")).getText();
		//intentianlayy we are failing
		Assert.assertEquals(Cartitem, "Wrong low product");
	}
	@Test(enabled = false)
	public void skippedTest()
	{
		System.out.println("This test is skipp due to (enabled = false)");
	}

}
