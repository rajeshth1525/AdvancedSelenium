package TestNgAttribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvocationCountTest {
	@Test(invocationCount = 2)
	public void login()
	{
		Reporter.log("Login Successufully", true);
	}
	
	@Test(invocationCount = 3)
	public void logout()
	{
		Reporter.log("Logout successfully", true);
	}

}
