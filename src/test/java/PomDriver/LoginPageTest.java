package PomDriver;

import org.testng.annotations.Test;

import Pom.LoginPage;
import PomBaseTest.PomBaseClass;

public class LoginPageTest extends PomBaseClass {
	@Test
	public void loginPageTest()
	{
		LoginPage loginpg= new LoginPage(driver);
		loginpg.login("standard_user", "secret_sauce");
		
	}

}
