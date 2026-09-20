package Assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;

public class HandlingDropdownZtoATest extends BaseClass {
	
	//Base Clas And Test Annotion by assertion
	
	@Test
	public void HandlingDropdownZtoA()
	{
		//Handle DropDown
		WebElement DropDown = driver.findElement(By.className("product_sort_container"));
		Select s= new Select(DropDown);
		s.selectByVisibleText("Name (Z to A)");
		
		//Add First Product after Z to A Selection
		 driver.findElement(By.className("inventory_item_name")).click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		
		String Cartitem = driver.findElement(By.className("inventory_item_name")).getText();//Test.allTheThings() T-Shirt (Red)
		Assert.assertEquals(Cartitem, "Test.allTheThings() T-Shirt (Red)");
		System.out.println( "Cartitem, and Test allTheThings T-Shirt Red are same");
	}

}
