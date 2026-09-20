package PomDriver;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pom.InventoryPage;
import Pom.LoginPage;
import PomBaseTest.PomBaseClass;

public class AddProdTocartTest extends PomBaseClass{
	@Test
	public void addProdTocart()
	{
		//login
		LoginPage lpg= new LoginPage(driver);
		lpg.login("standard_user", "secret_sauce");
		//Add Product
		InventoryPage inv= new InventoryPage(driver);
		inv.addProductToCart();
		inv.openCart();
		//Validation
		String ProdName = inv.getproductName();
		Assert.assertEquals(ProdName, "Sauce Labs Fleece Jacket");
		Reporter.log("Product Added Successfully", true);
	}
	

}
