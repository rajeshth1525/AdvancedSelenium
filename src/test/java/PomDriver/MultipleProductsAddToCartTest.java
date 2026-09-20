package PomDriver;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ListenerBaseTest.BaseClass;
import Pom.LoginPage;
import Pom.MultipleProd;

public class MultipleProductsAddToCartTest extends BaseClass{
	@Test
	public void addMultipleProducts() 
	{
		//Login
		LoginPage lpg= new LoginPage(driver);
		lpg.login("standard_user", "secret_sauce");
		
		//Add Multiple Product
		MultipleProd multi= new MultipleProd(driver);
		multi.addMultiProduct();
		multi.openCart();
		int cartCount = multi.getcartcount();
		Assert.assertEquals(cartCount, 3);
		Reporter.log("Cartcount and inventory count are same ", true);
		
	}

}
