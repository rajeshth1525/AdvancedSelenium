package TestNgAttribute;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FailedDependsonMethod {
	//Force Faile to Create Account 
	@Test
	public void createAccount()
	{
		Assert.fail("Create Account Failed");
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
		
	//<<<<<<editAcc() and deleteAcc() depend on createAcc() so both are skipped>>>>>>>>>>>>
		

}
