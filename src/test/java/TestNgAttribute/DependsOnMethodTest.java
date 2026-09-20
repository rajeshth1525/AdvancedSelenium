package TestNgAttribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOnMethodTest {
	
	//Create Account
	@Test
	public void createAccount()
	{
		Reporter.log("Account Created", true);
	}
	
	
	//Edit Account depends on createAcc
	@Test(dependsOnMethods = "createAccount")
	public void editaccount()
	{
		Reporter.log("Account Edited", true);
	}
	
	
	//Delete Account depends on editAcc
	@Test(dependsOnMethods = "editaccount")
	
	public void deletAccount()
	{
		Reporter.log("Account deleted", true);
	}
		
	//<<<<<<editAcc() and deleteAcc() depend on createAcc()>>>>>>>>>>>>

}
