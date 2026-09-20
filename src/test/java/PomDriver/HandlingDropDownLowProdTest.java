package PomDriver;

import java.lang.annotation.Repeatable;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pom.DropDownPage;
import Pom.LoginPage;
import PomBaseTest.PomBaseClass;

public class HandlingDropDownLowProdTest extends PomBaseClass{
	@Test
	public void HandlingDropDownLowProd()
	{
		//login
		LoginPage lpg= new LoginPage(driver);
		lpg.login("standard_user", "secret_sauce");
		
		//Handle dropedown
		DropDownPage dd= new DropDownPage(driver);
		dd.lowToHigh();
		dd.getlowestProduct();
		dd.openCart();
		String prodName = dd.getProductName();
		Assert.assertEquals(prodName, "Sauce Labs Onesie");
		Reporter.log("Lowest product added successfully", true);
		
	}
	

}
