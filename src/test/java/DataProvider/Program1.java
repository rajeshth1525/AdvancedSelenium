package DataProvider;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Program1 {
	// Test method which will use data from DataProvider
	
	@Test(dataProvider = "logindata")
	public void login(String username ,String password)
	{
		Reporter.log("Login with :"+username+ "===="+password, true);
	}
	
	@DataProvider
	public Object[][] logindata()
	{
		Object[][] obj= new Object[3][2];
		obj[0][0]="Dhoni";
		obj[0][1]="Dhoni7";
		obj[1][0]="Virat";
		obj[1][1]="Virat18";
		obj[2][0]="Rohit";
		obj[2][1]="Rohit45";
		return obj;
	}
	
	

}
