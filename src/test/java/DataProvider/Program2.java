package DataProvider;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Program2 {
	
	// Test method which will use data from DataProvider
	@Test(dataProvider = "studentdata")
	public void studentinfo(String name,int rollNo, String grade)
	{
		Reporter.log("Student:"+name+" ,|Roll No:"+rollNo+" ,|Grade:"+grade, true);
	}
	
	@DataProvider
	public Object[][] studentdata()
	{
		Object[][] obj= new Object[3][3];
		obj[0][0]="Rjesh";
	    obj[0][1]=101;
	    obj[0][2]="A";
	    obj[1][0]="Yuvash";
	    obj[1][1]=102;
	    obj[1][2]="B";
	    obj[2][0]="Shubhangi";
	    obj[2][1]=103;
	    obj[2][2]="c";
	    return obj;
	    		
	}

}
