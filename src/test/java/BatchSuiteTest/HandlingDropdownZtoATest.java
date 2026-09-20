package BatchSuiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import SuiteBaseTest.BaseClass;

public class HandlingDropdownZtoATest extends BaseClass {
	@Test(groups = "regression")
	public void HandlingDropdownZtoA()
	{
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
			Reporter.log("Z To A Product Added Succesfully", true);
		}
		else
		{
			Reporter.log("Z To A Product not Added Succefully", true);
		}
	}

}
