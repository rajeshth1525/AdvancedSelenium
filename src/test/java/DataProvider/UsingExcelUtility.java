package DataProvider;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsingExcelUtility {
	
	@Test(dataProvider = "excelData")
	public void loginTest(String username,String password)
	{
		Reporter.log("Login With :"+username+ "=====" +password, true);
	}
	
	
	@DataProvider
	public Object[][] excelData() throws Throwable
	{
		ExcellUtility_DP eutil= new ExcellUtility_DP();
		int totalrow = eutil.rowcount("Dataprovider");
		
		Object[][] obj =new Object[totalrow +1][2];
		for(int i=1; i<=totalrow +1; i++)
		{
			obj[i][0]=eutil.readDatafromExcell("Dataprovider", i, 0);
			obj[i][1]=eutil.readDatafromExcell("Dataprovider", i, 1);
			
		}
		return obj;
		
	}
			

}
