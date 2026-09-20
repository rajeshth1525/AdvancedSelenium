package PomDriver;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pom.DropDownPage;
import Pom.LoginPage;
import PomBaseTest.PomBaseClass;

public class HandlingDropDownLowZtoAproductTest extends PomBaseClass{
	@Test
	public void HandlingDropDownLowProd()
	{
		//login
		LoginPage lpg= new LoginPage(driver);
		lpg.login("standard_user", "secret_sauce");
		
		//Handling DropDown
		DropDownPage dd= new DropDownPage(driver);
		dd.ztoAProd();
		dd.getzToAProduct();
		dd.openCart();
		String productName = dd.getProductName();
		Assert.assertEquals(productName, "Test.allTheThings() T-Shirt (Red)");
		Reporter.log("First ZtoA product not Added SuccessFully", true);
		
	}

}
