package PomDriver;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pom.LoginPage;
import PomBaseTest.PomBaseClass;

public class LockedUser extends PomBaseClass{
	@Test
	public void LockedUserTest()
	{
		LoginPage loginpg= new LoginPage(driver);
		loginpg.login("locked_out_user", "secret_sauce");
		String error = loginpg.errormessage();
		Assert.assertTrue(error.contains("Epic sadface"), "Unexpected error msg");
		Reporter.log("Getting error msg", true);
	}
	
	

}
